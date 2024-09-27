import React from 'react';
import { Todo, useTodoContext } from './context/TodoContext';

interface TodoItemProps {
  todo: Todo;
}

const TodoItem: React.FC<TodoItemProps> = ({ todo }) => {
  const { deleteTodo } = useTodoContext();

  const handleDelete = () => {
    deleteTodo(todo.id);
  };

  return (
    <div className="todo-item">
      <span style={{ fontSize: '16px', fontFamily: 'Lato' }}>{todo.text}</span>
      <button onClick={handleDelete} style={{ fontSize: '16px', fontFamily: 'Lato', color: 'red' }}>Delete</button>
    </div>
  );
};

export default TodoItem;
