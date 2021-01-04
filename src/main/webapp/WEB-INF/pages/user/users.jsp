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
    <form method="POST" action="${pageContext.request.contextPath}/Users">
        <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Users/Create" role="button">Add User</a>
        </c:if>
        <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
            <button class="btn btn-danger btn-lg" type="submit"> Delete Users</button>
        </c:if>
        <c:forEach var="user" items="${users}" varStatus="status">
            <div class="row">
                <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                    <div class="col-md"> 
                        <input type="checkbox" name="user_ids" value="${user.id}" />
                    </div>
                </c:if>
                <div class="col-md-2 ">${user.nume}</div>
                <div class="col-md-2 ">${user.prenume}</div>
                <div class="col-md-2 ">${user.email}</div>
                <div class="col-md-2 ">${user.position}</div>
                <div class="col-md-2 ">
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Users/Update?id=${user.id}" role="button">Edit User</a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate>
