import { createBrowserRouter } from "react-router-dom";

import { Home } from "../pages/Home";
import { SignUp } from "../pages/SignUp";
import App from "../App";

export default createBrowserRouter([
  {
    path: "/",
    Component: App,
    children: [
      {
        path: "/",
        Component: Home,
      },
      {
        path: "/signup",
        Component: SignUp,
      },
    ],
  },
]);
