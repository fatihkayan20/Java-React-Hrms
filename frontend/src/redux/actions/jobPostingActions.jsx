import axios from "axios";

export const getJobPostings = () => {
  return (dispatch) => {
    axios
      .get("/jobpostings/getactives")
      .then((response) => {
        dispatch({
          type: "SET_JOBPOSTS",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};

export const addJobPosting = (data) => {
  return (dispatch) => {
    axios
      .post("/jobpostings/add", data)
      .then((response) => {
        console.log(response);
        // dispatch({
        //   type: "ADD_JOBPOST",
        //   payload: response.data.data,
        // });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};
