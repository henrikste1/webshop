import axios from 'axios';

export const getAllProducts = async () => {
  try {
    const response = await axios.get('/product/all');
    return response.data;
  } catch (error) {
    console.error('Error fetching products:', error);
    throw error;
  }
};

export const addProduct = async (product) => {
  try {
    const response = await axios.post('/product/add', null, {
      params: {
        name: product.name,
        price: product.price,
        picture: product.picture,
        description: product.description,
        category: product.category, 
        user: product.user 
      }
    });
    return response.data;
  } catch (error) {
    console.error('Error adding product:', error);
    throw error;
  }
};

export default productService;