import {
  FormControl,
  FormHelperText,
  InputLabel,
  MenuItem,
  Select,
} from "@material-ui/core";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getCities } from "../../../redux/actions/cityActions";

export default function Cities({ handleChange, value, error, errorMessage }) {
  const dispatch = useDispatch();
  const cities = useSelector((state) => state.city.cities);
  useEffect(() => {
    dispatch(getCities());
  }, [dispatch]);
  return (
    <div>
      <FormControl className="w-full">
        <InputLabel id="demo-simple-select-label"> City </InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          name="city.id"
          value={value}
          onChange={handleChange}
          error={error}
        >
          <MenuItem value={0}> Select a city </MenuItem>
          {cities.map((city) => (
            <MenuItem key={city.id} value={city.id}>
              {city.name}
            </MenuItem>
          ))}
        </Select>

        <FormHelperText className="helper-text" id="my-helper-text">
          {errorMessage}
        </FormHelperText>
      </FormControl>
    </div>
  );
}
