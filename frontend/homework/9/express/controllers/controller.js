//create a new post
const posts=[];
exports.createPost = async (req, res) => {
    try{
        const {message}=req.body;
        if(!message){
            return res.status(400).json({status:false,message:'Please enter a message'});
        }
        posts.push({message});
        res.status(201).json({status:true,message:'Post created successfully',data:posts});
    }catch(err){
        res.status(500).json({status:false,message:'Server error occured',error:err.message});
    }
};

//display all posts

//chat page