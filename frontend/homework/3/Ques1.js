
function tipCalculator(bills) {
    let tips = [];
    let finalAmounts = [];
    
    for (let i = 0; i < bills.length; i++) {
        let bill = bills[i];
        let tip;
        
        if (bill < 50) {
            tip = bill * 0.20; 
        } else if (bill >= 50 && bill <= 200) {
            tip = bill * 0.15; 
        } else {
            tip = bill * 0.10; 
        }        
        tips.push(tip);
        finalAmounts.push(bill + tip);
    }
    
    return [tips, finalAmounts];
}

let bills = [140, 45, 280];
let [tips, finalAmounts] = tipCalculator(bills);

console.log("All three tips:", tips);
console.log("All three final paid amounts(bill + tip):", finalAmounts);
