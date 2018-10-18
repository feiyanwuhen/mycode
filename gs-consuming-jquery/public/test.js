$(document).ready(function() {
	$.ajax({
		url:"http://10.2.200.74:8080/testByCategoryId?categoryId=1"
	}).then(function(data){
		$.each(data, function (i,item) {
			$("#testList").append('<div id='+item.id+'>'+(i+1)+"、"+item.testTitle+'</div>');
	});
	});

	$("ul li").click(function(i) {
			 $.ajax({
				url:"http://10.2.200.74:8080/testByCategoryId?categoryId="+(parseInt($(this).index())+1)
		     }).then(function(data){
		     	$("#testList").children('div').remove();
			  $.each(data, function (j,item) {
				 $("#testList").append('<div id=question><a href="http://localhost:9000/questionList.html?id='+item.categoryId+'">'+(j+1)+'、'+item.testTitle+'</a></div><br/>');
		     });
			});
	     });

});

