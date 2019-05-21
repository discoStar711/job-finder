import React from 'react';
import './css/bootstrap-reboot.min.css';
import './css/bootstrap.min.css';
import './css/custom.css';
import JobFinder from './find/jobFinder';
import RegistrationForm from './registration/registrationForm';
import LoginForm from './form/loginForm';
import User from './user/user';
import Navbar from './nav/navbar';
import { Route, Switch } from "react-router-dom";

function App(props) {

    return (
        <div className="container-fluid">
            <Navbar />
            <div className="container">
                <div className="row">
                    <div className="col-sm-12 title">
                        <h1>Home</h1>
                    </div>
                    <div className="col-sm-12">
                        <Switch>
                            <Route exact path="/" component={JobFinder} />
                            <Route path="/account" component={User} />
                            <Route path="/login" component={LoginForm} />
                            <Route path="/register" component={RegistrationForm} />
                        </Switch>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;
