import { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { ProductContext } from '../context/ProductContext';
import './card.scss';

const Card = () => {
    const products = useContext(ProductContext);
    console.log("products", products)
    const navigate = useNavigate();

    const clickHandler = (productId:number) => {
        localStorage.setItem('productId', (productId.toString()));
        console.log("setting local storage", productId)
        navigate('/product'); 
    };

    return (
        <div className='cards' >
            {products.products.map((product) => (
                <div key={product.id} className='card' onClick={() => clickHandler(product.id)}>
                    <img src={product.image} alt={product.title} />
                    <h3>{product.title}</h3>
                    <p>{product.price}</p>
                </div>
            ))}
        </div>
    );
};

export default Card;
