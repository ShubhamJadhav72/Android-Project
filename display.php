<?php 
require "conn.php";


$response=array();
$sql_query="SELECT * FROM booking_details";
$query =mysqli_query($conn, $sql_query);

if (mysqli_num_rows($query)>0) {
	# code...
//	$response['success']=1;
//	$booking_details=array();
	while ($row =mysqli_fetch_assoc($query))
	{
		array_push($response, $row);
	}
//	$response['booking_details']=$booking_details;

}
echo json_encode($response);

mysqli_close($conn);
?>

