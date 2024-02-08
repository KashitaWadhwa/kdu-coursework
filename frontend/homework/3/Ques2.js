const daysofweek=["Sunday   ","   Monday  ","  Tuesday","Wednesday  ","  Thursday   ","   Friday","Saturday    "]
const finalArray = [];

for (let i = 0; i < daysofweek.length; i++) {
    let trimmedDay = daysofweek[i].trim().substring(0, 3).toUpperCase();
    finalArray.push(trimmedDay);
}

console.log('[' +"'"+ finalArray.join("', '") + "'"+']');