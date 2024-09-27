import React, { createContext, useState, useContext, ReactNode } from 'react';
import { Todo } from './TodoContext';

interface SearchContextType {
  filteredTodos: Todo[];
  setFilteredTodos: React.Dispatch<React.SetStateAction<Todo[]>>;
}

const SearchContext = createContext<SearchContextType>({
  filteredTodos: [],
  setFilteredTodos: () => {}
});

export const useSearchContext = () => {
  return useContext(SearchContext);
};

interface SearchContextProviderProps {
  children: ReactNode;
}

export const SearchContextProvider: React.FC<SearchContextProviderProps> = ({ children }) => {
  const [filteredTodos, setFilteredTodos] = useState<Todo[]>([]);

  return (
    <SearchContext.Provider value={{ filteredTodos, setFilteredTodos }}>
      {children}
    </SearchContext.Provider>
  );
};
