import React, { Component } from 'react';
import FindForm from './findForm';
import FindResult from './findResult';
import axios from 'axios';

class JobFinder extends Component {

    constructor(props) {
        super(props);
        this.state = {
            input: '',
            resultList: 'no results'
        };
    }

    render() {
        return (
            <div
                className="form-container"
            >
                <FindForm
                    onFormSubmit={}
                />
                <FindResult
                    results={this.state.resultList}
                />
            </div>
        );
    }
}

export default JobFinder;