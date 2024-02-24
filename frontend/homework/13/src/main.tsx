import ReactDOM from 'react-dom/client'
import { BrowserRouter } from 'react-router-dom'
import App from './App.tsx'
import { ProductProvider } from './components/context/ProductContext.tsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <ProductProvider>
    <BrowserRouter>
    <App />
    </BrowserRouter>
    </ProductProvider>
)
