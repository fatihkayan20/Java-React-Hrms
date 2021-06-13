import { Provider } from "react-redux";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Navbar from "./components/layout/navbar";
import HomePage from "./pages/HomePage";
import JobPostingsPage from "./pages/JobPostingsPage";
import JobPostingsAddPage from "./pages/JobPostingsAddPage";
import store from "./redux/store";

function App() {
  return (
    <Provider store={store}>
      <Router>
        <Navbar />
        <Switch>
          <Route exact path="/" component={HomePage} />
          <Route exact path="/jobpostings" component={JobPostingsPage} />
          <Route exact path="/jobpostings/add" component={JobPostingsAddPage} />
        </Switch>
      </Router>
    </Provider>
  );
}

export default App;
