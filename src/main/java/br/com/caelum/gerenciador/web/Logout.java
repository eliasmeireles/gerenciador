package br.com.caelum.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns="/logout")
public class Logout implements Tarefa{
	
	public String executa(HttpServletRequest req,
            HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("usuario.logado");
        return "/WEB-INF/paginas/logout.html";
    }
}
