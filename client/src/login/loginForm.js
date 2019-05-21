import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import axios from 'axios/index';
import Cookies from 'js-cookie';

const AUTH_API_URL = 'http://localhost:8080/user/auth';
const CSRF_API_URL = 'http://localhost:8080/csrfLogin';

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
        this.postForm(username, password, token);
    }

    getCsrfToken() {
        axios.get(CSRF_API_URL)
            .then(response => {
                console.log(response);
                this.setState({
                    csrfToken: response.data
                });
            })
            .catch(error => console.log(error));
    }

    postForm(username, password, csrfToken) {
        axios({
            method: 'post',
            url: AUTH_API_URL,
            data: {
                username: username,
                password: password
            },
            headers: {
                'CSRF-Token': csrfToken
            },
            withCredentials: true
        })
            .then(response => {
                console.log(response);
                const sessionCsrfToken = Cookies.get('CSRF-Token');

                if (sessionCsrfToken !== '' && sessionCsrfToken !== undefined) {
                    this.setState({
                        isAuthenticated: true
                    });
                }
            })
            .catch(error => console.log(error));
    }

    hasSessionCsrfToken() {
        const sessionCsrfToken = Cookies.get('CSRF-Token');

        if (sessionCsrfToken !== '' && sessionCsrfToken !== undefined) {
            return true;
        } else {
            return false;
        }
    }

    hasLoginCsrfToken() {
        const csrfToken = this.state.csrfToken;

        if (csrfToken !== '' && csrfToken !== undefined) {
            return true;
        } else {
            return false;
        }
    }

    render() {
        if (this.state.isAuthenticated || this.hasSessionCsrfToken()) {
            return ( <Redirect to="/account"/> );
        } else {
            this.getCsrfToken();
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
}

export default LoginForm;