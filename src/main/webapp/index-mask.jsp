<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="eJobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" />
    <div class="container-fluid index-img" style="background-image:url('${pageContext.request.contextPath}/img/index.jpg');">
        <div class="text-pages mt-lg-5 pt-lg-5">
            <h1>Welcome to eJobs ${userCurent.getNume()}
            </h1>
        </div>
    </div>
</t:pageTemplate>