const express = require('express');
const app = express();
const fs = require('fs');
const port = 3020;
const user = "Kashita";
app.use(express.json());
const file = JSON.parse(fs.readFileSync('os.json', 'utf-8'));

app.get('/', (req, res) => {
    res.send(`<p>Hello , my name is ${user}!</p>  <p>Here is my system information:</p>` + `<div>${JSON.stringify(file)}</div>`);
    });

app.listen(port, () => {
    console.log(`Server is running at http://localhost:${port}`);
    }    
);