import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import './App.css';
import IndicatorList from './components/IndicatorList';
import ErrorPage from './components/ErrorPage';
import IndicatorPage from './components/IndicatorPage';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
          <Switch>
            <Route path="/" component={IndicatorList} exact />
            <Route path="/indicators/:id" component={IndicatorPage} />
            <Route component={ErrorPage} />
          </Switch>
        </div>
      </Router>
    );
  }
}

export default App;
