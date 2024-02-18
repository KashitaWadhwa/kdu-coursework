const express=require('express');
const router=express.Router();
const{createPost}=require('../controllers/controller.js');
const {login} = require('../controllers/contrlogin.js');

router.post('/posts',createPost);
router.post("/user/login",login);
module.exports=router;