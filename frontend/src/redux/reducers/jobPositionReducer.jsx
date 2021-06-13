const initialState = {
  jobPositions: [],
};

const jobPosition = (state = initialState, action) => {
  switch (action.type) {
    case "SET_JOB_POSITIONS":
      return { ...state, jobPositions: action.payload };

    default:
      return state;
  }
};

export default jobPosition;
