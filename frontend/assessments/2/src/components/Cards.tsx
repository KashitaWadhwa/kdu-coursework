import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchRooms } from "../redux/actions/roomActions";

const Cards = () => {
 const dispatch=useDispatch();
const rooms =useSelector((state:any)=>state.room.room)

useEffect(()=>{
    dispatch(fetchRooms());
},[])
    return (

    <div>Cards</div>
  )
}

export default Cards