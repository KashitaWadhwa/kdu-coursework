import { ApiQuote } from '../../types/quotes.types'
import './Quote.scss'

interface QuoteProps{
    setFilter:React.Dispatch<React.SetStateAction<string[]>>
    quote : ApiQuote;
}
export function Quote({setFilter,quote}: Readonly<QuoteProps>) {

    function filterTheQuotes(event: React.MouseEvent<HTMLSpanElement>) {
        let selectedTag = event.currentTarget.textContent ?? '';
      
        setFilter((previous) => {
          if (!previous.includes(selectedTag)) {
            return [...previous, selectedTag];
          }
          return previous;
        });
      }
      
  return (
    <div className='quote-container'>
      <h2>{quote.content}</h2>
      <p className='author'>~{quote.author}</p>
      <p>{quote.dateAdded}</p>

      <div className='tags-container'>
        {quote.tags.map((q) => {
          return (
            <button
              key={q}
              onClick={filterTheQuotes}
              className='tag-item'
              tabIndex={0}
            >
              {q}
            </button>
          );
        })}
      </div>
    </div>
  );
}