const initialState = {
  cities: [],
};

const jobPost = (state = initialState, action) => {
  switch (action.type) {
    case "SET_CITIES":
      return { ...state, cities: action.payload };

    default:
      return state;
  }
};

export default jobPost;
