<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Crud</title>
	
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function()		
	{
		
		$("#save").click(function()
	    {
	   
	    var value="";
			$.ajax({
			url:"save?name="+$("#studentname").val()+"&address="+$("#address").val(),
			type: "post",
			data: value,
			cache:false,
			success:function(data)
			{
				
				$("#s").html(data);
			}
					
			})
			
	    });

	});
	</script>
	
</head>


<body>
<h1>
	A crud example  
</h1>

<table>

<tr>
<td>Student Name </td>
<td><input id="studentname" type="text" value="" />
</tr>

<tr>
<td>Address</td>
<td><input type="text" id="address" value="" />
</td>
</tr>

<tr>
<td>
<button id="save">Save it</button>
</td>
</tr>


</table>

<div id="s">


</div>


</body>
</html>
