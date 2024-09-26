//create a new post 
const {v4: uuidv4} = require('uuid');
const posts =[];
exports.createPost = (req, res) => {
   try {
     //getting message from req body
     const{message} = req.body;

     //validating the input
     if(!message){
         return res.status(400).json({
             error: 'Message is required'
         });
     }
     //creating a new post
     const uuid = uuidv4();

            const newPost = {
                message,
                postId: uuid,
                createdAt: new Date().toISOString(),
                updatedAt: new Date().toISOString()
            };
     //saving the post
     posts.push(newPost);
     
        //sending the response
        res.status(201).json({
            message: 'Post created successfully',
            post: newPost
        });
   } catch (error) {
        res.status(500).json({
            error: 'Server error. Post not created. Please try again.',
            message: error.message
        });
   }
}


//getting all posts
exports.getAllPosts = (req, res) => {
    try {
        res.status(200).json({
            message: 'All posts',
            posts
        });
    } catch (error) {
        res.status(500).json({
            error: 'Server error. Unable to get posts. Please try again.',
            message: error.message
        });
    }
}


//getting post by id
exports.getPostbyId = (req, res) => {
    try {
        const id = req.params.id;

        //validating the input
        if(!id){
            return res.status(400).json({
                error: 'Post id is required'
            });
        }

        //finding the post
        const post = posts.find(post => post.postId === id);

        //validating the post
        if(!post){
            return res.status(404).json({
                error: 'Post not found'
            });
        }

        //sending the response
        res.status(200).json({
            message: 'Post found',
            post
        });

    } catch (error) {
        res.status(500).json({
            error: 'Server error. Unable to get post. Please try again.',
            message: error.message
        });
    }
    
};
