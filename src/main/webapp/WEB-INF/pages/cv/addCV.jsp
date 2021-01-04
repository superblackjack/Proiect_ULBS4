<%-- 
    Document   : addCV
    Created on : Jan 4, 2021, 12:23:49 PM
    Author     : SuperBlackJack
--%>

<t:pageTemplate pageTitle="Add CV">
    <h1>Add CV></h1>
    <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/Users/AddCV">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="file">CV</label>
                <input type="file" name="file" required>
                <div class="invalid-feedback">
                    CV is required.
                </div>
            </div>
        </div>
        <input type="hidden" name="user_id" value="${user.id}"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit"> Apply</button>
    </form>
</t:pageTemplate>