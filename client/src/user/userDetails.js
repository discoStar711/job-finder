import React, { Component } from 'react';
import axios from 'axios';
import Cookies from 'js-cookie';

class UserDetails extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: ''
        };
    }

    render() {
        const username = this.state.username;
        const email = this.state.email;

        return (
            <div>
                <p>{username}</p>
                <p>{email}</p>
            </div>
        );
    }
}

export default UserDetails;