import {
  FormControl,
  FormHelperText,
  InputLabel,
  MenuItem,
  Select,
} from "@material-ui/core";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getJobPositions } from "../../../redux/actions/jobPositionActions";

export default function JobPositions({
  value,
  handleChange,
  error,
  errorMessage,
  name,
}) {
  const dispatch = useDispatch();
  const jobPositions = useSelector((state) => state.jobPosition.jobPositions);
  useEffect(() => {
    dispatch(getJobPositions());
  }, [dispatch]);
  return (
    <div className="mt-4">
      <FormControl className="w-full">
        <InputLabel id="demo-simple-select-label"> Job Position </InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={value}
          name={name}
          onChange={handleChange}
          error={error}
        >
          <MenuItem value={0}> Select a position </MenuItem>
          {jobPositions.map((jobPosition) => (
            <MenuItem key={jobPosition.id} value={jobPosition.id}>
              {jobPosition.title}
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
