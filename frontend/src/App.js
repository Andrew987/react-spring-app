import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import PubList from './PubList';
import PubEdit from './PubEdit';

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={PubList}/>
            <Route path='/pubs' exact={true} component={PubList}/>
            <Route path='/pubs/:id' component={PubEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;