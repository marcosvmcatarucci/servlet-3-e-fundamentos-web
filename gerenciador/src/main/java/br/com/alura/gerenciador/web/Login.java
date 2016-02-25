package br.com.alura.gerenciador.web;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{
	
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email,senha);
		
		PrintWriter writer = resp.getWriter();
		
		if (usuario == null){
			writer.println("<html><body>Usuário ou senha inválida");
		}else {
			
			//Utilizando sessão para controlar login de usuarios
			//Pega Sessão e adiciona a informação de login a Session
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			
			
					
			/*  jeito antigo de armazenar com cookies
			Cookie cookie = new Cookie("usuario.logado", email);
			cookie.setMaxAge(10 * 60);
			resp.addCookie(cookie);
			*/
			
			
			writer.println("<html><body>Usuário Logado: " + email + "</body></htmll>");
						
		}
		
	};
	
	
	

}



























