<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Index User Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h3>
    Add a User
</h3>
 
<c:url var="addAction" value="/create" ></c:url>
    
<form:form action="${homeController.addUser(user)}" commandName="user">
<table>
    <c:if test="${!empty user.name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td>
    </tr>
    </c:if>
    
    <tr>
        <td colspan="2">
            <c:if test="${!empty user.firstname}">
                <input type="submit"
                    value="<spring:message text="Edit User"/>" />
            </c:if>
            <c:if test="${empty user.name}">
                <input type="submit"
                    value="<spring:message text="Add User"/>" />
            </c:if>
        </td>
    </tr>
</table> 
</form:form>
<br>
<h3>List Users</h3>
<c:if test="${!empty homeController.users}">
    <table class="tg">
    <tr>
        <th width="80">User DNI</th>
        <th width="120">First Name</th>
        <th width="120">Last Name</th>
        <th width="120">Birth Date</th>
        <th width="120">Email</th>
        <th width="120">Phone</th>
        
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${homeController.users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.dni}</td>
            <td>${user.first_name}</td>
            <td>${user.last_name}</td>
            <td>${user.birthdate}</td>
            <td>${user.email}</td>


            <td><a href="<c:url value='/update/${user.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/delete/${user.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>