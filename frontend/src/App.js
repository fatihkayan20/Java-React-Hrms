import { Provider } from "react-redux";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Navbar from "./components/layout/navbar";
import store from "./redux/store";
import HomePage from "./pages/HomePage";
import JobPostingsPage from "./pages/JobPostingsPage";

function App() {
  return (
    <Provider store={store}>
      <Router>
        <Navbar />
        <div className="container">
          <Switch>
            <Route path="/" component={HomePage} />
            <Route path="/jobpostings" component={JobPostingsPage} />
          </Switch>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
