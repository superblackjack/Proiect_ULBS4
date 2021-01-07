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
    <div class="container-fluid login dark-bg">
        <div class="row">
            <div class="col-lg-12 pl-lg-0 pr-lg-0">
                <div class="container-fluid login-img contact-us-img"  style="background-image:url('${pageContext.request.contextPath}/img/contactUs.jpg');">
                        <div class="row">
                            <div class="col-lg-8 text-pages">
                                <a>hello</a>
                            </div>
                            <div class="col-lg-4">
                                <div class="index-right-content text-pages">
                                    <div class="vm">
                                        <img class="mb-lg-5" src="${pageContext.request.contextPath}/img/locatie.JPG" />
                                        <h4 class="mb-lg-4">Sibiu</h4>
                                        <p>Text</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>