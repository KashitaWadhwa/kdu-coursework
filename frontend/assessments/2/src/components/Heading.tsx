import Cards from "./Cards";
import "./header.css"
interface HeadingProps {
    title: string;
    color: string;
}

const Heading = (props:HeadingProps) => {
  return (
    <div className="text" style={{color:props.color}}>{props.title}</div>
  )
}

export default Heading