/**
 * javascript
 */
var button = document.getElementById("myBtn");
button.addEventListener("click", myFunction);
function myFunction() {
    alert ("Hello World!");
    var v1 = document.getElementById('n1').value;
    var v2 = document.getElementById('n2').value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    	  if (this.readyState == 4 && this.status == 200) {
    		  console.log("sucess");
    		  console.log(xhttp.response);
    	  }
    	};
    	xhttp.open("POST", "http://localhost:8080/Cloudnet/login/doLogin", true);
    	xhttp.send();
}

