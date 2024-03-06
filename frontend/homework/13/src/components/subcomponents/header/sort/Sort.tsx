import './Sort.scss'
export function Sort() {
  return (
    <div >
      <form>
        <label className="sort-heading" htmlFor="sort">Sort : </label>
        <select className="sort-bar" id="sort" name="sort">
          <option  value="Price">Price</option>
          <option value="ASC">ASC</option>
          <option value="DESC">DESC</option>
        </select>
      </form>
    </div>
  )
}
