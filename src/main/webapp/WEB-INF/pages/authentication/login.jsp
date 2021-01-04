<%-- 
    Document   : login
    Created on : 28.12.2020, 11:42:33
    Author     : Sebi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Login">
    <div class="container-fluid login">
        <div class="row">
            <div class="col-lg-5 pl-lg-0 pr-lg-0">
                <div class="login-box">
                    <div class="vm">
                        <c:if test="${message != null}">
                            <div class="alert alert-warning" role="alert">
                                ${message}
                            </div>
                        </c:if>
                        <form class="form-signin" method="POST" action="j_security_check">
                            <!--<img class="mb-4" src="/docs/4.5/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">-->
                            <h1 class="h3 mb-lg-4 font-weight-normal login-title">Sign in</h1>
                            <input type="text" id="email" name="j_username" class="form-control mb-lg-3" placeholder="Email" required autofocus>
                            <input type="password" id="password" name="j_password" class="form-control mb-lg-3" placeholder="Password" required>
                            <button class="btn btn-lg btn-primary btn-block mb-lg-4" type="submit">Sign in</button>
                            <div class="login-text">
                                <a>Don't you have an account?</a>
                                <a href="${pageContext.request.contextPath}/Register">Sign up!</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-7 pl-lg-0 pr-lg-0">
                <div class="login-img"  style="background-image:url('${pageContext.request.contextPath}/img/login.jpg');">

                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>