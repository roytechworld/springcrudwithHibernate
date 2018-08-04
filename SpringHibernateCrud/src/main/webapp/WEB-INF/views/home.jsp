<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Crud</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />

<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" th:src="@{js/admin.js}"></script>
<script type="text/javascript" 	th:src="@{../js/datatables.min.js}"></script>


<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />

<link th:href="@{../css/starter-template.css}" rel="stylesheet" media="screen" />
<link th:href="@{../css/datatables.min.css}" rel="stylesheet" media="screen" />

<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>






	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function()		
	{
		
		
		 $('#table_id').DataTable();
		
// 		$('#paginatedTable').dataTable().fnSetFilteringEnterPress();
	
		
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
