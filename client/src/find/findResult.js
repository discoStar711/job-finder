import React, { Component } from 'react';

class FindResult extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const results = this.props.results;
        return (
            <div>
                {results}
            </div>
        );
    }
}

export default FindResult;