<%-- 
    Document   : contactUs
    Created on : 07.01.2021, 15:44:41
    Author     : Sebi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Login">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" />
    <div class="container-fluid login">
        <div class="row">
            <div class="col-lg-12 pl-lg-0 pr-lg-0">
                <div class="login-img"  style="background-image:url('${pageContext.request.contextPath}/img/contactUs.jpg');">
                    <div class="text-pages ml-lg-1 mr-lg-1">
                        <a>hello</a>
                    </div>
                    <div class="text-pages ml-lg-5 mr-lg-5">
                        <a>world</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>