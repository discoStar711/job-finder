import React, { Component } from 'react';
import axios from 'axios/index';

const REGISTER_API_URL = 'http://localhost:8080/user/new';

class RegistrationForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: '',
            password: ''
        };
        this.handleUsernameChange = this.handleUsernameChange.bind(this);
        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleFormSubmit = this.handleFormSubmit.bind(this);
    }

    handleUsernameChange(event) {
        this.setState({
            username: event.target.value
        });
    }

    handleEmailChange(event) {
        this.setState({
            email: event.target.value
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
        const email = this.state.email;
        const password = this.state.password;
        this.postForm(username, email, password);
    }

    postForm(username, email, password) {
        axios.post(REGISTER_API_URL, {
            username: username,
            email: email,
            password: password
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
                    onChange={this.handleEmailChange}
                    value={this.state.email}
                    className="form-control"
                    type="text"
                    placeholder="Email Address"
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
                    Register
                </button>
            </form>
        );
    }
}

export default RegistrationForm;