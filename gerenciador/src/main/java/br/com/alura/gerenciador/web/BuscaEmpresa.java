package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class BuscaEmpresa implements Tarefa {
	
	
	
public BuscaEmpresa() {
	System.out.println("Instanciando uma Tarefa do tipo BuscaEmpresa " + this);
}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		
		String filtro = req.getParameter("filtro");
		
		Collection<Empresa> empresas =new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/BuscaEmpresa.jsp";
	}
	
	
}



/* Implementado via tarefa
@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter writer = resp.getWriter();
		
		String filtro = req.getParameter("filtro");
		
		Collection<Empresa> empresas =new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		
		//Agora em JSP
		req.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/BuscaEmpresa.jsp");
		dispatcher.forward(req, resp);
		
		
		//Implementado via JSP
		//writer.println("<html>");
        //writer.println("<body>");
        //writer.println("Resultado da busca:<br/>");
        
        //Percorre colecao e printa o ID e Nome
        //writer.println("<ul>");
        //for(Empresa empresa : empresas) {
        //  writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
        // }
        // writer.println("</ul>");
        // 
        // 
        //writer.println("</body>");
        //writer.println("</html>");
        
        
	}
	
}
*/