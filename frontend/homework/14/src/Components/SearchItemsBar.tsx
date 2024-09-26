import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import { removeTodo } from "../redux/todoSlice";

const List = () => {
    const todos = useSelector((state: RootState) => state.todos.todos);
    const dispatch = useDispatch();

    const clickHandler = (id: number) => {
        dispatch(removeTodo(id));
    };

    return (
        <div>
            <ul>
                {todos.map((todo) => (
                    <li key={todo.id}>
                        {todo.todo}
                        <button onClick={() => clickHandler(todo.id)}>Remove</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

const SearchItemsBar = () => {
    const [searchTerm, setSearchTerm] = useState("");
    const dispatch = useDispatch();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setSearchTerm(e.target.value);
    };

    const handleSearch = () => {
        // Perform search action here
        console.log("Search term:", searchTerm);
    };

    return (
        <div>
            <input
                type="text"
                placeholder="Search Todo"
                value={searchTerm}
                onChange={handleChange}
            />
            <button onClick={handleSearch}>Search</button>
        </div>
    );
};

export { List, SearchItemsBar };
