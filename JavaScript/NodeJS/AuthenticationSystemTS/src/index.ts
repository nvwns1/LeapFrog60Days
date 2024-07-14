import express, { Application } from "express";
import cors from "cors";
import dotenv from "dotenv";
import connectToDB from "./config/db";
import userRoutes from "./routes/userRoutes";

dotenv.config();

const PORT = process.env.PORT || 8000;

const app: Application = express();
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

connectToDB();

app.get("/", (req, res) => {
  res.send("Hello World");
});

app.use("/api/users", userRoutes);

app.listen(PORT, () => {
  console.log(`Server listening at http://localhost:${PORT}`);
});
