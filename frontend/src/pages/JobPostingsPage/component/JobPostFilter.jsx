import React, { useState } from "react";
import Cities from "./Cities";
import EmploymentTypes from "./EmploymentTypes";
import JobPositions from "./JobPositions";

export default function JobPostFilter() {
  const [state, setState] = useState({
    cityId: "",
    jobPositionId: "",
    employmentTypeId: "",
  });

  const handleChange = (e, name) => {
    setState({
      ...state,
      [name]: e,
    });
  };
  return (
    <div className="fixed top-44 border border-gray-200 px-3 pb-7 pt-3 md:w-60 w-44  shadow-md">
      <Cities handleChange={handleChange} value={state.cityId} name="cityId" />
      <JobPositions
        handleChange={handleChange}
        value={state.jobPositionId}
        name="jobPositionId"
      />
      <EmploymentTypes
        handleChange={handleChange}
        value={state.employmentTypeId}
        name="employmentTypeId"
      />
    </div>
  );
}
