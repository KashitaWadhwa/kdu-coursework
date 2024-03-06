import './Filter.scss'
export function Filter() {
  return (
    <div >
      <form>
        <label className= " filter-heading" htmlFor="filter">Filter : </label>
        <select className="filter-bar" id="filter" name="filter">
          <option value="Brand">Brand</option>
        </select>
      </form>
    </div>
  )
}