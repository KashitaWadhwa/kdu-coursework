"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var express_1 = __importDefault(require("express"));
var recepie_1 = require("../Controllers/recepie");
var router = express_1.default.Router();
router.get('/fetchRecepies', recepie_1.fetchRecipesFromAPI, recepie_1.printAllRecipes);
router.get('/searchRecipes', recepie_1.searchRecipes);
router.get('/printAllRecipes', recepie_1.printAllRecipes);
module.exports = router;
