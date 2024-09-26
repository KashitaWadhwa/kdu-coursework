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

const player = {
    firstName: "Leo",
    lastName: "Messi",
    address: {
        country: "Spain",
        city: "Barcelona",
    },
    careerInfo: {
        fcBarcelona: {
            appearances: 780,
            goals: {
                premierLeagueGoals: 590,
                championsLeagueGoals: 50,
            },
        },
    },
};

const playerInfo = getObjectInfo(player);
console.log("All keys:", playerInfo.keys);
console.log("All values:", playerInfo.values);
console.log("Value types:", playerInfo.valueTypes);
