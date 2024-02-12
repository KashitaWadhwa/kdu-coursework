const addTodoInput = document.getElementById('add_todo');
const addButton = document.getElementById('btn');
const displayDiv = document.getElementById('display');
const todoArray = [];

function displayTodos() {
    displayDiv.innerHTML = '';

    todoArray.forEach(function(todo, index) {
        const todoDiv = document.createElement('div');
        todoDiv.classList.add('todo-item');         
        const todoText = document.createTextNode(todo);     
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.classList.add('btn-delete')
        
        deleteButton.addEventListener('click', function() {            
            todoArray.splice(index, 1);            
            displayTodos();
        });
       
        todoDiv.appendChild(todoText);
        todoDiv.appendChild(deleteButton);
        displayDiv.appendChild(todoDiv);
    });
}

function addTodo() {
    const todo = addTodoInput.value.trim();
    if (todo.length === 0) {
        alert('Please enter a valid input');
    } else {
        todoArray.push(todo);
        addTodoInput.value = '';
        displayTodos(); 
    }
}
addButton.addEventListener('click', addTodo);
