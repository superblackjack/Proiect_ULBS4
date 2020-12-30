<%-- 
    Document   : users
    Created on : Dec 28, 2020, 12:27:47 PM
    Author     : Elix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>
    <c:forEach var="user" items="${users}" varStatus="status">
        <div class="row">
            <div class="col-md-4 ">${user.nume}</div>
            <div class="col-md-4 ">${user.prenume}</div>
            <div class="col-md-3 ">${user.email}</div>
        </div>
    </c:forEach>
</t:pageTemplate>

