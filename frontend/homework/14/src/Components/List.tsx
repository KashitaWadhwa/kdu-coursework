import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import { removeTodo } from "../redux/todoSlice";
const List = () => {
    const todos=useSelector((state:RootState) => state.todos.todos);
    const dispatch = useDispatch();

    const clickHandler = (id:number) => {
        dispatch(removeTodo(id))
    };

  return (
    <div>
        <p>
            {
                todos.map((todo, index) => {
                    return <li key={index}>{todo.todo}
                   <button onClick={() => clickHandler(todo.id)}>Delete</button>
                    </li>
                })
            }
        </p>
    </div>
  )
}

export default List