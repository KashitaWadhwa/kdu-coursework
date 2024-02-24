import axios from 'axios';
import React, { createContext, useEffect, useState } from 'react';
import { Product } from '../../interface/Product';

interface ProductContextType {
  products: Product[];
}

interface ProductProviderProps {
  children: React.ReactNode;
}

const ProductContext = createContext<ProductContextType>({
  products: [],
});

const ProductProvider: React.FC<ProductProviderProps> = ({ children }) => {
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        await axios.get<Product[]>('https://fakestoreapi.com/products').then((res) => setProducts(res.data));
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };

    fetchProducts();
  }, []);

  return (
    <ProductContext.Provider value={{ products }}>
      {children}
    </ProductContext.Provider>
  );
};

export { ProductContext, ProductProvider };

