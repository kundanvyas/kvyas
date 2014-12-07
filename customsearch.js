window.var1=true;

function changeColor(){
    var element = document.getElementById("mytext");
    var imgElement=document.getElementById("imgtag");
    document.getElementById();
    if(window.var1){
        element.style.color= "red";
        window.var1=false;
        imgElement.src="http://www.syntax.com/blog/wp-content/uploads/2013/01/oracle-logo.png";
    }
    else{
        element.style.color= "blue";
        window.var1=true;
        imgElement.src="http://cdn.physorg.com/newman/gfx/news/hires/2009/theoraclelog.jpg";
    }
    
}

