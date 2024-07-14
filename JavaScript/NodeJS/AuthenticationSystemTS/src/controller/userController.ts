import { Request, Response } from "express";
import { validationResult } from "express-validator";
import jwt from "jsonwebtoken";
import bcrypt from "bcrypt";
import User from "../model/User";
import "dotenv/config";

class UserController {
  createuser = async (req: Request, res: Response) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      const errormsg = errors.array().map((err) => err.msg);
      return res.status(400).json({ message: errormsg, success: false });
    }
    try {
      const { username, password } = req.body;

      const userExist = await User.findOne({ username });
      if (userExist) {
        return res
          .status(400)
          .json({ message: "User already exists", success: false });
      }
      const saltRounds = parseInt(process.env.PASSWORD_SALT as string);
      const plainTextPassword = password;

      const hashedPassword = await bcrypt.hash(plainTextPassword, saltRounds);

      const response = User.create({ ...req.body, password: hashedPassword });

      if (response === null) {
        return res.json([{ message: "User not created", success: false }]);
      } else {
        const token = jwt.sign(
          { id: (await response)._id },
          process.env.JWT_SECRET as string
        );
        return res
          .status(200)
          .json({ message: "User Created ", token, success: true });
      }
    } catch (error: any) {
      return res.status(500).json({ message: error.message, success: false });
    }
  };

  login = async (req: Request, res: Response) => {
    try {
      const { username, password } = req.body;

      const user = await User.findOne({
        $or: [{ username }, { email: username }],
      });

      if (!user) {
        return res
          .status(400)
          .json({ message: "User does not exist", success: false });
      }
      const validPassword = await bcrypt.compare(password, user.password);
      if (!validPassword) {
        return res
          .status(400)
          .json({ message: "Invalid Password", success: false });
      }
      const token = jwt.sign(
        { id: user._id },
        process.env.JWT_SECRET as string
      );
      return res
        .status(200)
        .json({ message: "User Logged In", token, success: true });
    } catch (error: any) {
      return res.status(500).json({ message: error.message, success: false });
    }
  };

  updatePassword = async (req: Request, res: Response) => {
    try {
      const errors = validationResult(req);
      if (!errors.isEmpty()) {
        const errormsg = errors.array().map((err) => err.msg);
        return res.status(400).json({ message: errormsg, success: false });
      }
      const { token, password, newPassword } = req.body;
      if (!token) {
        return res
          .status(400)
          .json({ message: "Token not found", success: false });
      }

      if (password === newPassword) {
        return res
          .status(400)
          .json({
            message: "New Password cannot be same as old password",
            success: false,
          });
      }

      const decoded = jwt.verify(token, process.env.JWT_SECRET as string);
      const userId = (decoded as any).id;

      const user = await User.findById(userId);
      if (!user) {
        return res
          .status(400)
          .json({ message: "User not found", success: false });
      }
      const validPassword = await bcrypt.compare(password, user.password);
      if (!validPassword) {
        return res
          .status(400)
          .json({ message: "Invalid Password", success: false });
      }
      const saltRounds = parseInt(process.env.PASSWORD_SALT as string);
      const hashedPassword = await bcrypt.hash(newPassword, saltRounds);

      user.password = hashedPassword;
      await user.save();
      return res
        .status(200)
        .json({ message: "Password Updated", success: true });
    } catch (error: any) {
      return res.status(500).json({ message: error.message, success: false });
    }
  };
}

export default new UserController();
