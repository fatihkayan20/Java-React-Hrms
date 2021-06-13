import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getJobPostings } from "../../redux/actions/jobPostingActions";
import JobPostFilter from "./component/JobPostFilter";
import JobPosts from "./component/JobPosts";

export default function JobPostings() {
  const dispatch = useDispatch();
  const jobPostings = useSelector((state) => state.jobPosting.jobPostings);
  useEffect(() => {
    dispatch(getJobPostings());
  }, [dispatch]);
  return (
    <div>
      <div className="flex flex-row w-full   md:max-w-5xl mx-auto">
        <JobPostFilter />

        <JobPosts jobPostings={jobPostings} />
      </div>
    </div>
  );
}
