import { Dispatch } from "@reduxjs/toolkit";
import { ActionTypes } from "../action-types/action-types";
import fakestoreapi from "../apis/fakestoreapi";

interface Product {
    id: number;
    title: string;
    price: number;
    category: string;
    description: string;
    image: string;
}

interface FetchProductsAction {
    type: ActionTypes.FETCH_PRODUCTS;
    payload: Product[];
}

interface FetchProductAction {
    type: ActionTypes.SELECTED_PRODUCT;
    payload: Product;
}

type Action = FetchProductsAction | FetchProductAction;

export const fetchProducts = () => {
    return async function(dispatch: Dispatch<Action>) {
        try {
            const response = await fakestoreapi.get('/products');
            dispatch({ type: ActionTypes.FETCH_PRODUCTS, payload: response.data });
        } catch (error) {
            // Handle error if necessary
        }
    };
}

export const fetchProduct = (id: number) => async (dispatch: Dispatch<Action>) => {
    try {
        const response = await fakestoreapi.get(`/products/${id}`);
        dispatch({ type: ActionTypes.SELECTED_PRODUCT, payload: response.data });
    } catch (error) {
        // Handle error if necessary
    }
}

export const setProducts = (products: Product[]): FetchProductsAction => {
    return {
        type: ActionTypes.FETCH_PRODUCTS,
        payload: products
    };

}

export const selectedProduct = (product: Product): FetchProductAction => {
    return {
        type: ActionTypes.SELECTED_PRODUCT,
        payload: product
    };
}
