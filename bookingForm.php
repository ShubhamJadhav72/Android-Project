<?php 
require "conn.php";
$date =  $_POST["date"];
$time = $_POST["time"];
$vechicle_number =$_POST["vechicle"];
$contact_number = $_POST["contact"];
$type = $_POST["type"];

$sql_a = "SELECT * FROM booking_details WHERE date='$date' and vechicle_number='$vechicle_number'";
$res_a = mysqli_query($conn, $sql_a);

if (mysqli_num_rows($res_a) > 0) {
  	  echo "Sorry... this vechicle_number already book appointment "; 	
}
else{
$sql_u = "SELECT * FROM booking_details WHERE date='$date' and time='$time' and type='$type'";

$res_u = mysqli_query($conn, $sql_u);

	if (mysqli_num_rows($res_u) > 0) 
	{
  	  echo "Sorry... This Time Is already taken\n Please \n Select Other Time Otherwise Date Otherwise Type "; 	
  	}
  	else
  	{

  	    
  	    $mysql_qry = "INSERT INTO booking_details (date,time,vechicle_number,contact_number,type)VALUES('$date', '$time', '$vechicle_number', '$contact_number', '$type')";

			if (mysqli_query($conn, $mysql_qry)) 
			{
		   			 echo "Booking successfully";
			}
			 else
			{
		   		 echo "Booking Unsuccessfully";
			}

  	}
  }


?>
