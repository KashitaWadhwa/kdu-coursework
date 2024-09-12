import { configureStore } from "@reduxjs/toolkit";
import todoReducer from "./TodoSlice";

import storage from "redux-persist/lib/storage";
import { persistReducer,persistStore} from "redux-persist";

const persistConfig = {
    key:'root',
    storage,
}

const persistedReducer = persistReducer(persistConfig,todoReducer);

export const store = configureStore({
    reducer:{
        todos:persistedReducer,
    },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;


export const persistor = persistStore(store);