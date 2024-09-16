
interface HighlightTextProps {
    text: string;
    highlight: string;
}


const HighlightText = (props:HighlightTextProps) => {
  return (
    <p style={{color:props.highlight}}>{props.text}</p>
  )
}

export default HighlightText