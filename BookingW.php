<?php 
require "conn.php";
//$user=$_POST["user_name"];
$date = $_POST["date"];
$vehical_number =$_POST["vehical_number"];
$service_name =$_POST["service_name"];


//$mysql_qry = "INSERT INTO user (user,pass,gmail,contact,name) VALUES ('shubham','123456','gmail_name','12333','subham')";
//$mysql_qry = "INSERT INTO booking_details (user , date, vehical_number, service_name) VALUES ('$user','$date','$vehical_number','$service_name')";
$mysql_qry = "INSERT INTO booking_details (date, vehical_number, service_name) VALUES ('$date','$vehical_number','$service_name')";
if (mysqli_query($conn, $mysql_qry)) {
    echo "successfully";
} else {
    echo "Unsuccessfully";
}
//INSERT INTO `booking_details`(`user`, `date`, `vehical_number`, `service_name`) VALUES ([value-1],[value-2],[value-3],[value-4])
//INSERT INTO `booking_details`(`date`, `vehical_number`, `service_name`) VALUES ([value-1],[value-2],[value-3])
?>
