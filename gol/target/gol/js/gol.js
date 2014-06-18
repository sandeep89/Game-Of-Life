/**
 * Script file which will have all the methods requried to manupulate UI
 */

var states = [];
	 function setListener() {
		$('input[type="submit"]').click(function() {
			$(this).toggleClass('red');
		});
	}
	 
	function getPlayGroundStatus(){
		states = [];
		$('.red').each(function () {
			states.push(this.id);
	    });
	}
	
	function setPlayGroundStatus(){
		$('.red').each(function () {
			$(this).toggleClass('red');
	    });
		states.forEach(function(state){
			$("#" + state).toggleClass('red');
		});
	} 
	function playGame(){
		getPlayGroundStatus();
		
	var player = setInterval(function(){
			var data = "{\"states\" : \""+states.toString()+"\"}";
			console.log(data);
			$.ajax({
				  type: "POST",
				  url: "/gol/nextstate.action",
				  contentType: "application/json",
				  data: data,
				  success: function(data){
					  states = data.states;
					  states = states.split(",");
					  console.log(states.length);
					  if(states.length == 0){
						  clearInterval(player);
					  }
					  setPlayGroundStatus(); 
				  }
				});
			},2000);
	}