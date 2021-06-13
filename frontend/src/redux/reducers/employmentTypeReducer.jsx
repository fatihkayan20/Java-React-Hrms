const initialState = {
  types: [],
};

const employmentType = (state = initialState, action) => {
  switch (action.type) {
    case "SET_EMPLOYMENT_TYPES":
      return { ...state, types: action.payload };

    default:
      return state;
  }
};

export default employmentType;
