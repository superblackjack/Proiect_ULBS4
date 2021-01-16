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
                                    <a href="https://www.google.com/maps/place/Facultatea+de+Inginerie/@45.7898412,24.1462968,15z/data=!4m5!3m4!1s0x0:0xc168eca1cc733c84!8m2!3d45.7898412!4d24.1462968" target="_blank"> <img class="mb-lg-5" src="${pageContext.request.contextPath}/img/locatie.JPG" /></a>
                                    <h4 class="mb-lg-4">Sibiu, Judetul Sibiu</h4>
                                    <p> Strada Emil Cioran 4,<br>
                                        Municipiul Sibiu, Judetul Sibiu,<br>
                                        Cod Postal 550025<br><br>
                                    </p>
                                    <p> +(40) 0269217928 <br>
                                        inginerie@ulbsibiu.ro
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>