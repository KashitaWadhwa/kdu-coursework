"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var express_1 = __importDefault(require("express"));
var app = (0, express_1.default)();
var port = 3000;
var routes = require('./Routes/routes');
app.use(express_1.default.json());
app.get('/', function (req, res) {
    res.send('Hello World!');
});
app.use('/api', routes);
app.listen(port, function () {
    console.log("Example app listening at http://localhost:".concat(port));
});
