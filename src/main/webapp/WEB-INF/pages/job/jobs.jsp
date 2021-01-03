<%-- 
    Document   : jobs
    Created on : 28.12.2020, 15:30:48
    Author     : Sebi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Jobs">
    <h1> Lista cu joburi </h1>
    <form method="POST" action="${pageContext.request.contextPath}/Jobs">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Jobs/Create" role="button">Add Jobs</a>
        <button class="btn btn-danger btn-lg" type="submit"> Delete Jobs</button>
        <c:forEach var="job" items="${jobs}" varStatus="status">
            <div class="row">
                <div class="col-md">
                    <input type="checkbox" name="job_ids" value="${job.id}" />
                </div>
                <div class="col-md-3 ">
                    ${job.post}
                </div>
                <div class="col-md-3 ">
                    ${job.descriere}
                </div>
                <div class="col-md-2 ">
                    ${job.email}
                </div>
                <div class="col-md-2 ">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Jobs/Update?id=${job.id}" role="button">Edit Job</a>
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate>