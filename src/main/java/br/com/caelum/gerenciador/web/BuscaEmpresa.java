package br.com.caelum.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa "
				+ this);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a sessão " + this);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Finalizando a sessão " + this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filtro = req.getParameter("filtro");

		// dando pausa no servidor
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		Collection<Empresa> empresas = new EmpresaDAO()
				.buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
}
