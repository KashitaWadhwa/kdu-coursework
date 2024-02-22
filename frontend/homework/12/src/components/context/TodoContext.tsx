import React, { createContext, useState, useContext } from 'react';

export interface Todo {
  id: number;
  text: string;
}

interface TodoContextType {
  todos: Todo[];
  addTodo: (todoText: string) => void;
  deleteTodo: (todoId: number) => void;
}
const defaultValue: TodoContextType = {
  todos: [],
  addTodo: () => {},
  deleteTodo: () => {}
};

const TodoContext = createContext<TodoContextType>(defaultValue);

export const useTodoContext = () => {
  const context = useContext(TodoContext);
  return context;
};

interface TodoProviderProps {
  children: React.ReactNode;
}

export const TodoProvider: React.FC<TodoProviderProps> = ({ children }) => {
  const [todos, setTodos] = useState<Todo[]>([]);

  const addTodo = (todoText: string) => {
    setTodos([...todos, { id: Date.now(), text: todoText }]);
  };

  const deleteTodo = (todoId: number) => {
    setTodos(todos.filter(todo => todo.id !== todoId));
  };

  return (
    <TodoContext.Provider value={{ todos, addTodo, deleteTodo }}>
      {children}
    </TodoContext.Provider>
  );
};
