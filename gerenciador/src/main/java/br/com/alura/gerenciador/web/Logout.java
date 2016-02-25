package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
		
	}
	
	
}


/* Passou a utilizar a Tarefa.java
@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// Login/Logout agora é controlado por session
		//Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		//		
		//if(cookie !=null) {
		//	cookie.setMaxAge(0);
		//	resp.addCookie(cookie);
		//}
		
		

		
		//Utilizando Session para fazer logout. Primeiro remove a chave de login, depois descarta a sessão do servidor.
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		session.invalidate();
		
		//Jeito antigo de printar saida no browser client
		// PrintWriter writer = resp.getWriter();
		//writer.println("<html><body>Logout Efetuado</body></html>");
		
		//Redirecionando para pagina de logout
		//resp.sendRedirect("logout.html");
		
		//Redirecionando no servidor 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
		
	
	}
	

}
*/