<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        /* Add this to your main stylesheet */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }

        .hero {
            background: linear-gradient(to right, #4a90e2, #50e3c2);
            color: white;
            text-align: center;
            padding: 50px 20px;
            border-radius: 8px;
            margin-bottom: 30px;
        }

        .btn-primary {
            background-color: #4a90e2;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            display: inline-block;
        }

        .btn-primary:hover {
            background-color: #357abd;
        }

        .features {
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
            flex-wrap: wrap;
        }

        .feature {
            background: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
            flex: 1;
            margin: 10px;
            min-width: 200px;
        }

        .feature h2 {
            color: #4a90e2;
        }
    </style>
</head>
<body>
    <%@include file="common/header.jsp" %>
    <%@include file="common/navigation.jsp" %>
    <div class="container">
        <header class="hero">
            <h1 id="greeting">Welcome, ${username}!</h1>
            <p>Your personalized dashboard awaits.</p>
            <a href="todo-list" class="btn btn-primary">Manage Your Todo List</a>
        </header>
        <section class="features">
            <div class="feature">
                <h2>Organize Tasks</h2>
                <p>Keep track of your tasks with ease and efficiency.</p>
            </div>
            <div class="feature">
                <h2>Track Progress</h2>
                <p>Visualize your productivity and stay motivated.</p>
            </div>
            <div class="feature">
                <h2>Set Reminders</h2>
                <p>Never miss a deadline with our intuitive reminder system.</p>
            </div>
        </section>
    </div>
    <%@include file="common/footer.jsp" %>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const greetingElement = document.getElementById('greeting');
            const now = new Date();
            const hour = now.getHours();
            
            let greetingMessage;

            if (hour < 12) {
                greetingMessage = 'Good Morning';
            } else if (hour < 18) {
                greetingMessage = 'Good Afternoon';
            } else {
                greetingMessage = 'Good Evening';
            }

            greetingElement.textContent = `${greetingMessage}, ${greetingElement.textContent.split(',')[1]}`;
        });
    </script>
</body>
</html>
