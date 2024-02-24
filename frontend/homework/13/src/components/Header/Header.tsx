import { Filter } from "../subcomponents/header/Filter/Filter";
import { Search } from "../subcomponents/header/search/Search";
import { Sort } from "../subcomponents/header/sort/Sort";
import './Header.scss';
export function Header() {
  return (
    <div className="Header">
        <div className="Search">
            <Search/>
        </div> 
        <div className="combination">
            <Filter/>
            <Sort />
        </div>              
    </div>
  )
}
