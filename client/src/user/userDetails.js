import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Cookies from 'js-cookie';

const USER_API_URL = 'http://localhost:8080/user/details';

class UserDetails extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: '',
            error: false
        };
    }

    componentDidMount() {
        this.fetchUserDetails();
    }

    fetchUserDetails() {
        axios({
            method: 'get',
            url: USER_API_URL,
            withCredentials: true
        })
            .then(response => {
                const fetchedData = response.data;
                this.setState({
                    username: fetchedData.username,
                    email: fetchedData.email
                });
            })
            .catch(error => {
                console.log(error);
                Cookies.remove('CSRF-Token');
                this.setState({
                    error: true
                })
            });
    }

    render() {
        const username = this.state.username;
        const email = this.state.email;
        const error = this.state.error;

        if (!error) {
            return (
                <div>
                    <p>{username}</p>
                    <p>{email}</p>
                </div>
            );
        } else {
            return (
                <div>
                    <p>Could not authenticate request.</p>
                    <Link to="/login">Try to log in.</Link>
                </div>
            );
        }
    }
}

export default UserDetails;