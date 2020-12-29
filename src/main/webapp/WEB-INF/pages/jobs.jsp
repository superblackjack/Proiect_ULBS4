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
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/addJobs" role="button">Add Jobs</a>

        <c:forEach var="job" items="${jobs}" varStatus="status">
            <div class="row">
                <div class="col-md-3 ">
                    ${job.post}
                </div>
                <div class="col-md-3 ">
                    ${job.descriere}
                </div>
                <div class="col-md-2 ">
                    ${job.email}
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate>