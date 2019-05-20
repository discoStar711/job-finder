import React, { Component } from 'react';

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

    render() {
        return (
            <form
                onSubmit={}
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