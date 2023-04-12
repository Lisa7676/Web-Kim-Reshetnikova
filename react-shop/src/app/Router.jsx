import {
    Routes,
    Route,
  } from "react-router-dom";
  import Catalog from '../pages/Catalog';
  
  const Router = () => (
    <Routes>
      <Route path="/" element={<Catalog />} />
    </Routes>
  );
  
  export default Router;