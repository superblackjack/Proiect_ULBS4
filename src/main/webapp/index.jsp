<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="eJobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <h1>Welcome to eJobs
        <c:when test = "${pageContext.request.getRemoteUser() == null}">
            <a>${pageContext.request.getRemoteUser()}</a>
        </c:when>
    </h1>
</t:pageTemplate>