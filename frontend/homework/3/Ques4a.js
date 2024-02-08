const inputString = '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24,"city":"london","country":"england"}';
const jsonObject = JSON.parse(inputString);
for (let key in jsonObject) {
    if (typeof jsonObject[key] === 'string') {
        if (key !== 'email') {
            jsonObject[key] = jsonObject[key].toUpperCase();
        }
    }
}

console.log(jsonObject);
