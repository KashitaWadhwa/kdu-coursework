import "./App.scss";
import Header from "./component/Header";
import Section from "./component/Section";
import { persistor, store } from "./redux/Store";
import { Provider } from "react-redux";
import { PersistGate } from "redux-persist/integration/react";

function App() {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <div className="main-container">
          <Header />
          <Section />
        </div>
      </PersistGate>
    </Provider>
  );
}

export default App;
