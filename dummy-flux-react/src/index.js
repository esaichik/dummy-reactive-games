import React from 'react';
import ReactDOM from 'react-dom/client';
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import VanillaFetch from './VanillaFetch';
import EventSourceFetch from "./SourcingFetch";
import IndexPage from "./IndexPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <IndexPage/>,
    },
    {
        path: "/vanillaFetch",
        element: <VanillaFetch/>,
    },
    {
        path: "/eventSourceFetch",
        element: <EventSourceFetch/>,
    },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>
);
