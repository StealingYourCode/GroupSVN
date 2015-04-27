/**
 * 
 */

$(document).ready(function(){
	if (!$("#logoutBtn").is(":visible")){
		$(".red").mouseover(function(){
			$(".red").css("border-color", "red");
		});
		$(".red").mouseout(function(){
			$(".red").css("border-color", "#B8B8B8");
		});
		
		
		$(".red").click(function(){
			alert("You must be logged in to perform these functions");
			return false;
		});
	}
});



	