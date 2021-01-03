<%-- 
    Document   : editJob
    Created on : Dec 30, 2020, 1:32:10 PM
    Author     : Elix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Edit Job">
    <h1>Edit Job</h1>
    
    <div class="col-md-8 order-md-1">
        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Jobs/Update">

            <div class="mb-3">
                <label for="post">Post</label>
                <input type="text" class="form-control" name="post" id="post" placeholder="Post name" required value="${job.post}">
                <div class="invalid-feedback">
                    Post is required.
                </div>
            </div>

            <div class="mb-3">
                <label for="descriere">Description</label>
                <input type="text" class="form-control" name="descriere" id="descriere" placeholder="Post Description" required value="${job.descriere}">
                <div class="invalid-feedback">
                    Post Description is required.
                </div>
            </div>

            <div class="mb-3">
                <label for="user_id">Email</label>
                <select class="custom-select d-block w-100" name="user_id" id="user_id" required>
                    <!--<option value="">Choose...</option>-->
                    <c:forEach var="user" items="${users}" varStatus="status">
                        <option value="${user.id}" ${job.email eq user.email ? 'selected' : ''}>${user.email}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select email.
                </div>
            </div>

            <hr class="mb-4">
            <input type="hidden" name="job_id" value="${job.id}">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
        </form>
    </div>
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