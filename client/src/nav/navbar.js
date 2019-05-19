import React, { Component } from 'react';
import { Link } from "react-router-dom";

class Navbar extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <nav>
                <div className="container">
                    <Link to="/">Home</Link>
                    <Link to="/login">Login</Link>
                    <Link to="/register">Register</Link>
                </div>
            </nav>
        );
    }
}

export default Navbar;