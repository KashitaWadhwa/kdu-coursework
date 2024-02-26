import { useState } from "react";
import { dispatch } from "../redux/store";
import { addTodo } from "../redux/todoSlice";
import "./Add.scss";

const Add = () => {
  const [todo, setTodo] = useState("");

  const clickHandler = () => {
    dispatch(addTodo(todo));
    console.log("Todo added", todo);
  };

  return (
    <div className="add" >
      <input
        type="text"
        id="todo"
        className="add-todo" 
        placeholder="Add new todo..."
        name="todo"
        value={todo}
        onChange={(e) => setTodo(e.target.value)}
      />
      <button onClick={clickHandler}>Submit</button>
    </div>
  );
};

export default Add;
