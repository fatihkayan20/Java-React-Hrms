const initialState = {
  jobPostings: [],
};

const jobPost = (state = initialState, action) => {
  switch (action.type) {
    case "SET_JOBPOSTS":
      return { ...state, jobPostings: action.payload };

    default:
      return state;
  }
};

export default jobPost;
