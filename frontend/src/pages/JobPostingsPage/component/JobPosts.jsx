import moment from "moment";
import React from "react";

export default function JobPosts({ jobPostings }) {
  return (
    <div className="ml-48 md:ml-64 mt-5 md:w-1/2   xl:w-1/2 w-full max-w-md md:max-w-full">
      {jobPostings.map((jobPosting) => (
        <div
          key={jobPosting.id}
          className=" border border-gray-200 px-3 py-2 mt-3 shadow-md rounded-md"
        >
          <div className="">
            <div className="font-bold">{jobPosting.jobPosition?.title}</div>
            <div className="text-sm text-gray-600 uppercase">
              {jobPosting.employer?.companyName}
            </div>
            <div className="text-xs text-gray-500">{jobPosting.city?.name}</div>
          </div>

          <div>
            <div className="text-xs  mt-3 mb-1  self-center ">
              {jobPosting.description.substring(0, 150)} ...
            </div>
          </div>

          <div className="flex items-center justify-between">
            <div className="flex mt-3 items-center  ">
              <div className="text-xs text-gray-700 border border-gray-300 rounded-full px-2 bg-gray-200 self-center mr-2">
                {jobPosting.employmentType?.name}
              </div>
              <div className="text-xs text-gray-700 border border-gray-300 rounded-full px-2 bg-gray-200 self-center mr-2">
                Quota: {jobPosting.quota}
              </div>
              <div className="text-xs text-gray-700 border border-gray-300 rounded-full px-2 bg-gray-200 self-center mr-2">
                {jobPosting.remote ? "Remote" : "Not Remote"}
              </div>
            </div>
            <div className="text-xs self-center">
              {moment(jobPosting.createdDate).fromNow()}
            </div>
          </div>
          {/* <div>{jobPosting.minSalary}</div>
          <div>{jobPosting.maxSalary}</div>
          */}
        </div>
      ))}
    </div>
  );
}
