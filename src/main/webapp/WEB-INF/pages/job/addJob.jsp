<%-- 
    Document   : addJobs
    Created on : Dec 29, 2020, 1:11:10 PM
    Author     : SuperBlackJack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Add Job">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <div class="row mt-lg-5  pt-lg-5">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <h1 class="title-pages">Add Job</h1>
            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Jobs/Create">
                <div class="mb-lg-3">
                    <label class="text-color" for="post">Post</label>
                    <input type="text" class="form-control mb-lg-3" name="post" id="post" placeholder="Post name" required>
                    <div class="invalid-feedback">
                        Post is required.
                    </div>
                </div>
                <div class="mb-lg-3">
                    <label class="text-color" for="descriere">Description</label>
                    <input type="text" class="form-control mb-lg-3" name="descriere" id="descriere" placeholder="Post description" required>
                    <div class="invalid-feedback">
                        Post description required.
                    </div>
                </div>
                <div class="mb-lg-3">
                    <label class="text-color" for="user_id">Email</label>
                    <select class="form-select d-block w-100 mb-lg-4" name="user_id" id="user_id" required>
                        <option value="">Choose...</option>
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <option value="${user.id}">${user.email}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please select email.
                    </div>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block mt-lg-4" type="submit">Save</button>
            </form>
        </div>
        <div class="col-lg-4"></div>
    </div>    
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';

            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');

                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</t:pageTemplate>