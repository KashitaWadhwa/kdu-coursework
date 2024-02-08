const inputString = '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24,"city":"london","country":"england"}';

const jsonObject = JSON.parse(inputString);
delete jsonObject.email;
const modifiedString = JSON.stringify(jsonObject);

console.log(modifiedString);
