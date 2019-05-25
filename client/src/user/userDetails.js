import React, { Component } from 'react';
import axios from 'axios';

const USER_API_URL = 'http://localhost:8080/user/details';

class UserDetails extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            email: ''
        };
    }

    componentDidMount() {
        this.fetchUserDetails();
    }

    fetchUserDetails() {
        axios({
            method: 'post',
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
            .catch(error => console.log(error));
    }

    render() {
        const username = this.state.username;
        const email = this.state.email;

        return (
            <div>
                <p>{username}</p>
                <p>{email}</p>
            </div>
        );
    }
}

export default UserDetails;