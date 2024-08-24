//import logo from "./logo.svg";
//import "./App.css";
import Create from "./components/create";
import Index from "./components/bulma/BulmaApp.jsx";
import BulmaColumn from "./components/bulma/BulmaColumn";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

export const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Index />} />
      </Routes>
      <Routes>
        <Route exact path="/create" element={<Create />} />
      </Routes>
      <Routes>
        <Route exact path="/bulma" element={<BulmaColumn />} />
      </Routes>
    </Router>
  );
};
