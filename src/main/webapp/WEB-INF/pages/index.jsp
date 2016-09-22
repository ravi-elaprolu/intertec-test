<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1 class="page-header">Intertec Usernames</h1>
<c:if test="${not empty errors}">
    <h3>Validation Errors:</h3>
    <c:forEach var="error" items="${errors}">
        <li>${error}</li>
    </c:forEach>
</c:if>
<form action="${pageContext.request.contextPath}/" method="post">
    <label for="name">Enter a Username:</label>
    <input type="text" id="name" name="name">
    <input type="submit">
</form>
<c:if test="${not empty result.names}">
    <h3>List of Candidates:</h3>
    <c:forEach var="candidate" items="${result.names}">
        <li>${candidate}</li>
    </c:forEach>
</c:if>
<br/>
<br/>
<br/>
<c:if test="${not empty usernames}">
    <h3>List of Usernames:</h3>
    <c:forEach var="username" items="${usernames}">
        <li>${username.name}</li>
    </c:forEach>
</c:if>
<c:if test="${empty usernames}">
    <h3>There are no usernames</h3>
</c:if>
</body>
</html>