import React, { Component } from 'react';
import axios from 'axios/index';
import Cookies from 'js-cookie';

const AUTH_API_URL = 'http://localhost:8080/user/auth';

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

    componentDidMount() {
        const sessionCsrfToken = Cookies.get('CSRF-Token');
        
        if (sessionCsrfToken !== '' && sessionCsrfToken !== undefined) {
            this.setState({
                isAuthenticated: true
            });
        } else {
            this.getCsrfToken();
        }
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
        this.postForm(username, password);
    }

    getCsrfToken() {
    }

    postForm(username, password) {
        axios({
            method: 'post',
            url: AUTH_API_URL,
            data: {
                username: username,
                password: password
            },
            withCredentials: true
        })
            .then(response => console.log(response))
            .catch(error => console.log(error));
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