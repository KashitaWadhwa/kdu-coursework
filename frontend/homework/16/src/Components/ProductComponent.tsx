import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { fetchProducts } from "../redux/actions/productActions";
import './product.css';
interface Product {
    id: number;
    title: string;
    price: number;
    category: string;
    description: string;
    image: string;
}

const ProductComponent = () => {
    const products = useSelector((state: any) => state.allProducts.products);
    console.log("Products",products)
    const dispatch = useDispatch();

    useEffect(()=>{
        dispatch(fetchProducts());
    },[])

  return (
    <di className="container">
        {products.map((product: Product) => {
            const { id, title, image, price, category } = product;
            return (

                     <Link to={`/product/${id}` }>
                    <div className="card">
                        <img src={image} alt={title} />
                        <h3>{title}</h3>
                        <h5>{price}</h5>
                        <h5>{category}</h5>
                    </div>
                    </Link>
                
                
            );
        }
        )}
    </di>
  )
}

export default ProductComponent