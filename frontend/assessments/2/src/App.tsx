import Cards from "./components/Cards"
import Heading from "./components/Heading"
import { Provider } from 'react-redux';
import './components/header.css'
import './App.css'
import store from "./redux/store";

const App = () => {
  return (
  <Provider store={store}>
     <div>
      <h1 className="heading">Hotel Booking </h1>
       <Heading title="Select Room type" color="white"/>
     <Cards></Cards>
       <Heading title="Select Date" color="white"/>
       <Heading title="Select additional add ons/preferences" color="white"/>

       <button className="submit">Submit</button>
    </div>
</Provider>

  )
}

export default App

