import './FilterContainer.scss'
interface IFilterProp{
    filters:string[];
    onDeleteFilter: (filter: string) => void;
}
export function Filter({filters, onDeleteFilter }: Readonly<IFilterProp>) {
  return (
    <div className='container'>
      Filters
      {filters.map((filter) => (
        <div className='filter-item-container' key={filter} style={{ display: 'inline-block', margin: '4px' }}>
          <span className='filter-item'>{filter}</span>
          <button className='delete-button' onClick={() => onDeleteFilter(filter)}>X</button>
        </div>
      ))}
    </div>
  )
}