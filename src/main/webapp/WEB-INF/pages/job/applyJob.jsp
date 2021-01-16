<%-- 
    Document   : applyJob
    Created on : Jan 10, 2021, 2:17:13 PM
    Author     : SuperBlackJack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Jobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <div>
        <form method="POST" action="${pageContext.request.contextPath}/Applicant/Create">
            <div class="container text-center mt-lg-5  pt-lg-5">
                <h1 class="title-pages mb-lg-3"> ${jobApply.post} </h1>
                <h2 class="mb-lg-5"> ${jobApply.descriere} </h2>
                <input type="hidden" name="curentUserId" value="${userCurent.getId()}">
                <input type="hidden" name="curentJobId" value="${jobApply.id}">
                <button class="btn btn-primary btn-lg apply" type="submit">Apply</button>
            </div>
        </form>
    </div>
</t:pageTemplate>