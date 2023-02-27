const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const port = 3001;

app.use(cors());
app.use(bodyParser.json());

app.post('/api/data', (req, res) => {
  const data = req.body;
  // Save data to database or file system
  res.send('Data saved!');
});

app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});