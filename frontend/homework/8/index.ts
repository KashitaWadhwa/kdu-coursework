import express from 'express';
const app = express();
const port = 3000;
const routes = require('./Routes/routes');


app.use(express.json());
app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.use('/api', routes);



app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
});
