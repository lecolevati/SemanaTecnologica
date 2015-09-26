<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-ex1-collapse">
		<span class="sr-only">Navegação</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="index.jsp">Portal Prof. Leandro
		Colevati</a>
</div>
<!-- Top Menu Items -->
<ul class="nav navbar-right top-nav">
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown"> 
		<c:if test="${empty sessionScope.login }">
			<c:out value="Intranet" /> 
		</c:if>
		<c:if test="${not empty sessionScope.login }">
			<c:out value="${sessionScope.login }" />
		</c:if>
		<b class="caret"></b></a>
		<ul class="dropdown-menu">
			<c:if test="${empty sessionScope.login }">
				<li><a href="login.jsp"><i class="fa fa-fw fa-user"></i>
						Login</a></li>
			</c:if>
			<c:if test="${not empty sessionScope.login }">
			<!-- 
				<li><a href="/logout"><i class="fa fa-fw fa-power-off"></i>
						Logout</a></li>
			 -->
				<li><a href="${pageContext.request.contextPath }/logout"><i class="fa fa-fw fa-power-off"></i>
						Logout</a></li>
			</c:if>
		</ul></li>
</ul>