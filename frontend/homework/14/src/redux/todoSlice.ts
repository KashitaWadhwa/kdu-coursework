import { createSlice } from "@reduxjs/toolkit";

interface Todo {
    id: number; 
    todo: string;
}

interface InitialState {
    todos: Todo[];
}

const initialState: InitialState = {
    todos: [],
};

const TodoSlice = createSlice({
    name: "todo",
    initialState: initialState,
    reducers: {
        addTodo: (state, action) => {
            const newTodo: Todo = {
                id: state.todos.length + 1,
                todo: action.payload, 
            };
            state.todos.push(newTodo);
        },
        removeTodo: (state, action) => {
            state.todos = state.todos.filter(todo => todo.id !== action.payload);
        }
    }
});

export const { addTodo, removeTodo } = TodoSlice.actions;

export default TodoSlice.reducer;
