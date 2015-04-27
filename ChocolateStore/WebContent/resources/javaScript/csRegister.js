/**
 * 
 */

$(document).ready(function(){
	$("#submitBtn").click(function(){
		var pwd = $("#pwd").val();
		var conf = $("#confPwd").val();
		if(pwd != conf){
			alert("Your passwords do not match");
			return false;
		}
	});
});