// const db = mysql.createConnection({
//   host: 'localhost',
//   user: 'vbcart',        // ← Wrong username
//   password: 'yourpass',   // ← Wrong password
//   database: 'yourdb'      // ← Wrong database name
// });

const mysql = require("mysql2");

const db = mysql.createConnection({
  host: process.https://library-management-frontend1.vercel.app,
  user: process.root,
  password: process.fcvrIOEdlZuwlpqhEvLVnCfQzTljWzBk,
  database: process.env.railway,
});

db.connect(err => {
  if (err) {
    console.error("Database connection failed: " + err.stack);
    return;
  }
  console.log("✅ Connected to MySQL database.");
});

const express = require("express");
const app = express();

app.get("/", (req, res) => {
  res.send("Backend running on Render 🚀");
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
