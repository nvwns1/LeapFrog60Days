import mongoose from "mongoose";
import dotenv from "dotenv";

dotenv.config();

const mongoURI = process.env.MONGODB_URI as string;

const connectToDB = async () => {
  mongoose
    .connect(mongoURI)
    .then(() => {
      console.log("Connnected to Mongodb");
    })
    .catch((error) => {
      console.log("Error connecting to Mongodb", error);
    });
};

export default connectToDB;
