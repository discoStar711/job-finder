import React, { Component } from 'react';
import FindForm from './findForm';
import FindResult from './findResult';
import axios from 'axios';

const API_URL = 'http://localhost:8080/find/job?keywords=';

class JobFinder extends Component {

    constructor(props) {
        super(props);
        this.state = {
            input: '',
            resultList: 'no results'
        };
        this.findJobs = this.findJobs.bind(this);
    }

    findJobs(input) {
        const query = API_URL + input;
        axios.get(query)
            .then(response => {
                const responseString = JSON.stringify(response);
                this.setState({
                    resultList: responseString
                });
            })
            .catch(error => {
                this.setState({
                    resultList: 'Something went wrong. Please try again.'
                });
            });
    }

    render() {
        return (
            <div
                className="form-container"
            >
                <FindForm
                    onFormSubmit={this.findJobs}
                />
                <FindResult
                    results={this.state.resultList}
                />
            </div>
        );
    }
}

export default JobFinder;