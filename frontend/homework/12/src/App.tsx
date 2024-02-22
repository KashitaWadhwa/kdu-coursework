import React from 'react';
import { TodoProvider } from './components/context/TodoContext';
import { SearchContextProvider } from './components/context/SearchContext';
import AddItemForm from './components/AddItemForm/AddItemForm';
import SearchItemsBar from './components/SearchItemsBar/SearchItemsBar';
import TodoList from './components/TodoList';
import './App.scss';

const App: React.FC = () => {
  return (
    <TodoProvider>
      <SearchContextProvider>
        <div>
          <div className="heading">
          <div className="logo">
            <h1 className="item-lister">Item Lister</h1>
            <SearchItemsBar />
          </div>
          </div>
          <div className="container">
            <div className="box">
            <div>
              <h2 className="AddItems">Add Items</h2>
              <AddItemForm />
            </div>
            <div>
              <h2>Items</h2>
              <TodoList />
            </div>
          </div>
            </div>
        </div>
      </SearchContextProvider>
    </TodoProvider>
  );
};

export default App;
