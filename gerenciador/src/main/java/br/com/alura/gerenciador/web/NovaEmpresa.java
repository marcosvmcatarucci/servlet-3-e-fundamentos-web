package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String nome = req.getParameter("nome"); 
		Empresa empresa = new Empresa(nome);
		
		new EmpresaDAO().adiciona(empresa);
		
		//Seta atributo da req e depois redireciona para Tarefa
		req.setAttribute("nome", nome);
		
		
		return "/WEB-INF/paginas/NovaEmpresa.jsp";
	}
	
}

/* Migrado para Tarefa.java
@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		
		new EmpresaDAO().adiciona(empresa);
		
		
		//Passou a ser JSP, conforme abaixo
		//PrintWriter writer = resp.getWriter();
		//writer.println("<html><body>Empresa " + nome + " adicionada com sucesso</html></body>");
		
		
		//Seta atributo da req e depois redireciona no servidor
		req.setAttribute("nome", nome);
		req.getRequestDispatcher("/WEB-INF/paginas/NovaEmpresa.jsp").forward(req, resp);
		
	}
	

}
*/