<?php 
require "conn.php";
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$user_main="admin";
$pass_main="admin";

if ($user_name ==$user_main &&$user_pass==$pass_main ) {
	echo "Main Login";
	}

else {
$mysql_qry = "select * from user where user like '$user_name' and pass like '$user_pass';";
$result = mysqli_query($conn ,$mysql_qry);
 if(mysqli_num_rows($result) > 0) {
echo "Login";
}
else {
echo "Login not success";
}}

?>