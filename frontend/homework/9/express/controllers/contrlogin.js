const users =[{
    username: 'admin',
    password: 'admin'
}, {
    username: 'user',
    password: 'user'
}, {
    username: 'test',
    password: 'test'
}];

exports.login= (req, res) => {
    try{
        const {username, password}=req.body;
        if(!username || !password){
           return res.status(400).json({status:false,message:'Invalid credentials'});
        }


        if(users.find(user=>user.username===username && user.password===password)){
          return   res.status(200).json({status:true,message:'Login successful'});
        }
        else 
        return res.status(401).json({status:false,message:'Invalid credentials'});
    }catch(err){
       return res.status(500).json({status:false,message:'Server error occured',error:err.message});
    }
}

