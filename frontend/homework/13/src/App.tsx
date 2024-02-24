
import { Route, Routes } from 'react-router-dom'
import './App.css'
import { Container } from './components/Container/Container'
import ProductDetail from './components/Container/productDetail'
import { Header } from './components/Header/Header'
function App() {

  return (
    <div className='body'>
      <Header />  
      <Routes>
        <Route path="/" element={<Container />} />
        <Route path="/product" element={<ProductDetail />} />
      </Routes>
    </div>
  )
}

export default App
