import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import MainPage from "./page/mainPage";
function App() {
  return (
      <BrowserRouter>
          <Routes>
              <Route path="*" element={<Navigate replace to="/main"/>}/>
              <Route path="/main" element={<MainPage/>} exact={true}/>
          </Routes>
      </BrowserRouter>
  );
}

export default App;
