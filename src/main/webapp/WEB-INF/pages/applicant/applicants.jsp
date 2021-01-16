<%-- 
    Document   : applicants
    Created on : 09.01.2021, 20:10:52
    Author     : Sebi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:pageTemplate pageTitle="Applicants">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" />
    <form method="POST" action="${pageContext.request.contextPath}/Applicants"> 
        <div class="container-fluid tabel-aplicanti mt-lg-5 pt-lg-5">
            <div class="row mb-lg-4">
                <div class="col-lg-8">
                    <h1 class="title-pages">Applicants</h1>
                </div>
                <div class="col-lg-4 text-right">
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <button class="btn btn-success btn-lg ml-lg-4" type="submit" name="situation" value="1"> Accept Applicants</button>
                    </c:if>
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <button class="btn btn-danger btn-lg ml-lg-4" type="submit" name="situation" value="0"> Refuse Applicants</button>
                    </c:if>
                </div>
            </div>
            <div class="row mb-lg-4">
                <div class="col-lg-1"></div>  
                <div class="col-lg-2 ">
                    <label class="text-pages text-size ml-lg-3" for="post">NUME, PRENUME</label>
                </div>
                <div class="col-lg-2 ">
                    <label class="text-pages text-size ml-lg-2" for="descriere">EMAIL APLICANT</label>
                </div>
                <div class="col-lg-3">
                    <label class="text-pages text-size ml-lg-3" for="email">POST SI DESCRIERE</label>
                </div>
                <div class="col-lg-2">
                    <label class="text-pages text-size ml-lg-2" for="email">DATA APLICARII</label>
                </div>
                <div class="col-lg-2">
                    <label class="text-pages text-size ml-lg-2" for="email">CV APLICANT</label>
                </div>
            </div>              
            <c:forEach var="applicant" items="${applicants}" varStatus="status">
                <div class="row mb-lg-3">
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <div class="col-lg-1"> 
                            <input type="checkbox" name="applicant_ids" value="${applicant.id}" />
                        </div>
                    </c:if>
                    <div class="col-lg-2 ">
                        <div class="text-pages">
                            ${applicant.idUser.getNume()} ${applicant.idUser.getPrenume()}
                        </div>
                    </div>
                    <div class="col-lg-2 ">
                        <div class="text-pages">
                            ${applicant.idUser.getEmail()}
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="text-pages">                         
                            ${applicant.idJob.getPost()} - ${applicant.idJob.getDescriere()}  
                        </div>          
                    </div>
                    <div class="col-lg-2 ">
                        <div class="text-pages">
                            <fmt:formatDate value="${applicant.dataAplicarii}" pattern="dd-MM-yyyy"/>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="text-pages">                         
                            <a class="nav-link" href="${pageContext.request.contextPath}/viewCV?id=${applicant.idUser.id}" target="_blank">View CV</a>  
                        </div>          
                    </div>
                    <input type="hidden" name="UserIdOnClick" value="${applicant.idUser.getId()}">
                </div>
            </c:forEach>
    </form>
</div>
</t:pageTemplate>