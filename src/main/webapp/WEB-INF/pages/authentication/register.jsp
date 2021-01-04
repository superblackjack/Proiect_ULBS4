<%-- 
    Document   : register
    Created on : Jan 3, 2021, 8:05:51 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Register">
    <div class="container-fluid login">
        <div class="row">
            <div class="col-lg-5 pl-lg-0 pr-lg-0">
                <div class="login-box">
                    <div class="vm">
                        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Register">
                            <h1 class="h3 mb-lg-4 font-weight-normal login-title">Register</h1>
                            <div class="text-color">
                                <label  for="nume">Name</label>
                            </div>
                            <input type="text" class="form-control mb-lg-3" name="nume" id="nume" placeholder="Name" required>
                            <div class="invalid-feedback">
                                Name is required.
                            </div>
                            <div class="text-color">
                                <label for="prenume">Surname</label>
                            </div>
                            <input type="text" class="form-control mb-lg-3" name="prenume" id="prenume" placeholder="Surname" required>
                            <div class="invalid-feedback">
                                Surname is required.
                            </div>
                            <div class="text-color">
                                <label for="email">Email</label>
                            </div>
                            <input type="email" class="form-control mb-lg-3" name="email" id="email" placeholder="Email" required>
                            <div class="invalid-feedback">
                                Email is required.
                            </div>
                            <div class="text-color">
                                <label for="password">Password</label>
                            </div>
                            <input type="password" class="form-control mb-lg-3" name="password" id="password" placeholder="Password" value="" required>
                            <div class="invalid-feedback">
                                Password is required.
                            </div>
                            <div class="text-color">
                                <label for="position">Position</label>
                            </div>
                            <select class="custom-select d-block w-100 mb-lg-3" name="position" id="position" required>
                                <option value="CLIENT">Client</option>
                            </select>
                            <button class="btn btn-lg btn-primary btn-block mb-lg-4" type="submit">Register</button>
                            <h1 class="login-text">Do you already have an account? Sign up!</h1>
                            <a class="btn btn-secondary btn-lg btn-block mt-lg-4" href="${pageContext.request.contextPath}/Login" role="button">Login</a>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-7 pl-lg-0 pr-lg-0">
                <div class="login-img"  style="background-image:url('${pageContext.request.contextPath}/img/register.png');">
                </div>
            </div>
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
