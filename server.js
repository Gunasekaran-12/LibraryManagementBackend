const db = mysql.createConnection({
  host: 'localhost',
  user: 'vbcart',        // ← Wrong username
  password: 'yourpass',   // ← Wrong password
  database: 'yourdb'      // ← Wrong database name
});