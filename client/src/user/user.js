import React, { Component } from 'react';
import Cookies from 'js-cookie';

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
        return (
            <div></div>
        );
    }
}

export default User;