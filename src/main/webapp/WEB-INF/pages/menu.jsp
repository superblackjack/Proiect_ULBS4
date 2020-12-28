<%-- 
    Document   : menu
    Created on : Dec 28, 2020, 10:41:10 AM
    Author     : SuperBlackJack
--%>
<div class="container-fixed-width">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}">eJobs</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ${activePage eq 'Users' ? ' active' : ''}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Users">Users</a>
                </li>
                <li class="nav-item ${activePage eq 'Jobs' ? ' active' : ''}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Jobs">Jobs</a>
                </li>
            </ul>
        </div>
    </nav>
</div>