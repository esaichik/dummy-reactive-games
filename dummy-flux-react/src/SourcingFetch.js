import {useEffect, useState} from "react";

function EventSourceFetch() {
    const [names, setNames] = useState([]);
    useEffect(() => {
        const eventSource = new EventSource("http://localhost:8080/dummy/infiniteFlux");
        eventSource.onerror = () => eventSource.close();
        eventSource.onmessage = ev => setNames(oldNames => [...oldNames, JSON.parse(ev.data)]);
        return () => eventSource.close();
    }, []);
    return (
        <>
            <h1>Names</h1>
            {names.map(name => <div key={name.id}>{JSON.stringify(name)}</div>)}
        </>
    );
}

export default EventSourceFetch;
