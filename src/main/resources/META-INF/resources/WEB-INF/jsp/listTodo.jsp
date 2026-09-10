<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <hr>
    <h1> Your ToDos are: </h1>
    <table class="table">
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listToDo}" var="x">
                <tr>
                    <td>${x.description}</td>
                    <td>${x.targetDate}</td>
                    <td>${x.done}</td>
                    <td> <a href="delete-todo?id=${x.id}" class="btn btn-warning"> Delete </a> </td>
                    <td> <a href="update-todo?id=${x.id}" class="btn btn-success"> Update </a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success"> Add ToDo </a>
</div>
<%@ include file="common/footer.jsp" %>