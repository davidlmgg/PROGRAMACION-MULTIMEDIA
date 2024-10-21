const express = require("express");
const cors = require("cors");
const mysql = require("mysql2/promise");

const app = express();
app.use(cors());
app.use(express.json());
const PORT = 3000;

const myPool = mysql.createPool({
    host: "localhost",
    user: "root",
    database: "mvp", 
    password: "", 
    port: 3306 
});

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});

app.post("/login", async (req, res) => {
    const { email, password } = req.body;
    try {
        const [rows] = await myPool.execute(
            "SELECT idusu, email FROM usuario WHERE email = ? AND password = ?",
            [email, password]
        );
        if (rows.length === 1) {
            res.status(200).json({ message: "Successfully logged in", user: rows[0] });
        } else {
            res.status(401).json({ error: "Incorrect credentials" });
        }
    } catch (error) {
        console.error("Error logging in:", error);
        res.status(500).json({ error: "Internal error" });
    }
});

app.post("/register", async (req, res) => {
    const { email, password } = req.body;
    try {
        const [existingUser] = await myPool.execute("SELECT * FROM usuario WHERE email = ?", [email]);

        if (existingUser.length > 0) {
            res.status(400).json({ error: "User already registered" });
        } else {
            await myPool.execute(
                "INSERT INTO usuario(email, password) VALUES (?, ?)",
                [email, password]
            );
            res.status(201).json({ message: "User registered successfully" });
        }
    } catch (error) {
        console.error("Registration error:", error);
        res.status(500).json({ error: "Internal error" });
    }
});

app.get("/usuario/all", async (req, res) => {
    try {
        const [rows] = await myPool.execute("SELECT * FROM usuario");
        res.json(rows);
    } catch (error) {
        console.error("Error fetching users:", error);
        res.status(500).json({ error: "Internal error" });
    }
});
