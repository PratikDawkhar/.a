<?php
session_start();


if (!isset($_SESSION['visit_count'])) 
{
    $_SESSION['visit_count'] = 1; // Initialize visit count to 1 if not set
}
else 
{
    $_SESSION['visit_count']++; // Increment visit count if already set
}

// Display the visit count
echo "You have visited this page " . $_SESSION['visit_count'] . " times.";
?>