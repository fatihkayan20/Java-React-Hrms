import React from "react";
import { useFormik } from "formik";
import * as yup from "yup";
import Cities from "../JobPostingsPage/component/Cities";
import EmploymentTypes from "../JobPostingsPage/component/EmploymentTypes";
import JobPositions from "../JobPostingsPage/component/JobPositions";
import {
  FormControl,
  FormHelperText,
  Input,
  InputLabel,
  MenuItem,
  Select,
} from "@material-ui/core";
import { addJobPosting } from "../../redux/actions/jobPostingActions";
import { useDispatch } from "react-redux";

const validationSchema = yup.object({
  quota: yup
    .number()
    .required("Quota is required")
    .min(0, "Quota must be greater than 0"),
  minSalary: yup
    .number()
    .required("Min salary is required")
    .min(0, "Min salary must be greater than 0"),
  description: yup.string().required("Description is required"),
  remote: yup.boolean().required("Remote is required"),

  city: yup.object({
    id: yup.number().required("City is required").min(1, "City is required"),
  }),

  jobPosition: yup.object({
    id: yup
      .number()
      .required("Job position is required")
      .min(1, "Job position is required"),
  }),

  employmentType: yup.object({
    id: yup
      .number()
      .required("Employment type is required")
      .min(1, "Employment type is required"),
  }),
});

export default function JobPostingAdd() {
  const dispatch = useDispatch();
  const formik = useFormik({
    initialValues: {
      employer: {
        id: 1,
      },
      city: {
        id: 0,
      },
      jobPosition: { id: 0 },
      employmentType: { id: 0 },
      quota: "",
      minSalary: "",
      maxSalary: "",
      description: "",
      appealDeadline: null,
      remote: "",
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      dispatch(addJobPosting(values));
    },
  });

  return (
    <div className="flex flex-row w-full md:max-w-5xl mx-auto mt-5">
      <form className="w-full" onSubmit={formik.handleSubmit}>
        <Cities
          handleChange={formik.handleChange}
          value={formik.values.city.id}
          name="city.id"
          error={formik.touched.city?.id && Boolean(formik.errors.city?.id)}
          errorMessage={formik.touched.city?.id && formik.errors.city?.id}
        />

        <JobPositions
          handleChange={formik.handleChange}
          value={formik.values.jobPosition.id}
          name="jobPosition.id"
          error={
            formik.touched.jobPosition?.id &&
            Boolean(formik.errors.jobPosition?.id)
          }
          errorMessage={
            formik.touched.jobPosition?.id && formik.errors.jobPosition?.id
          }
        />
        <EmploymentTypes
          handleChange={formik.handleChange}
          value={formik.values.employmentType.id}
          name="employmentType.id"
          error={
            formik.touched.employmentType?.id &&
            Boolean(formik.errors.employmentType?.id)
          }
          errorMessage={
            formik.touched.employmentType?.id &&
            formik.errors.employmentType?.id
          }
        />
        <div className="w-full mt-3">
          <FormControl className="w-full">
            <InputLabel htmlFor="quota"> Quota </InputLabel>
            <Input
              id="quota"
              name="quota"
              value={formik.values.quota}
              onChange={formik.handleChange}
              error={formik.touched.quota && Boolean(formik.errors.quota)}
            />
            <FormHelperText className="helper-text" id="my-helper-text">
              {formik.touched.quota && formik.errors.quota}
            </FormHelperText>
          </FormControl>
        </div>

        <div className="w-full mt-3">
          <FormControl className="w-full">
            <InputLabel htmlFor="minSalary"> Min Salary </InputLabel>
            <Input
              id="minSalary"
              name="minSalary"
              value={formik.values.minSalary}
              onChange={formik.handleChange}
              error={
                formik.touched.minSalary && Boolean(formik.errors.minSalary)
              }
            />
            <FormHelperText className="helper-text" id="my-helper-text">
              {formik.touched.minSalary && formik.errors.minSalary}
            </FormHelperText>
          </FormControl>
        </div>

        <div className="w-full mt-3">
          <FormControl className="w-full">
            <InputLabel htmlFor="maxSalary"> Max Salary </InputLabel>
            <Input
              id="maxSalary"
              name="maxSalary"
              value={formik.values.maxSalary}
              onChange={formik.handleChange}
              error={
                formik.touched.maxSalary && Boolean(formik.errors.maxSalary)
              }
            />
            <FormHelperText className="helper-text" id="my-helper-text">
              {formik.touched.maxSalary && formik.errors.maxSalary}
            </FormHelperText>
          </FormControl>
        </div>

        <div className="w-full mt-3">
          <FormControl className="w-full">
            <InputLabel htmlFor="description"> Description </InputLabel>
            <Input
              id="description"
              name="description"
              multiline
              rows={4}
              value={formik.values.description}
              onChange={formik.handleChange}
              error={
                formik.touched.description && Boolean(formik.errors.description)
              }
            />
            <FormHelperText className="helper-text" id="my-helper-text">
              {formik.touched.description && formik.errors.description}
            </FormHelperText>
          </FormControl>
        </div>

        <div className="w-full mt-3">
          <FormControl className="w-full">
            <InputLabel htmlFor="remote"> Remote </InputLabel>
            <Select
              id="remote"
              name="remote"
              value={formik.values.remote}
              onChange={formik.handleChange}
              error={formik.touched.remote && Boolean(formik.errors.remote)}
            >
              <MenuItem value={true}> Remote </MenuItem>
              <MenuItem value={false}> Not Remote </MenuItem>
            </Select>
            <FormHelperText className="helper-text" id="my-helper-text">
              {formik.touched.remote && formik.errors.remote}
            </FormHelperText>
          </FormControl>
        </div>

        <button type="submit" onClick={() => console.log(formik)}>
          Add
        </button>
      </form>
    </div>
  );
}
