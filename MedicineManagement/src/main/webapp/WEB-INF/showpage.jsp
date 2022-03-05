<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.example.demo.services.*" %>
<%@page import="java.util.List" %>
<%@page import="com.example.demo.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>List of Medicines</h2>

<table class="table table-striped p-5">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Count</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
  <tbody>
  	<%
  		MedicineServices ms = new MedicineServiceImpl();
  		List<Medicine> md = ms.Select();
  		
  		for(Medicine m : md)
  		{ %>
  			<tr>
		      <th scope="row"><%=m.getId() %></th>
		      <td><%=m.getName() %></td>
		      <td><%=m.getCount() %></td>
		      <td><%=m.getDescription() %></td>
		    </tr>
  		<%}
  	%>
    
  </tbody>
</table>

</body>
</html>