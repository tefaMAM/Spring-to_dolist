<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Todo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom styles for form */
        .container {
            margin-top: 30px;
        }
        
        .form-control {
            border-radius: 4px;
        }
        
        .form-group {
            margin-bottom: 1rem;
        }
        
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        
        .btn-success:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
        
        .text-warning {
            color: #ffcc00;
        }
        
        .alert {
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <%@ include file="common/header.jsp" %>
    <%@ include file="common/navigation.jsp" %>

    <div class="container">
        <h1 class="text-center mb-4">Enter Todo Details</h1>

        <!-- Form for entering todo details -->
        <form:form method="post" modelAttribute="todo">
            <div class="form-group">
                <form:label path="describtion" cssClass="form-label">Description</form:label>
                <form:input type="text" path="describtion" required="required" class="form-control"/>
                <form:errors path="describtion" cssClass="text-warning"/>
            </div>

            <div class="form-group">
                <form:label path="targetDate" cssClass="form-label">Target Date</form:label>
                <form:input type="date" path="targetDate" required="required" class="form-control" id="targetDate"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </div>

            <!-- Hidden fields to manage id and done status -->
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>

            <!-- Submit button -->
            <div class="form-group text-center">
                <button type="submit" class="btn btn-success">Submit</button>
                <a href="todolist" class="btn btn-secondary ml-2">Back to Todo List</a>
            </div>
        </form:form>
    </div>

    <%@ include file="common/footer.jsp" %>

    <!-- JavaScript dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    
    <!-- JavaScript to enhance the date picker functionality -->
    <script type="text/javascript">
        $(document).ready(function() {
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true,
                todayHighlight: true
            });
        });
    </script>
</body>
</html>
