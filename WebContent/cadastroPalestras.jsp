<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<c:if test="${not empty sessionScope.login }">
	<c:if
		test="${(sessionScope.login.perfil.codigo == '3581') || (sessionScope.login.perfil.codigo == '3582') }">
		<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Seminário Tecnológico - Fatec ZL</title>

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
				<nav class="navbar navbar-inverse navbar-fixed-top"
					role="navigation">
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
								<h1 class="page-header">EVENTOS</h1>
							</div>
						</div>
						<!-- /.row -->
						<c:if test="${not empty erro }">
							<div class="alert alert-danger" align="center">
								<strong><c:out value="${erro }" /></strong>
							</div>
						</c:if>
						<c:if test="${empty palestra }">
							<form action="cadastropalestra" method="post">
								<div class="col-lg-4">
									<div class="table-responsive">
										<table class="table table-hover">
											<tbody>
												<tr>
													<td>Código</td>
													<td><input class="form-control" placeholder="Código"
														readonly="readonly" size="10" name="codigo"></td>
												</tr>
												<tr>
													<td>Título do Evento</td>
													<td><input class="form-control" placeholder="Título"
														size="40" name="titulo"></td>
												</tr>
												<tr>
													<td>Titulação do Palestrante</td>
													<td><select class="form-control" name="titulacao">
															<option value="Sr.">Sr.</option>
															<option value="Sra.">Sra.</option>
															<option value="Esp.">Esp.</option>
															<option value="Me.">Me.</option>
															<option value="Ma.">Ma.</option>
															<option value="Dr.">Dr.</option>
															<option value="Dra.">Dra.</option>
													</select>
												</tr>
												<tr>
													<tr>
													<td>Nome do Palestrante</td>
													<td><input class="form-control" placeholder="Nome"
														size="40" name="nome"></td>
												</tr>
												<tr><tr>
													<td>Empr
												esa do Palestrante</td>
													<td><input class="form-control" placeholder="Empresa"
														size="40" name="empresa"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Duração do Evento (Horas)</td>
													<td><input class="form-control" placeholder="Duração"
														value="2" size="10" name="duracao"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Dia</td>
													<td><select class="form-control" name="dia">
															<c:forEach items="${listadatas }" var="data">
																<option value="${data.dtEvento }"><c:out
																		value="${data.dtConvertida }" /></option>
															</c:forEach>
													</select></td>
												</tr>
												<tr>
												
												<tr>
													<td>Hora</td>
													<td><input class="form-control"
														placeholder="Hora (HH:mm)" size="40" name="hora"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Tipo do Evento</td>
													<td><select class="form-control" name="tipo">
															<c:forEach items="${listatipo }" var="tipo">
																<option value="${tipo.codigo }"><c:out
																		value="${tipo.tipo }" /></option>
															</c:forEach>
													</select>
												
												</tr>
												<tr>
												
												<tr>
													<td>Curso Responsável</td>
													<td><input class="form-control" placeholder="Curso"
														readonly="readonly" size="40" name="curso"
														value='<c:out value="${curso.nome }" />'> <input
														type="hidden" name="codigocurso" value="${curso.codigo }">
													</td>
												</tr>
												<tr>
												
												<tr>
													<td>Evento</td>
													<td><input class="form-control" placeholder="Evento"
														readonly="readonly" size="40" name="evento"
														value='<c:out value="${evento.nome }" />'> <input
														type="hidden" name="codigoevento"
														value="${evento.codigo }"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Sala</td>
													<td><select class="form-control" name="sala">
															<c:forEach items="${listasala }" var="sala">
																<option value="${sala.numero }">
																	<c:if test="${sala.numero == 0}">
																		<c:out value="Auditório" />
																	</c:if>
																	<c:if test="${sala.numero != 0}">
																		<c:out value="${sala.numero }" />
																	</c:if>
																</option>
													</c:forEach>
													</select>
													</td>
												</tr>
												
																<tr>
													<td align="center" colspan="2"><input
																		class="btn btn-default" type="submit" name="enviar"
																		value="Enviar"></td>
												</tr>
											
											</tbody>
										</table>
									</div>
								</div>
							</form>
						</c:if>
						<c:if test="${not empty palestra }">
							<form action="cadastropalestras" method="post">
								<div class="col-lg-6">
									<div class="table-responsive">
										<table class="table table-hover">
											<tbody>
												<tr>
													<td>Código</td>
													<td><input class="form-control" placeholder="Código"
														readonly="readonly" size="10" name="codigo"
														value="${palestra.codigo }"></td>
												</tr>
												<tr>
													<td>Título do Evento</td>
													<td><input class="form-control" placeholder="Título"
														size="40" name="titulo" value="${palestra.titulo }"></td>
												</tr>
												<tr>
													<td>Titulação do Palestrante</td>
													<td><select class="form-control" name="titulacao">
															<option value="Sr."
																<c:if test="${palestra.titulacao == 'Sr.' }"><c:out value="selected" /></c:if>>Sr.</option>
															<option value="Sra."
																<c:if test="${palestra.titulacao == 'Sr.' }"><c:out value="selected" /></c:if>>Sra.</option>
															<option value="Esp."
																<c:if test="${palestra.titulacao == 'Sr.' }"><c:out value="selected" /></c:if>>Esp.</option>
															<option value="Me."
																<c:if test="${palestra.titulacao == 'Sr.' }"><c:out value="selected" /></c:if>>Me.</option>
															<option value="Ma."
																<c:if test="${palestra.titulacao == 'Sr.' }"><c:out value="selected" /></c:if>>Ma.</option>
															<option value="Dr."
																<c:if test="${palestra.titulacao == 'Sr.' }"><c:out value="selected" /></c:if>>Dr.</option>
															<option value="Dra."
																<c:if test="${palestra.titulacao == 'Sr.' }"><c:out value="selected" /></c:if>>Dra.</option>
													</select>
												
												</tr>
												<tr>
												
												<tr>
													<td>Nome do Palestrante</td>
													<td><input class="form-control" placeholder="Nome"
														size="40" name="nome" value="${palestra.palestrante }"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Empresa do Palestrante</td>
													<td><input class="form-control" placeholder="Empresa"
														size="40" name="empresa" value="${palestra.empresa }"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Duração do Evento (Horas)</td>
													<td><input class="form-control" placeholder="Duração"
														value="2" size="10" name="duracao"
														value="${palestra.duracao }"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Dia</td>
													<td><select class="form-control" name="dia">
															<c:forEach items="${listadatas }" var="data">
																<option value="${data.dtEvento }"
																	<c:if test="${palestra.dt } == ${data.dtEvento } }"><c:out value="selected" /></c:if>><c:out
																		value="${data.dtConvertida }" /></option>
															</c:forEach>
													</select></td>
												</tr>
												<tr>
												
												<tr>
													<td>Hora</td>
													<td><input class="form-control"
														placeholder="Hora (HH:mm)" size="40" name="hora"
														value="${palestra.hr }"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Tipo do Evento</td>
													<td><select class="form-control" name="tipo">
															<c:forEach items="${listatipo }" var="tipo">
																<option value="${tipo.codigo }"
																	<c:if test="${palestra.tipo } == ${tipo.codigo } }"><c:out value="selected" /></c:if>><c:out
																		value="${tipo.tipo }" /></option>
															</c:forEach>
													</select>
												
												</tr>
												<tr>
												
												<tr>
													<td>Curso Responsável</td>
													<td><input class="form-control" placeholder="Curso"
														readonly="readonly" size="40" name="curso"
														value='<c:out value="${curso.nome }" />'> <input
														type="hidden" name="codigocurso" value="${curso.codigo }">
													</td>
												</tr>
												<tr>
												
												<tr>
													<td>Evento</td>
													<td><input class="form-control" placeholder="Evento"
														readonly="readonly" size="40" name="evento"
														value='<c:out value="${evento.nome }" />'> <input
														type="hidden" name="codigoevento"
														value="${evento.codigo }"></td>
												</tr>
												<tr>
												
												<tr>
													<td>Sala</td>
													<td><select class="form-control" name="sala">
															<c:forEach items="${listasala }" var="sala">
																<option value="${sala.numero }"
																	<c:if test="${palestra.sala } == ${sala.numero } }"><c:out value="selected" /></c:if>>
																	<c:if test="${sala.numero == 0}">
																		<c:out value="Auditório" />
																	</c:if>
																	<c:if test="${sala.numero != 0}">
																		<c:out value="${sala.numero }" />
																	</c:if>
															
															</c:forEach>
													</select></td>
												</tr>

												<tr>
													<td align="center" colspan="2"><input
														class="btn btn-default" type="submit" name="enviar"
														value="Enviar"></td>
												</tr>


											</tbody>
										</table>
									</div>
								</div>
							</form>
						</c:if>
						<c:if test="${not empty listapalestra }">
							<div class="col-lg-6">
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>Título</th>
												<th>Palestrante</th>
												<th>Dia</th>
												<th>Hora</th>
												<th>Inscritos</th>
												<th>Sala</th>
												<th>Editar</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listapalestra }" var="pal">
											<tr>
												<td><c:out value="${pal.titulo }" /></td>
												<td><c:out value="${pal.palestrante }" /></td>
												<td><c:out value="${pal.dt }" /></td>
												<td><c:out value="${pal.hr }" /></td>
												<td><c:out value="${pal.inscritos }" /></td>
												<td><c:if test="${pal.sala.numero == 0}"><c:out value="Auditório"></c:out></c:if><c:if test="${pal.sala.numero != 0}"><c:out value="${pal.sala.numero }" /></c:if></td>
												<td>
														<!-- Botão editar --></td>
												<td>
														<!-- Botão excluir --></td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
						<!-- div com a tabela das palestras por curso -->
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
	</c:if>

	<c:if
		test="${(sessionScope.login.perfil.codigo != '3582') && (sessionScope.login.perfil.codigo != '3581') }">
		<head>
<META http-equiv="refresh" content="0;URL=index.jsp">
		</head>
	</c:if>
</c:if>
<c:if test="${empty sessionScope.login }">
	<head>
<META http-equiv="refresh" content="0;URL=index.jsp">
	</head>
</c:if>
</html>

