import React, { useEffect, useState } from "react";
import "./App.scss";
import {ApiQuote} from "./types/quotes.types";
import { Quote } from "./components/Quotes/Quote";
import { Filter } from "./components/FilterContainer/FilterContainer";

function App() {
  let [quotes, setQuotes] = useState<ApiQuote[]>([]);

  const [filterArray, setFilterArray] = useState<string[]>([]);

  function addAQuote() {
    fetch("https://api.quotable.io/quotes/random")
      .then((response) => response.json())
      .then((data: ApiQuote[]) => {
        setQuotes([...data, ...quotes]);
        console.log(quotes);
      });
  }

  const handleDeleteFilter = (filterArray: string) => {
    setFilterArray((prevFilters) => prevFilters.filter((f) => f !== filterArray));
  };

  useEffect(() => {
    //this runs only once
    fetch("https://api.quotable.io/quotes/random?limit=3")
      .then((response) => response.json())
      .then((data: ApiQuote[]) => {
        setQuotes(data);
      });
    console.log("fetched 3", quotes);
  }, []);

  const filteredQuotes = quotes.filter(
    (quote) =>
      filterArray.length === 0 ||
      filterArray.some((tag) => quote.tags.includes(tag))
  );

  return (
    <div className="app">
      <button onClick={addAQuote} id="new-quote_button">NEW QUOTE</button>
      <Filter filters={filterArray} onDeleteFilter={handleDeleteFilter}/>
      {filteredQuotes.map((quote) => {
        return (
          <Quote setFilter={setFilterArray} key={quote._id} quote={quote} />
        );
      })}
    </div>
  );
}

export default App;