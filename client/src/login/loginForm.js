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
        this.handleUsernameChange = this.handleUsernameChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleFormSubmit = this.handleFormSubmit.bind(this);
    }

    handleUsernameChange(event) {
        this.setState({
            username: event.target.value
        });
    }

    handlePasswordChange(event) {
        this.setState({
            password: event.target.value
        });
    }

    handleFormSubmit(event) {
        event.preventDefault();
        const username = this.state.username;
        const password = this.state.password;
        const token = this.state.csrfToken;
    }

    render() {
        return (
            <form
                onSubmit={this.handleFormSubmit}
                className=""
            >
                <input
                    onChange={this.handleUsernameChange}
                    value={this.state.username}
                    className="form-control"
                    type="text"
                    placeholder="Username"
                />
                <input
                    onChange={this.handlePasswordChange}
                    value={this.state.password}
                    className="form-control"
                    type="password"
                    placeholder="Password"
                />
                <button
                    type="submit"
                    className="btn submit-search-form"
                >
                    Login
                </button>
            </form>
        );
    }
}

export default LoginForm;