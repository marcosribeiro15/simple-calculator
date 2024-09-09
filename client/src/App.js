import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import NoMatch from "./components/NoMatch"

import Home from "./pages/Home";

import "./App.css";

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <Router >
        <div id="application">
          <Switch>
            <Route path="/" exact component={Home} />
            <Route component={NoMatch} />
          </Switch>
        </div>
      </Router>
    )
  }
}