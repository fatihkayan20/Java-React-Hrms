import { Work } from "@material-ui/icons";
import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div className="bg-gray-500 w-full h-20">
      <div className="h-full w-full max-w-5xl m-auto flex flex-row items-center justify-between">
        <div className="navbar-left  flex flex-row items-center">
          <div className="navbar-logo flex flex-row items-center cursor-pointer">
            <span className="logo-title ml-2 text-pink-400 text-xl">
              JobSeek
            </span>
          </div>

          <div className="navbar-links flex flex-row items-center mx-10">
            <Link
              to="/jobpostings"
              className="nav-link flex flex-row items-center cursor-pointer"
            >
              <Work className="text-white" />
              <div className="nav-link-text ml-1 text-white ">Job Postings</div>
            </Link>
          </div>
        </div>
        <div className="navbar-right">Login</div>
      </div>
    </div>
  );
}

export default Navbar;
