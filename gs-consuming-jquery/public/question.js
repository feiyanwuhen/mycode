$(document).ready(function() {
	/*获取到Url里面的参数*/
	(function ($) {  
		$.getUrlParam = function (name) { 
		  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); 
		   var r = window.location.search.substr(1).match(reg);   
		   if (r != null) 
		   	return unescape(r[2]); 
		   return null;  
		} 
	})(jQuery);

	var id = $.getUrlParam('id');		
	$.ajax({
		url:"http://10.2.200.74:8080/questionByTestNo?testNum="+id
	}).then(function(data){
		$.each(data, function (i,item) {
			$("#questionList").append('<div>'+(i+1)+"、"+item.question+'</div><br/>');
		       $("#questionList").append('<label class="single"><input type="radio" name="choice'+i+ '" value="A" />'+item.choiceA+'</label><br/>');
	                $("#questionList").append('<label class="single"><input type="radio" name="choice'+i+ '" value="B" />'+item.choiceB+'</label><br/>');
	                $("#questionList").append('<label class="single"><input type="radio" name="choice'+i+ '" value="C" />'+item.choiceC+'</label><hr/>');
	});
	});



	$("#questionSubmit").click(function(){
		var answers = new Array();
	    $('input:radio:checked').each(function(i){
	         var checkValue = $(this).val();
	         answers[i]=$(this).val();
	             console.log($(this).val());　　// 选中框中的值
	      });
	     
	    $.ajax({
	    	url:'http://localhost:8080/submitTest',
	    	type:"POST",
	    	data: {
	    		"testNum":1,
	    		"answers":answers
	    	},
	    	traditional:true,
	    	success:function(data){
	    		alert(data);
	    	}

	    });
	});

});