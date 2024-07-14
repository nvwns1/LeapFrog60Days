import { Router } from "express";
import { body, validationResult } from "express-validator";
import userController from "../controller/userController";

const router = Router();

router.get("/", (req, res) => {
  res.send("Test From Users Route");
});

router.post(
  "/register",
  [
    body("username")
      .isString()
      .withMessage("Enter Valid Username")
      .isLength({ min: 3 })
      .withMessage("Username must be at least 3 characters long"),
    body("password")
      .isString()
      .withMessage("Enter Valid Password")
      .isLength({ min: 6 })
      .withMessage("Password must be at least 6 characters long")
      .bail(), // Add .bail() here to stop validation on first error
    body("email").isEmail().withMessage("Enter Valid Email"),
  ],
  userController.createuser
);

router.post("/login", userController.login);

router.put(
  "/update-password",
  [
    body("password")
      .isString()
      .withMessage("Enter Valid Password")
      .isLength({ min: 6 })
      .withMessage("Password must be at least 6 characters long"),

    body("newPassword")
      .isString()
      .withMessage("Enter Valid Password")
      .isLength({ min: 6 })
      .withMessage("New Password must be at least 6 characters long"),
  ],
  userController.updatePassword
);

export default router;
