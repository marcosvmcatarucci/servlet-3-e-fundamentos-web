package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// qual tarefa quero executar?
		String tarefa = req.getParameter("tarefa");
		if(tarefa == null)
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");


		//Instanciando e chamando a classe
		try {
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;	
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instancia =  (Tarefa) type.newInstance();
			
			// para qual pagina desejo ir?
			String pagina = instancia.executa(req, resp);
			req.getRequestDispatcher(pagina).forward(req, resp);


		} catch (Exception e) {
			throw new ServletException(e);
		}


		
	}
}