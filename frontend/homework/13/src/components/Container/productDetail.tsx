import React, { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { ProductContext } from '../context/ProductContext';
import './productDetail.scss';

const ProductDetail: React.FC = () => {
    const navigate  = useNavigate();
    const products = useContext(ProductContext);
    const productId = localStorage.getItem('productId');
    const product = products.products.find((product) => product.id === parseInt(productId!));
    return (
        <div className='container'>
        <p>{product?.title} </p>
        <div className='blocks'>
            {/* left side */}
            <img className='img' src={product?.image} alt={product?.title} />
            {/* right side */}
            <div className='right'>
                <p>Category : {product?.category}</p>
                <p>Price : {product?.price}</p>
                <p>Description : {product?.description}</p>
                <button className='btn' onClick={() => {
                    navigate("/");
                }}>Back to Products</button>
            </div>
        </div>
    </div>
    );
};

export default ProductDetail;
