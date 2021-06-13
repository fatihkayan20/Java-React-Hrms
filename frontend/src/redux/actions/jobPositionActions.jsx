import axios from "axios";

export const getJobPositions = () => {
  return (dispatch) => {
    axios
      .get("/jobpositions/getall")
      .then((response) => {
        dispatch({
          type: "SET_JOB_POSITIONS",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};
