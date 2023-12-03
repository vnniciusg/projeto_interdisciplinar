import { useNavigate } from "react-router-dom";
import LoginContext from "contexts/AuthContext";
import React from "react";

const ProtectedRoute = () =>{
    const navigate = useNavigate();
    const {isLoggedIn} = React.useContext(LoginContext)
    if (!isLoggedIn) {
      navigate("/sign-in");
      return(<div>test</div>);
}
}

<<<<<<< Updated upstream
export default ProtectedRoute;
=======
export default ProtectedRoute;
>>>>>>> Stashed changes
