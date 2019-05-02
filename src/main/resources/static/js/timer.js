// JavaScript Document
window.onload = function(){
	var hours = document.getElementById("hours"),
		minute = document.getElementById("minute"),
		second = document.getElementById("second"),
		timer = null,
		Hours = 1,
		Minute = 0,
		Second = 5;
		timer = setInterval(function(){
				Second--;
				if(Hours==0 && Minute==0 && Second==0) clearInterval(timer);
				if(Second <0 ){
					Second = 59;
					Minute--;
					if(Minute < 0){
						Minute = 59;
						Hours--;
					}
				}
	
				
				if(Second < 10){
					second.innerText = "0" + Second;
				}else{
					second.innerText = Second;
				}
	
				
				if(Minute < 10){
					minute.innerText = "0" + Minute;
				}else{
					minute.innerText = Minute;
				}
	
				
				if(Hours < 10){
					hours.innerText = "0" + Hours;
				}else{
					hours.innerText = Hours;
				}
			},1000)
}