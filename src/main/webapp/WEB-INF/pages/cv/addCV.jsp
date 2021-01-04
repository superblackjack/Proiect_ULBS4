<%-- 
    Document   : addCV
    Created on : Jan 4, 2021, 12:23:49 PM
    Author     : SuperBlackJack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add CV">
    <h1>Add CV</h1>
    <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/Jobs/AddCV">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="file">CV</label>
                <input type="file" name="file" required>
                <div class="invalid-feedback">
                    CV is required.
                </div>
            </div>
        </div>
        <input type="hidden" name="job_id" value="${job.id}"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Apply</button>
    </form>
</t:pageTemplate>