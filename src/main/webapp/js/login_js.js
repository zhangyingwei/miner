function $(id){return document.getElementById(id)}

function user_input(){
	var name = $("id").value;
	var password = $("password").value;
	if(name=="" || password==""){
		alert("Please enter your username and password.");
		return false;
	}else{
		return true;
	}
}
