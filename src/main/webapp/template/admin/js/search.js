 function object(){
        if (window.XMLHttpRequest) {
// code for IE7+, Firefox, Chrome, Opera, Safari
xmlhttp=new XMLHttpRequest();
} else { // code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
return xmlhttp;
}
http = object();
function livesearch(data){
    if(data != ""){
        http.onreadystatechange = process;
        http.open('GET', 'ajax/search.php?data=' + data, true);
        http.send();
    }else{
        window.location.href = "index.php";;
    }
}
function process(){
    if(http.readyState==4 && http.status==200){
        result = http.responseText;
        document.getElementById("mytable").innerHTML = result;
    }
} 