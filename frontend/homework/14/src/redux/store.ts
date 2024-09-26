import { configureStore } from "@reduxjs/toolkit";
import todoSlice from "./todoSlice";
export const store = configureStore  ({
    reducer: {
        todos: todoSlice,
    },
});

export const dispatch = store.dispatch;
export type RootState=ReturnType<typeof store.getState>;