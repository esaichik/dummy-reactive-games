import {Link} from "react-router-dom"

function IndexPage() {
    return (<>
        <div>You can try either <Link to="/vanillaFetch">old vanilla fetch</Link></div>
        <div>or "new" <Link to="/eventSourceFetch">event sourcing</Link></div>
        <div>anyway make sure that you have open "Network" tab in dev tools</div>
    </>);
}

export default IndexPage;
