<%-- 
    Document   : users
    Created on : Dec 28, 2020, 12:27:47 PM
    Author     : Elix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" />
    <form method="POST" action="${pageContext.request.contextPath}/Users"> 
        <div class="container mt-lg-5 pt-lg-5">
            <div class="row mb-lg-4">
                <div class="col-lg-8">
                    <h1 class="title-pages">Users</h1>
                </div>
                <div class="col-lg-4 text-right">
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Users/Create" role="button">Add User</a>
                    </c:if>
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <button class="btn btn-danger btn-lg ml-lg-4" type="submit"> Delete Users</button>
                    </c:if>
                </div>
            </div>
            <div class="row mb-lg-4">
                <div class="col-lg-1"></div>  
                <div class="col-lg-2 ">
                    <label class="text-pages text-size ml-lg-3" for="post">NUME</label>
                </div>
                <div class="col-lg-2 ">
                    <label class="text-pages text-size ml-lg-2" for="descriere">PRENUME</label>
                </div>
                <div class="col-lg-3">
                    <label class="text-pages text-size ml-lg-3" for="email">EMAIL</label>
                </div>
                <div class="col-lg-3">
                    <label class="text-pages text-size ml-lg-2" for="email">POSITION</label>
                </div>
            </div>              
            <c:forEach var="user" items="${users}" varStatus="status">
                <div class="row mb-lg-3">
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <div class="col-lg-1"> 
                            <input type="checkbox" name="user_ids" value="${user.id}" />
                        </div>
                    </c:if>
                    <div class="col-lg-2 ">
                        <div class="text-pages">
                            ${user.nume}
                        </div>
                    </div>
                    <div class="col-lg-2 ">
                        <div class="text-pages">
                            ${user.prenume}
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="text-pages">                         
                            ${user.email}  
                        </div>          
                    </div>
                    <div class="col-lg-2 text-pages">
                        <c:if test="${user.position == 'ADMINISTRATOR'}">
                            Administrator
                        </c:if>
                        <c:if test="${user.position == 'CLIENT'}">
                            Client
                        </c:if>
                        <c:if test="${user.position == 'RECRUTOR'}">
                            Recrutor
                        </c:if>
                        <c:if test="${user.position == 'DEPARTAMENTDIRECTOR'}">
                            Department Director
                        </c:if>
                        <c:if test="${user.position == 'HUMANRESOURCESDIRECTOR'}">
                            Human Resources Director
                        </c:if>
                        <c:if test="${user.position == 'GENERALDIRECTOR'}">
                            General Director
                        </c:if>
                    </div>
                    <div class="col-lg-2 text-right">
                        <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Users/Update?id=${user.id}" role="button">Edit User</a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
    </form>
</div>
</t:pageTemplate>
