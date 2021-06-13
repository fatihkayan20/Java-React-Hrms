import axios from "axios";

export const getEmploymentTypes = () => {
  return (dispatch) => {
    axios
      .get("/employmenttypes/getall")
      .then((response) => {
        dispatch({
          type: "SET_EMPLOYMENT_TYPES",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};
