import axios, { AxiosResponse } from 'axios';
interface Recipe {
    id: number;
    name: string;
    ingredients: string[];
    instructions: string[];
    prepTimeMinutes: number;
    cookTimeMinutes: number;
    servings: number;
    difficulty: string;
    cuisine: string;
    caloriesPerServing: number;
    tags: string[];
    userId: number;
    image: string;
    rating: number;
    reviewCount: number;
    mealType: string[];
}

let recipesData: Recipe[] | null = null;

const fetchRecipesFromAPI = async (): Promise<Recipe[]> => {
    try {
        if (recipesData) {
            // If data is already fetched, return it from memory
            return recipesData;
        } else {
            // If data is not fetched yet, fetch it from the API
            const response: AxiosResponse<Recipe[]> = await axios.get('https://dummyjson.com/recipes');
            recipesData = response.data;
            console.log("Recipes fetched successfully from API");
            return recipesData;
        }
    } catch (error) {
        throw new Error("Failed to fetch recipes from API: " + error.message);
    }
}

const searchRecipes = async (req, res) => {
    try{
        const {name}=req.body;

        if(!name){
            return res.status(400).json({
                message:"Please provide a recipe name to search.."
            })
        }

        const response = await axios.get( `https://dummyjson.com/recipes/search?q=${name}`)

        res.status(200).json({
            message:"Recipes fetched successfully",
            data:response.data
        })
    }
    catch(error){
     res.status(500).json({
            message:"Failed to search recipes from API",
            error:error.message
        })   
    }
}


const printAllRecipes = async (req,res): Promise<void> => {
    try {
        const response = await fetchRecipesFromAPI();
        res.status(200).json({
            message:"Recipes fetched successfully",
            data:response
        });
    } catch (error) {
        console.error("Failed to print recipes:", error.message);
    }
}



export { fetchRecipesFromAPI, printAllRecipes, searchRecipes };

