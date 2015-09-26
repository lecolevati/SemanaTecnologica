<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Site Prof. M.Sc. Leandro Colevati dos Santos - FATEC ZL</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<jsp:include page="header.jsp" />

			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<jsp:include page="menu.jsp" />
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							<c:out value="Login" />
						</h1>
					</div>
				</div>
				<!-- /.row -->

				<!--  ./Tabela com Materiais -->

				<div class="col-lg-6">
					<div class="table-responsive">
						<div class="bodycontainer scrollable">
							<form action="login" method="post">
								<table class="table table-hover">
									<tbody>
										<tr>
											<td><input class="form-control" placeholder="Login"
												size="10" name="login"></td>
											<td><input type="password" class="form-control"
												name="senha" placeholder="Senha" size="10"></td>
											<td><input type="submit" class="btn btn-primary"
												name="enviar" title="Acessar" value="Acessar"></td>
										</tr>
									</tbody>
								</table>
							</form>
							<c:if test="${not empty mensagem }">
								<div class="alert alert-danger" align="center">
									<strong><c:out value="${mensagem }" /></strong>
								</div>
							</c:if>
							<c:if test="${not empty erro }">
								<div class="alert alert-danger" align="center">
									<strong><c:out value="${erro }" /></strong>
								</div>
							</c:if>
						</div>
					</div>
				</div>

				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="js/plugins/morris/raphael.min.js"></script>
	<script src="js/plugins/morris/morris.min.js"></script>
	<script src="js/plugins/morris/morris-data.js"></script>

</body>

</html>
