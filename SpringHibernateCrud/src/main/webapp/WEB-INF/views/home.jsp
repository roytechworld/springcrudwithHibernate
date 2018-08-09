<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Crud</title>
	


         <script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>

<!-- 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
	 
	 
	 
	 
	<script type="text/javascript">
	$(document).ready(function()		
	{
		
		
		
		
// 		$('#paginatedTable').dataTable().fnSetFilteringEnterPress();
	
		
		$("#save").click(function()
	    {
			alert("called");
	   
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

<%=request.getContextPath() %>
	A crud example  
</h1>

<table class="table table-striped">

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

<div id="table_id" class="table-responsive">
		        <table id="paginatedTable" class="table table-striped">
		            <thead>
		                <tr>
		                    <th>Id</th>
		                    <th>Name</th>
		                    <th>Salary</th>
		                </tr>
		            </thead>
		            
		              <tbody>
     <c:forEach var="stdentlistValue" varStatus="loop" items="${stlist}">

<tr>
<td>
${loop.index+1}
</td>
<td>
${stdentlistValue.name }
</td>

<td>
${stdentlistValue.address }
</td>
</tr>


</c:forEach>
    
    <tr>
    <td colspan=2>
    
    
     <c:forEach var="pagination" varStatus="loops" items="${paginationlist}">
     <a href="<%=request.getContextPath() %>/viewemp/${loops.index+1}">${loops.index+1}</a>   
     </c:forEach>
  
    
    
    </td>
    <tr>
    </tbody>
		            
		            

		        </table>
		       </div>
</div>
	

</body>
</html>
