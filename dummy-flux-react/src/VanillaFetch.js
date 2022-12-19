import {useEffect, useState} from "react";

function VanillaFetch() {
    const [names, setNames] = useState([]);
    useEffect(() => {
        const controller = new AbortController();
        const { signal } = controller;
        fetch("http://localhost:8080/dummy/infiniteFlux", {signal})
            .then(res => res.json())
            .then(setNames);
        return () => controller.abort();
    }, []);
    return (
        <>
            <h1>Names</h1>
            {names.map(name => <div key={name.id}>{JSON.stringify(name)}</div>)}
        </>
    );
}

export default VanillaFetch;
