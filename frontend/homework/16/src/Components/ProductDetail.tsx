import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import { fetchProduct } from "../redux/actions/productActions";
import './detail.css';
interface Product {
    id: number;
    title: string;
    price: number;
    category: string;
    description: string;
    image: string;
}

const ProductDetail = () => {
    const navigate = useNavigate();
    const { id } = useParams<{ id: string }>();
    const product = useSelector((state: any) => state.product.products); 
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(fetchProduct((id))); // Convert id to number
    }, [dispatch, id]);

    const clickHandler = () => {
        navigate('/');
    };

    return (
        <div className="container">
            {product ? (
                <div key={product.id} className="box">
                    <div className="left">
                        <img src={product.image} alt={product.title} />
                    </div>
                    <div className="right">
                        <h3>{product.title}</h3>
                        <h5>{product.price}</h5>
                        <h5>{product.category}</h5>
                        <h5>{product.description}</h5>
                        <button onClick={clickHandler} className="btn">Back to products</button>
                    </div>
                </div>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
}

export default ProductDetail;
