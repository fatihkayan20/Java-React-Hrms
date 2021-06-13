import axios from "axios";

export const getCities = () => {
  return (dispatch) => {
    axios
      .get("/cities/getall")
      .then((response) => {
        dispatch({
          type: "SET_CITIES",
          payload: response.data.data,
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
};
