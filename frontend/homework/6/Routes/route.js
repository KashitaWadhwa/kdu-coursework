const express = require('express');
const router = express.Router();
const {createPost,getAllPosts,getPostbyId} = require('../Controllers/posts');

//default route
router.get('/', (req, res) => {
    res.send('Hello World');
});


//router to create new post
router.post('/create-post', createPost);

//router to get all posts
router.get('/posts', getAllPosts);

//router to get post by id
router.get('/post/:id', getPostbyId);

//export router
module.exports = router;