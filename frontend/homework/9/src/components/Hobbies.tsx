import React from 'react'
import data from '../data/Userdata.json'
import './Hobbies.css'
const Hobbies = () => {
  return (
    <div className="Hobbies">
        <h2 className="heading">Hobbies</h2>
        <ul className="list">
            {data.hobbies.map((hobby, index) => {
                return <li className="Item" key={index}>{hobby.hobby}</li>
            })}
        </ul>
    </div>
  )
}

export default Hobbies