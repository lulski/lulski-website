//import logo from "./logo.svg";
//import "./App.css";
import Create from "./components/login";
import Index from "./components/bulma/BulmaApp.jsx";
import BulmaColumn from "./components/bulma/BulmaColumn";
//import { BrowserRouter as Router, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Routes from "./routes/index.js";
import AuthProvider from "./provider/authProvider.js";

export const App = () => {
  return (
    <AuthProvider>
      <Routes />
    </AuthProvider>
  );
};
