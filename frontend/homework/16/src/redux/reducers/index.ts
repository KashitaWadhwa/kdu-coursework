import { combineReducers } from '@reduxjs/toolkit';
import { productsReducer, selectedProductReducer } from "../reducers/productReducers";

const reducers = combineReducers({
    allProducts: productsReducer,
    product: selectedProductReducer,
});

export default reducers;