<%-- 
    Document   : jobs
    Created on : 28.12.2020, 15:30:48
    Author     : Sebi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Jobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <form method="POST" action="${pageContext.request.contextPath}/Jobs">
        <div class="container mt-lg-5  pt-lg-5">
            <div class="row mb-lg-4">
                <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                    <div class="col-lg-8">
                        <h1 class="title-pages"> Lista cu joburi </h1>
                    </div>
                </c:if>
                <c:if test = "${pageContext.request.getRemoteUser() == null}">
                    <div class="col-lg-8">
                        <h1 class="title-pages"> Available Jobs </h1>
                    </div>
                </c:if>
                <div class="col-lg-4 text-right">
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Jobs/Create" role="button">Add Jobs</a>
                    </c:if>
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <button class="btn btn-danger btn-lg ml-lg-4" type="submit"> Delete Jobs</button>
                    </c:if>
                </div>
            </div>
            <div class="row mb-lg-4">
                <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                    <div class="col-lg-1"></div>  
                </c:if>
                <div class="col-lg-3 ">
                    <label class="text-pages text-size ml-lg-3" for="post">POST</label>
                </div>
                <div class="col-lg-3 ">
                    <label class="text-pages text-size ml-lg-5" for="descriere">DESCRIERE</label>
                </div>
                <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                    <div class="col-lg-3">
                        <label class="text-pages text-size ml-lg-5" for="email">EMAIL</label>
                    </div>
                </c:if>
            </div>
            <c:forEach var="job" items="${jobs}" varStatus="status">
                <div class="row mb-lg-3">
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <div class="col-lg-1"> 
                            <input type="checkbox" name="job_ids" value="${job.id}" />
                        </div>
                    </c:if>
                    <div class="col-lg-3 ">
                        <div class="text-pages">
                            ${job.post}
                        </div>
                    </div>
                    <div class="col-lg-3 ">
                        <div class="text-pages">
                            ${job.descriere}
                        </div>
                    </div>
                    <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                        <div class="col-lg-3 ">
                            <div class="text-pages">
                                ${job.email}
                            </div>
                        </div>
                    </c:if>
                    <div class="col-lg-2 text-right">
                        <c:if test="${not pageContext.request.isUserInRole('ClientRole')}">  
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Login" role="button">View Job</a>
                        </c:if>

                        <c:if test="${pageContext.request.isUserInRole('ClientRole')}">  
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Jobs/Apply?id=${job.id}" role="button">View Job</a>
                        </c:if>  

                        <c:if test="${pageContext.request.isUserInRole('AdminRole')}">  
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Jobs/Update?id=${job.id}" role="button">Edit Job</a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
    </form>
</div>
</t:pageTemplate>