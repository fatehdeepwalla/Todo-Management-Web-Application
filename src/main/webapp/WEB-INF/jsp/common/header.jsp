<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title> Manage Todo </title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.css" rel="stylesheet" >
        <style>
            .nav-separator {
                position: relative;
                margin-right: 10px;
                padding-right: 10px;
            }

            .nav-separator::after {
                content: "";
                position: absolute;
                right: 0;
                top: 10px;
                height: 20px;
                border-right: 1px solid #6c757d;
            }
        </style>
	</head>
	<body>