import React from 'react'
import "./Userdetail.css"
import data from '../data/Userdata.json'

const Userdetail = () => {
  return (
    <div className="UserDetails">
        <div className="User">{data.name}</div>
        <div className="fullName">{data.fullName}</div>
        <div className="User">{data.qualification}</div>
    </div>
  )
}

export default Userdetail