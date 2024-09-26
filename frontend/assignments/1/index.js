post_btn=document.getElementById('post_btn');
mobile_add=document.getElementById('mobile_add');
mobile=document.getElementById('mobile');
mobile_tweet=document.getElementById('mobile-tweet');
back=document.getElementById('back');
mobile_add.addEventListener('click', function(){
mobile.style.display='none';
mobile_tweet.style.display='block';
console.log(mobile_tweet)
}
);

back.addEventListener('click', function(){
    mobile.style.display='block';
    mobile_tweet.style.display='none';
});