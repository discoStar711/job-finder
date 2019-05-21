import React, { Component } from 'react';

class LoginForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            csrfToken: '',
            isAuthenticated: false
        };
    }

    render() {
        return (
            <form>

            </form>
        );
    }
}

export default LoginForm;