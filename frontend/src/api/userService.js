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
        username: user.username,
        permissionLevel: user.permissionLevel || 1 // Default to 1 if not provided
      }
    });
    return response.data;
  } catch (error) {
    console.error('Error adding user:', error);
    throw error;
  }
};

export default userService;
