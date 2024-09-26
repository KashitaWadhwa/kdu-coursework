const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function getObjectInfo(obj) {
    const keys = [];
    const values = [];
    const valueTypes = [];

    function traverseObject(object) {
        for (let key in object) {
            const value = object[key];
            if (typeof value === 'object' && value !== null && !Array.isArray(value)) {
                traverseObject(value);
            } else {
                keys.push(key);
                values.push(value);
                valueTypes.push(typeof value);
            }
        }
    }

    traverseObject(obj);

    return {
        keys: keys,
        values: values,
        valueTypes: valueTypes
    };
}

rl.question('Enter a JSON object: ', (input) => {
    try {
        const jsonObject = JSON.parse(input);
        const objectInfo = getObjectInfo(jsonObject);
        console.log("All keys:", objectInfo.keys);
        console.log("All values:", objectInfo.values);
        console.log("Value types:", objectInfo.valueTypes);
    } catch (error) {
        console.error("Invalid input. Please enter a valid JSON object.");
    }

    rl.close();
});
        
