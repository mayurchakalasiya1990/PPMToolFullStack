import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';
import "bootstrap/dist/css/bootstrap.min.css"
import Header from './components/Layout/Header';
import { BrowserRouter as Router,Route, Link } from "react-router-dom";
import AddProject from './components/Project/AddProject';
import {Provider} from 'react-redux'
import {store} from './store'

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Header/>        
          <Route path="/dashboard" component={Dashboard}/>
          <Route path="/addProject" component={AddProject}/>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
