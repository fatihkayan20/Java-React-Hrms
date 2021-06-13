import {
  FormControl,
  FormHelperText,
  InputLabel,
  MenuItem,
  Select,
} from "@material-ui/core";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getEmploymentTypes } from "../../../redux/actions/employmentTypeActions";

export default function EmploymentTypes({
  handleChange,
  value,
  error,
  errorMessage,
}) {
  const dispatch = useDispatch();
  const types = useSelector((state) => state.employmentType.types);
  useEffect(() => {
    dispatch(getEmploymentTypes());
  }, [dispatch]);
  return (
    <div className="mt-4">
      <FormControl className="w-full">
        <InputLabel id="demo-simple-select-label"> Employment Type </InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={value}
          name="employmentType.id"
          onChange={handleChange}
          error={error}
        >
          <MenuItem value={0}> Select a type </MenuItem>
          {types.map((type) => (
            <MenuItem key={type.id} value={type.id}>
              {type.name}
            </MenuItem>
          ))}
        </Select>{" "}
        <FormHelperText className="helper-text" id="my-helper-text">
          {errorMessage}
        </FormHelperText>
      </FormControl>
    </div>
  );
}
