import React from 'react';
import { useTodoContext } from './context/TodoContext';
import TodoItem from './TodoItem';

const TodoList: React.FC = () => {
  const { todos } = useTodoContext();

  return (
    <div className="todo-list">
      {todos.map(todo => (
        <TodoItem key={todo.id} todo={todo} />
      ))}
    </div>
  );
};

export default TodoList;
