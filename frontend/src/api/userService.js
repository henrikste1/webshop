import axios from 'axios';

export const getAllUsers = async () => {
  try {
    const response = await axios.get('/user/all');
    return response.data;
  } catch (error) {
    console.error('Error fetching users:', error);
    throw error;
  }
};

export const addUser = async (user) => {
  try {
    const response = await axios.post('/user/add', null, {
      params: {
        email: user.username,
        password: user.password
      }
    });
    return response.data;
  } catch (error) {
    console.error('Error adding user:', error);
    throw error;
  }
};

export const loginUser = async (email, password) => {
  try {
    const response = await axios.post('/user/login', {
      email,
      password
    });
    return response.data; 
  } catch (error) {
    console.error('Error logging in:', error);
    throw error;
  }
};

const userService = {
  getAllUsers,
  addUser,
  loginUser
};

export default userService;
