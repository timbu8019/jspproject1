<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Underwriter Registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"> 
    <style>
    body {
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    header {
        background-color: #512da8;
        color: white;
        padding: 10px 0;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    nav ul li {
        display: inline;
        margin-right: 20px; 
    }

    nav ul li a {
        color: white;
        text-decoration: none;
    }
  #sub2
  {
  padding-left:10px;
  }

    .QVY-logo {
        width: 100px;
        height: auto;
         margin-right: auto;
    }

    .image-container {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 200px;
    }

    .image-container img {
        max-width: 80%;
        max-height: 80%;
    }

    .login-container {
       background-color: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 80%;
    margin: 20px auto;
    box-sizing: border-box;
    padding-bottom: 60px;
    }

    h1 {
        text-align: center;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
    }

    label {
        font-weight: bold;
    }

    input[type="text"],
    input[type="date"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 5px;
    }

    button:hover {
        background-color: #45a049;
    }

    #imp {
        color: red;
    }

    #reg {
        padding-top: 10px;
    }
    footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            width: 100%;
            position: fixed;
            bottom: 0;
             left: 0;
        }
    </style>
   <script>

   function generateRandomId() 
   {
       return Math.floor(1000000 + Math.random() * 9000000); 
   }
   function generateRandomPassword() 
   {
       const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=';
       let password = '';
       for (let i = 0; i < 8; i++) 
       { 
           password += characters.charAt(Math.floor(Math.random() * characters.length));
       }
       return password;
   }
   document.addEventListener('DOMContentLoaded', function() {
       document.getElementById('auto').textContent = generateRandomId();
       document.getElementsByClassName('pass')[0].textContent = generateRandomPassword();
       document.getElementById('registration-form').addEventListener('submit', function(event) {
       event.preventDefault(); 
       
   });
});
       
function Reg()
{
    alert('Underwriter registered successfully!');
}
</script>


</head>
<body>
<header>
    <nav id="main">
        <ul id="sub">
            <li id="sub1"><a id="sub2" href="./AdminHomePage.jsp"><i class="fas fa-arrow-left"></i></a></li>
        </ul>
    </nav>
    <img src="./image/Logo.png" alt="QVY Insurance" class="QVY-logo">
    <nav>
        <ul>
            <li><a href="#"><i class="fas fa-edit"></i> Update</a></li>
            <li><a href="#"><i class="fas fa-trash-alt"></i> Delete</a></li>
            <li><a href="#"><i class="fas fa-eye"></i> View Underwriter</a></li>
            <li><a href="./AdminLogin.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
        </ul>
    </nav>
</header>
<div class="login-container">
    <h1>QVY Insurance Online</h1>
    <hr/>
    <h1>Underwriter Registration</h1>
    <form id="registration-form" method="post" action="RegisterServelet">
        <div>
            <label id="uid" for="underwriter-id" >ID:<span readonly id="auto">
            <input type="hidden" id="underwriter-id1" name="underwriterid" value="<%= request.getAttribute("underwriterid") %>"> 

            </span></label>
        </div>
        <div>
            <label  for="name">Name<span id="imp">*</span></label>
            <input type="text" placeholder="Enter Your Name" id="name" maxlength="50" required>
        </div>
        <div>
            <label for="dob">Date of Birth<span id="imp">*</span>:</label>
            <input type="date"  id="dob" required/>
        </div>
        <div>
            <label for="joining-date">Joining Date<span id="imp">*</span>:</label>
            <input type="date"  id="joining-date" required/>
        </div>
        <div>
            <label for="password">Default Password:<span readonly id="auto" class="pass">
            <input type="hidden" id="password" name="password" value="<%= request.getAttribute("password") %>">
            </span></label>
        </div>
        <div id="reg">
            <button type="submit" onclick="Reg()" >Register</button>
        </div>
    </form>
    <footer>
        &copy; 2024 QVY Insurance Online. All rights reserved.
    </footer>
</div>
</body>
</html>
