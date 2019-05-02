// JavaScript Document


function getCreditScore()
{
	var score=95;
	return score;
}

function figurePrice(){
	var price=0;
	price = document.getElementById("hour").value*0.16;
	document.getElementById("price").innerHTML=price.toFixed(2);
}
function jumpto(){
			var index=document.getElementById("hour").value;
			var url = "home?index="+index;
			window.location.href=url;
}