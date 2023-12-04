import { Navigate, Outlet } from "react-router-dom";
import LoginContext from "contexts/AuthContext";
import React from "react";

const ProtectedRoute = () => {
  const { isLoggedIn } = React.useContext(LoginContext);
  if (!isLoggedIn) {
    return <Navigate to="/login" />;
  }
  return <Outlet/>
};

export default ProtectedRoute;
