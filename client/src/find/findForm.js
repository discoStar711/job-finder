import React, { Component } from 'react';

class FindForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            input: ''
        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleFormSubmit = this.handleFormSubmit.bind(this);
    }

    handleInputChange(event) {
        this.setState({
            input: event.target.value
        });
    }

    handleFormSubmit(event) {
        event.preventDefault();
        this.props.onFormSubmit(this.state.input);
    }

    render() {
        return (
            <form
                onSubmit={this.handleFormSubmit}
                className=""
            >
                <div className="row">
                    <div className="col-sm-12 col-md-8">
                        <input
                            onChange={this.handleInputChange}
                            value={this.state.input}
                            className="form-control"
                            type="text"
                            placeholder="Search..."
                        />
                    </div>
                    <div className="col-sm-12 col-md-4">
                        <button
                            type="submit"
                            className="btn submit-search-form"
                        >
                            Submit
                        </button>
                    </div>
                    <div className="w-100"></div>
                    <div className="col-sm-12 form-setting-container form-inline">
                        <div className="form-group">
                            <label className="checkbox-container">
                                <input className="checkbox-input" type="checkbox" value="" />
                                <span>Remote Only</span>
                            </label>
                        </div>
                        <div className="form-group">
                            <select className="form-control">
                                <option>UK</option>
                                <option>US</option>
                            </select>
                            <label>Country</label>
                        </div>
                    </div>
                </div>
            </form>
        );
    }
}

export default FindForm;