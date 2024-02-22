import React, { useState } from 'react';
import { useTodoContext } from '../context/TodoContext';
import './AddItemForm.scss';

const AddItemForm: React.FC = () => {
  const { addTodo } = useTodoContext();
  const [newItem, setNewItem] = useState('');

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setNewItem(event.target.value);
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    if (newItem.trim()) {
      addTodo(newItem.trim());
      setNewItem('');
    }
  };

  return (
    <form className="add" onSubmit={handleSubmit}>
      <input
        type="text" className="add-todo" placeholder="Add new todo..." value={newItem} onChange={handleChange}/>
      <button type="submit" className="submit-button" >Submit</button>
    </form>
  );
};

export default AddItemForm;
