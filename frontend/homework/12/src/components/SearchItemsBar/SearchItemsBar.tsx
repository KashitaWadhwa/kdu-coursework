import React, { useState } from 'react';
import { useSearchContext } from '../context/SearchContext';
import { useTodoContext } from '../context/TodoContext';
import './SearchItemsBar.scss';

const SearchItemsBar: React.FC = () => {
  const { setFilteredTodos } = useSearchContext();
  const { todos } = useTodoContext();
  const [searchTerm, setSearchTerm] = useState('');

  const handleSearch = (term: string) => {
    setSearchTerm(term);
    const filtered = todos.filter(todo => todo.text.toLowerCase().includes(term.toLowerCase()));
    setFilteredTodos(filtered);
  };

  return (
    <div className="search-item">
      <input type="text" value={searchTerm} className="search" onChange={e => handleSearch(e.target.value)}
        placeholder="Search Items..." style={{ fontSize: '16px', fontFamily: 'Lato' }}
      />
    </div>
  );
};

export default SearchItemsBar;
