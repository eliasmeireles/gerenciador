<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
	<c:if test="${not empty usuarioLogado}">
    Você está logado como:  ${usuarioLogado.getEmail()}<br />
	</c:if>

	<form action="executa?tarefa=NovaEmpresa" method="post">
    	Nome da empresa: <input type="text" name="nome" /><br/>
    	<input type="submit" value="Enviar" />
	</form>
	<form action="login" method="POST">
		Email: <input type="text" name="email" /><br /> Senha: <input
			type="password" name="senha" /><br /> <input type="submit"
			value="Login" />
	</form>
	<form action="executa?tarefa=Logout" method="POST">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>