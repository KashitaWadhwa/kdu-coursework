const express = require('express');
const app = express();
const cors = require('cors');
const routes = require('./routes/routes.js');
app.use(cors());

require('dotenv').config();
const port = process.env.PORT || 3000;

app.use(express.json());

app.use('/api', routes);

app.get('/api', (req, res) => {
  res.send('Hello World');
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
