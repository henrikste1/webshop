import React from 'react';
import logo from '../shopLogo.png';
import {
    Navbar,
    NavbarBrand,
  } from 'reactstrap';

class Header extends React.Component {
  render() {
    return (
        <>
        <Navbar
          className="my-2"
          color="dark"
          dark
        >
          <NavbarBrand href="/">
            <img
              alt="logo"
              src={logo}
              style={{
                height: 40,
                width: 50,
              }}
            />
            Webshop
          </NavbarBrand>
        </Navbar>
      </>
    );
  }
}


export default Header;