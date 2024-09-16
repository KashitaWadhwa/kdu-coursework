import { Route, Routes } from "react-router-dom"
import Header from "./Components/Header"
import ProductDetail from "./Components/ProductDetail"
import ProductList from "./Components/ProductList"

const App = () => {
  return (
    <div>
      <Header/>
      <Routes>
      <Route path="/" element={<ProductList/>} />
      <Route path="/product/:id" element={<ProductDetail/>} />
      </Routes>
    </div>
  )
}

export default App