import { loginUser } from './api/userService';

export const firebaseAuth = {
  isAuthenticated: false,
  email: null,
  token: null,

  async loginUser(email, password) {
    try {
      const response = await loginUser(email, password);
      
      firebaseAuth.isAuthenticated = true;
      firebaseAuth.email = email;
      firebaseAuth.token = response; 

    } catch (error) {
      console.error('Login failed:', error);
      throw error; 
    }
  },

  async signout() {
    firebaseAuth.isAuthenticated = false;
    firebaseAuth.email = null;
    firebaseAuth.token = null;
  }
};
