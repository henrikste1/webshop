import { getAllProducts } from "../api/productService"
import React from 'react';
import { Container, Row, Col, Card, CardImg, CardBody, CardTitle, CardText } from 'reactstrap';

class ProductCard extends React.Component {
  render() {
    const { product } = this.props;
    return (
      <Card>
        <CardBody>
          <img
          alt={product.name}
          src={product.picture}
          width="200"
          height="200"
          />
        </CardBody>
        <CardBody>
          <CardTitle tag="h5">{product.name}</CardTitle>
          <CardText>Price: {product.price},-</CardText>
          <CardText>{product.description}</CardText>
        </CardBody>
      </Card>
    );
  }
}

class Products extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      products: []
    };
  }

  componentDidMount() {
    this.fetchProducts();
  }

  fetchProducts = async () => {
    try {
      const productData = await getAllProducts();
      console.log('Fetched Products:', productData); // Log fetched data
      this.setState({ products: productData }); // Save to state
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  render() {
    const { products } = this.state;

    return (
      <Container>
        <Row>
          {
            products.map((product) => (
              <Col sm="3" key={product.productId}> 
                <ProductCard product={product} />
              </Col>
            ))
          }
        </Row>
      </Container>
    );
  }
}

export default Products;