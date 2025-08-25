// const db = mysql.createConnection({
//   host: 'localhost',
//   user: 'vbcart',        // ← Wrong username
//   password: 'yourpass',   // ← Wrong password
//   database: 'yourdb'      // ← Wrong database name
// });

// const mysql = require("mysql2");

// const db = mysql.createConnection({
//   host: process.mysql://root:fcvrIOEdlZuwlpqhEvLVnCfQzTljWzBk@maglev.proxy.rlwy.net:26554/railway
//   user: process.root,
//   password: process.fcvrIOEdlZuwlpqhEvLVnCfQzTljWzBk,
//   database: process.env.railway,
// });

// db.connect(err => {
//   if (err) {
//     console.error("Database connection failed: " + err.stack);
//     return;
//   }
//   console.log("✅ Connected to MySQL database.");
// });

// const express = require("express");
// const app = express();

// app.get("/", (req, res) => {
//   res.send("Backend running on Render 🚀");
// });

// const PORT = process.env.PORT || 3000;
// app.listen(PORT, () => {
//   console.log(`Server running on port ${PORT}`);
// });
const mysql = require("mysql2");
const express = require("express");

const db = mysql.createConnection({
  host: "maglev.proxy.rlwy.net",   // from URL
  port: 26554,                     // from URL
  user: "root",                    // from URL
  password: "fcvrIOEdlZuwlpqhEvLVnCfQzTljWzBk", // from URL
  database: "railway",             // from URL
});

db.connect(err => {
  if (err) {
    console.error("❌ Database connection failed: " + err.stack);
    return;
  }
  console.log("✅ Connected to MySQL database.");
});

const app = express();

app.get("/", (req, res) => {
  res.send("Backend running on Render 🚀");
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});

