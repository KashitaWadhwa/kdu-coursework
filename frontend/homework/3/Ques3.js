const shoes = [
    { type: 'sandals', color: 'black', size: '10', price: 2100 },
    { type: 'boots', color: 'pink', size: '9', price: 1500 }
];

const shirts = [
    { type: 't-shirt', color: 'pink', size: 'L', price: 1500 },
    { type: 'shirt', color: 'blue', size: 'M', price: 900 },
    { type: 'top', color: 'green', size: 'S', price: 2100 }
];

const warehouse = [...shoes, ...shirts];

const totalWorth = warehouse.reduce(function(total, product) {
    return total + product.price;
}, 0);

warehouse.sort(function(a, b) {
    return b.price - a.price;
});

const blackProducts = warehouse.filter(function(product) {
    return product.color === 'black';
});

console.log("Warehouse:", warehouse);
console.log("Total worth of products stored in the warehouse:", totalWorth);
console.log("Warehouse products which are black in color:", blackProducts);
