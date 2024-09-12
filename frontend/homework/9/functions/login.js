const submitbtn = document.getElementById('btn');
const username = document.getElementById('username');
const password = document.getElementById('password');
submitbtn.addEventListener('click', (e) => {
e.preventDefault();
fetch("http://localhost:4075/api/user/login", {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ username: username.value, password: password.value })
}).then(res => res.json()).then(data => {
    if (data.status) {
        
        window.location.href = "http://127.0.0.1:5500/public/home.html";
    } else {
        alert(data.message);
    }
})
});