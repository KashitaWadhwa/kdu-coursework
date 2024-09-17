const socket = io();

const form = document.getElementById('form');
const input = document.getElementById('input');
const messages = document.getElementById('messages');

form.addEventListener('submit', function(e) {
    e.preventDefault();
    if (input.value) {
        const messageData = {
            message: input.value,
            image: 'u.jpg'
        };

        socket.emit('chat message', messageData);
        input.value = '';
        if (messageData.image === 'u.jpg') {
            messageData.image = 'y.jpg';
        }
    }
});

socket.on('chat message', function(data) {
    const message = data.message;
    const image = data.image;

    const listItem = document.createElement('div');

    const imageElement = document.createElement('img');
    imageElement.src = image;
    imageElement.alt = 'Image';

    listItem.appendChild(imageElement); // Append the image element first
    listItem.appendChild(document.createTextNode(message)); // Append the text node after the image
    messages.appendChild(listItem);
});
