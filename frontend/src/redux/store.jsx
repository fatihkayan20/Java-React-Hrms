import { createStore, combineReducers, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";

import jobPostingReducer from "./reducers/jobPostingReducer";
import cityReducer from "./reducers/cityReducer";
import jobPositionReducer from "./reducers/jobPositionReducer";
import employmentTypeReducer from "./reducers/employmentTypeReducer";

const initialState = {};

const middleware = [thunk];

const reducers = combineReducers({
  jobPosting: jobPostingReducer,
  city: cityReducer,
  jobPosition: jobPositionReducer,
  employmentType: employmentTypeReducer,
});

const composeEnhancers =
  typeof window === "object" && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
    ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({})
    : compose;

const enhancer = composeEnhancers(applyMiddleware(...middleware));
const store = createStore(reducers, initialState, enhancer);

export default store;
