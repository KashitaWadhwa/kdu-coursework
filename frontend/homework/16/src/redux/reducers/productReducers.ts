import { ActionTypes } from "../action-types/action-types";

interface Product {
    id: number;
    title: string;
    price: number;
    category: string;
    description: string;
    image: string;
}
const initialState = {
    products:[] as Product[]
}

export const productsReducer =(state=initialState, {type, payload}:any)=>{
    switch(type){
        
        case ActionTypes.FETCH_PRODUCTS:
            return {...state, products:payload} 

        case ActionTypes.SET_PRODUCTS:
            return {...state, products:payload}
        default:
            return state;
    }
}

export const selectedProductReducer =(state={}, {type, payload}:any)=>{
    switch(type){
        case ActionTypes.SELECTED_PRODUCT:
            return {...state, products:payload}

        // case ActionTypes.FETCH_PRODUCTS:
        //     return {...state, products:payload}    
        default:
            return state;
    }
}