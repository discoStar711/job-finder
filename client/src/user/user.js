import React, { Component } from 'react';
import Cookies from 'js-cookie';
import { Redirect } from 'react-router-dom';
import UserDetails from './userDetails';

class User extends Component {

    constructor(props) {
        super(props);
    }

    hasPermission() {
        const sessionCsrfToken = Cookies.get('CSRF-Token');

        if (sessionCsrfToken !== '' && sessionCsrfToken !== undefined) {
            return true;
        } else {
            return false;
        }
    }

    render() {
        if (this.hasPermission()) {
            return <UserDetails />
        } else {
            return <Redirect to="/login" />
        }
    }
}

export default User;