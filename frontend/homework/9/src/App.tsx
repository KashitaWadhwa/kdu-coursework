import React from 'react';
import './App.css';
import Userdetail from './components/Userdetail';
import Skills from './components/Skills';
import Hobbies from './components/Hobbies';

function App() {
  return (
    <div className="App">
      <Userdetail />
      <div className="container">
        <Skills />
        <Hobbies />
      </div>
    </div>
  );
}

export default App;
