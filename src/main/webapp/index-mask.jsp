<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="eJobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" />      
    <h1>Welcome to eJobs ${userCurent.getNume()}
    </h1>
</t:pageTemplate>