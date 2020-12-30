<%-- 
    Document   : login
    Created on : 28.12.2020, 11:42:33
    Author     : Sebi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Login">
    <c:if test="${message != null}">
        <div class="alert alert-warning" role="alert">
            ${message}
        </div>
    </c:if>
    <form class="form-signin" method="POST" action="j_security_check">
        <!--<img class="mb-4" src="/docs/4.5/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">-->
        <h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
        <label for="email" class="sr-only">Email</label>
        <input type="text" id="email" name="j_email" class="form-control" placeholder="Email" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" required>
        <!--<div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>-->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <!--<p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>-->
    </form>
</t:pageTemplate>