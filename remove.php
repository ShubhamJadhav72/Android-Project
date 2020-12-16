
<?php 
require "conn.php";
$contact_number = $_POST["remove"];

///DELETE FROM `booking_details` WHERE 0
///$sql = 'DELETE FROM tutorials_tbl WHERE tutorial_id = 3';
//remove

$mysql_qry = "DELETE FROM booking_details WHERE contact_number = $contact_number";

if (mysqli_query($conn, $mysql_qry)) {
    echo "successfully";
} else {
    echo "Unsuccessfully";
}

?>
