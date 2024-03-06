import { FaSearch } from "react-icons/fa";
import './Search.scss'
export function Search() {
  return (
    <div >
      <form>
        <input className="search-bar" type="text" placeholder="Search.."  />
        <button className="submit" type="submit"><FaSearch /></button>
      </form>
    </div>
  )
}
