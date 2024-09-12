import React from 'react'
import data from '../data/Userdata.json'
import './Skills.css'

const Skills = () => {
  return (
    <div className="Skills">
        <h2 className="heading">Skills</h2>
        <ul className="list">
            {data.skills.map((skill, index) => {
                return <li className="Item" key={index}>{skill.skill}</li>
            })}
        </ul>
    </div>
  )
}

export default Skills