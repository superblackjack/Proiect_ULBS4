<%-- 
    Document   : editUser
    Created on : 03.01.2021, 23:30:46
    Author     : Sebi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Edit User">
    <h1>Edit User</h1>
    <div class="col-md-8 order-md-1">
        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Update">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="nume">Name</label>
                    <input type="text" class="form-control" name="nume" id="nume" placeholder="Name" required value="${user.nume}">
                    <div class="invalid-feedback">
                        Name is required.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="prenume">Surname</label>
                    <input type="text" class="form-control" name="prenume" id="prenume" placeholder="Surname" required value="${user.prenume}">
                    <div class="invalid-feedback">
                        Surname is required.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="Email" required value="${user.email}">
                    <div class="invalid-feedback">
                        Email is required.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password" required value="${user.password}">
                    <div class="invalid-feedback">
                        Password is required.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="position">Position</label>
                    <select class="custom-select d-block w-100" name="position" id="position" required value="${user.position}">
                        <!--<option value=""></option>-->
                        <c:if test="${user.position == 'ADMINISTRATOR'}">
                            <option value="ADMINISTRATOR">Administrator</option>
                            <option value="CLIENT">Client</option>
                        </c:if>
                        <c:if test="${user.position == 'CLIENT'}">
                            <option value="CLIENT">Client</option>
                            <option value="ADMINISTRATOR">Administrator</option>
                        </c:if>
                    </select>
                    <div class="invalid-feedback">
                        Please select a position.
                    </div>
                </div>
            </div>
            <hr class="mb-4">
            <input type="hidden" name="user_id" value="${user.id}">
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