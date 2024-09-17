const os= require('os');
const file = require('fs');

const osMetheods =()=>{
    const data = {
        hostname: os.hostname(),
        platform: os.platform(),
        arch: os.arch(),
        release: os.release(),
        uptime: os.uptime(),
        cpus: os.cpus(),
        totalmem: os.totalmem(),
        freemem: os.freemem(),
        currentworkdir: os.homedir()
    }
    
    file.writeFileSync('os.json', JSON.stringify(data));
    
    const readData = file.readFileSync('os.json', 'utf-8');

    return readData;
}

console.log(osMetheods());

