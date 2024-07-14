import { Schema, model, Document } from "mongoose";

interface IUser extends Document {
  email: string;
  password: string;
  username: string;
  timestamp: Date;
}

const UserSchema = new Schema({
  email: { type: String, required: true, unique: true },
  password: { type: String, required: true },
  username: { type: String, required: true },
  timeStamp: { type: Date, default: Date.now },
});

export default model<IUser>("User", UserSchema);
