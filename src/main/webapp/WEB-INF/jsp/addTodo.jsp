<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <hr>
    <h1> Enter to do details </h1>
    <form:form method="post" modelAttribute="todo"  autocomplete="off">

        <fieldset class="mb-3">
            <form:label path="description"> Description </form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors  path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate"> Target Date </form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors  path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="id" />

        <fieldset class="mb-3">
            <form:label path="done">Done</form:label>
            <form:select path="done">
                <form:option value="false">False</form:option>
                <form:option value="true">True</form:option>
            </form:select>
            <form:errors path="done" cssClass="text-warning"/>
        </fieldset>

        <input type="submit" class="btn btn-success"/>
    </form:form>
</div>

<%@ include file="common/footer.jsp" %>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
