const express= require('express');
const app = express();
const routes = require('./Routes/route');
require('dotenv').config();

const port= process.env.PORT || 3000;

// middlewares 
app.use(express.json());

// routes
app.use('/api', routes);



//start server
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
