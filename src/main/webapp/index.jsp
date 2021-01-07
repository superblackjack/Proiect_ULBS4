<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="eJobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <h1>Welcome to eJobs
        <c:when test = "${pageContext.request.getRemoteUser() == null}">
            <a>${pageContext.request.getRemoteUser()}</a>
        </c:when>
    </h1>
    <div class="container-fluid login">
        <div class="row">
            <div class="col-lg-12 pl-lg-0 pr-lg-0">
                <div class="login-img"  style="background-image:url('${pageContext.request.contextPath}/img/index.jpg');">
                </div>
            </div>
        </div>
    </div>

</t:pageTemplate>