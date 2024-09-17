import axios from 'axios';

export const getAllCategories = async () => {
  try {
    const response = await axios.get('/category/all');
    return response.data;
  } catch (error) {
    console.error('Error fetching categories:', error);
    throw error;
  }
};

export const addCategory = async (category) => {
  try {
    const response = await axios.post('/category/add', null, {
      params: {
        name: category.name,
        description: category.description,
        user: category.user
      }
    });
    return response.data;
  } catch (error) {
    console.error('Error adding category:', error);
    throw error;
  }
};

export default categoryService;