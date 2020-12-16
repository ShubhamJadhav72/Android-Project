<?php 
require "conn.php";
$user_name =  $_POST["user_name"];
$name = $_POST["fullname"];
$user_pass =$_POST["password"];
$user_gmail = $_POST["gmail"];
$user_contact = $_POST["contant"];
//$mysql_qry = "INSERT INTO user (user,pass,gmail,contact,name) VALUES ('shubham','123456','gmail_name','12333','subham')";
$mysql_qry = "INSERT INTO user (user,pass,gmail,contact,name)VALUES('$user_name', '$user_pass', '$user_gmail', '$user_contact', '$name')";
if (mysqli_query($conn, $mysql_qry)) {
    echo "Account created successfully";
} else {
    echo "Account created Unsuccessfully";
}
?>
