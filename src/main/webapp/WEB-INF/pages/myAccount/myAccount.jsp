<%-- 
    Document   : myAccount
    Created on : 12.01.2021, 08:24:05
    Author     : Sebi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "My Account">
    <jsp:include page="/WEB-INF/pages/menu/menu.jsp" /> 
    <div class="row mt-lg-5  pt-lg-5">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <h1 class="title-pages">${userCurent.getNume()} ${userCurent.getPrenume()}</h1>
            <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadCV">
                <div class="mb-lg-3">
                    <label class="text-color" for="file">Upload your CV</label>
                    <input type="file" name="file" required>
                    <div class="invalid-feedback">
                        CV is required.
                    </div>
                </div>
                <hr class="mb-4">
                <input type="hidden" name="curentUserId" value="${userCurent.getId()}">
                <input type="hidden" name="curentJobId" value="${jobApply.id}">
                <button class="btn btn-primary btn-lg btn-block mt-lg-4" type="submit">Upload</button>
            </form>
        </div>
        <div class="col-lg-4"></div>
    </div>   
    <script class="jsbin" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
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
