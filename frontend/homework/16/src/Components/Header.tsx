
import HighlightText from "./HighlightText"
import "./header.css"

const Header = () => {
  return (
    <div className="header">
        <HighlightText text="KDU" highlight="grey"/>
        <HighlightText text="MARKETPLACE" highlight="blue"/>
    </div>
  )
}

export default Header