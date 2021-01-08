<%-- 
    Document   : editUser
    Created on : 03.01.2021, 23:30:46
    Author     : Sebi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Edit User">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" />   
    <div class="row mt-lg-5  pt-lg-5">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <h1 class="title-pages">Edit User</h1>
            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Update">
                <input type="hidden" name="user" value="${pageContext.request.getRemoteUser()}"/>
                <div class="mb-lg-3">
                    <label class="text-color" for="nume">Name</label>
                    <input type="text" class="form-control mb-lg-3" name="nume" id="nume" placeholder="Name" required value="${user.nume}">
                    <div class="invalid-feedback">
                        Name is required.
                    </div>
                </div>
                <div class="mb-lg-3">
                    <label class="text-color" for="prenume">Surname</label>
                    <input type="text" class="form-control mb-lg-3" name="prenume" id="prenume" placeholder="Surname" required value="${user.prenume}">
                    <div class="invalid-feedback">
                        Surname is required.
                    </div>
                </div>
                <div class="mb-lg-3">
                    <label class="text-color" for="email">Email</label>
                    <input type="email" class="form-control mb-lg-3" name="email" id="email" placeholder="Email" required value="${user.email}">
                    <div class="invalid-feedback">
                        Email is required.
                    </div>
                </div>
                <div class="mb-lg-3">
                    <label class="text-color" for="password">Password</label>
                    <input type="password" class="form-control mb-lg-3" name="password" id="password" placeholder="Password" required value="${user.password}">
                    <div class="invalid-feedback">
                        Password is required.
                    </div>
                </div>
                <div class="mb-lg-3">
                    <label class="text-color" for="position">Position</label>
                    <select class="form-select d-block w-100 mb-lg-4" name="position" id="position" required value="${user.position}">
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
                <hr class="mb-4">
                <input type="hidden" name="user_id" value="${user.id}">
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