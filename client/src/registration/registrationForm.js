import React, { Component } from 'react';

class RegistrationForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: '',
            password: ''
        };
    }

    render() {
        return (
            <form
                onSubmit={}
                className=""
            >
                <input
                    onChange={}
                    value={this.state.username}
                    className="form-control"
                    type="text"
                    placeholder="Username"
                />
                <input
                    onChange={}
                    value={this.state.email}
                    className="form-control"
                    type="text"
                    placeholder="Email Address"
                />
                <input
                    onChange={}
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