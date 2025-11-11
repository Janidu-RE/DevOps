import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="bg-white shadow-md py-4 px-8 flex items-center justify-between">
      {/* --- Left: Logo --- */}
      <Link to="/" className="text-3xl font-extrabold text-emerald-700 tracking-wide">
        Salon<span className="text-emerald-500">LK</span>
      </Link>

      {/* --- Center: Navigation Links --- */}
      <div className="hidden md:flex space-x-8">
        <Link
          to="/about"
          className="text-gray-700 font-medium hover:text-emerald-600 transition duration-300"
        >
          About Us
        </Link>
        <Link
          to="/services"
          className="text-gray-700 font-medium hover:text-emerald-600 transition duration-300"
        >
          Our Services
        </Link>
        <Link
          to="/contact"
          className="text-gray-700 font-medium hover:text-emerald-600 transition duration-300"
        >
          Contact Us
        </Link>
      </div>

      {/* --- Right: Login/Signup Button --- */}
      <div>
        <Link
          to="/login"
          className="bg-emerald-600 text-white px-5 py-2 rounded-lg font-semibold hover:bg-emerald-700 transition duration-300 shadow-md"
        >
          Login / Signup
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
