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
        <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/Applicant/Create">
            <div class="container mt-lg-5  pt-lg-5">
                <div class="row mb-lg-4">
                    <div class="col-lg-8">
                        <h1 class="title-pages"> ${jobApply.post} </h1>
                    </div>
                </div>
                <div class="row mb-lg-4">
                    <div class="col-lg-8">
                        <h2> ${jobApply.descriere} </h2>
                    </div>
                </div>

                <div class="mb-lg-3">
                    <label class="text-color" for="file">Upload your CV</label>
                    <input type="file" name="file" required>
                    <div class="invalid-feedback">
                        CV is required.
                    </div>
                </div>
                <hr class="mb-4">
                <input type="hidden" name="user_id" value="${userCurent.getId()}">



                <input type="hidden" name="curentUserId" value="${userCurent.getId()}">
                <input type="hidden" name="curentJobId" value="${jobApply.id}">
                <button class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/Jobs/Update?id=${jobApply.id}" type="submit">Apply</button>
            </div>
        </form>
    </div>
</t:pageTemplate>