<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="eJobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <c:if test="${pageContext.request.getRemoteUser() != null}">        
        <c:set var="emailUserCurent" value="${pageContext.request.getRemoteUser()}" scope="session"></c:set>>
        <jsp:include page="${pageContext.request.contextPath}/../SessionUser"/>
    </c:if>
</t:pageTemplate>