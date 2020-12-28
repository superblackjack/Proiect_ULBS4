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
                <li class="nav-item ${pageContext.request.requestURI eq '/Proiect_ULBS4/jobs.jsp' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jobs.jsp">Jobs <span class="sr-only">(current)</span></a>
                </li>

            </ul>

        </div>
    </nav>
</div>