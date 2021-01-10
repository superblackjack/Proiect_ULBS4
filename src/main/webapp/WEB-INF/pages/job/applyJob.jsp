<%-- 
    Document   : applyJob
    Created on : Jan 10, 2021, 2:17:13 PM
    Author     : SuperBlackJack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Jobs">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <form method="POST" action="${pageContext.request.contextPath}/Jobs">
        <div class="container mt-lg-5  pt-lg-5">
            <div class="row mb-lg-4">
                    <div class="col-lg-8">
                        <h1 class="title-pages"> ${jobApply.post} </h1>
                    </div>
            </div>
            <div class="row mb-lg-4">
                <div class="col-lg-8">
                        <h2 class="description"> ${jobApply.descriere} </h2>
                    </div>
                    
            </div>
            
          </div>
           
    </form>
</div>
</t:pageTemplate>