<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="eJobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <c:if test="${pageContext.request.getRemoteUser() != null}">        
        <c:set var="emailUserCurent" value="${pageContext.request.getRemoteUser()}" scope="session"></c:set>>
        <jsp:include page="${pageContext.request.contextPath}/../SessionUser"/>
    </c:if>
    <div class="container-fluid index-img" style="background-image:url('${pageContext.request.contextPath}/img/index.jpg');">
        <div class="text-pages mt-lg-5 pt-lg-5">
            <h1>Welcome to eJobs
            </h1>
        </div>
    </div>
</t:pageTemplate>