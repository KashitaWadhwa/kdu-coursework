import CardList from './CardList'
import './Container.scss'
export function Container() {
  return (
    <div>
      <div className="container-heading">
        <span className="kdu">KDU  {'\u00A0'}</span>
        <span className="marketplace">MARKETPLACE</span>
      </div>
      {/* product list  */}
      <CardList/>
    </div>
  )
}
