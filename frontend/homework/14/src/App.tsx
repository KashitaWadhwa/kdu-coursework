import { Provider } from 'react-redux'
import './App.scss'
import Add from './Components/Add'
import List from './Components/List'
import { store } from './redux/store'
import { SearchItemsBar } from './Components/SearchItemsBar'

function App() {
  return (
    <Provider store={store}>
      <div>
          <div className="heading">
          <div className="logo">
            <h1 className="item-lister">Item Lister</h1>
            <SearchItemsBar />
          </div>
          </div>
          <div className="container">
            <div className="box">
            <div>
              <h2 className="AddItems">Add Items</h2>
              <Add />
            </div>
            <div>
              <h2>Items</h2>
              <List/>
            </div>
          </div>
            </div>
        </div>
      </Provider>
  )
}

export default App
