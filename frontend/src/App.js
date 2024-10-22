import './App.css';
import Header from './components/Header';
import Products from './components/Products'

function App() {
  return (
    <div className="App">
      <Header />
      <div>
      <h1>Products</h1>
      <Products />
      </div>
    </div>
  );
}

export default App;
