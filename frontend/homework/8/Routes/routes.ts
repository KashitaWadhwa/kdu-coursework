import express from 'express';
import { fetchRecipesFromAPI, printAllRecipes, searchRecipes } from '../Controllers/recepie';
const router = express.Router();

router.get('/fetchRecepies', fetchRecipesFromAPI,printAllRecipes);
router.get('/searchRecipes', searchRecipes);
router.get('/printAllRecipes', printAllRecipes);
module.exports = router;