package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Cria um request do tipo req e rep para tratar as URI
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		
		//Carrega usuario com valor default
		String usuario = "<deslogado>";
		
		
		//Carrega informação do session
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		//Se a informação do session nao for nula, carrega info do usuario
		if (usuarioLogado !=null) usuario = usuarioLogado.getEmail();
		
		
		
		/* Utilizando session agora para controlar acesso
		//Pega usuario do cookie
		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		//Se o retorno nao for nulo, carrega com o nome do usuario e adiciona mais 10 min de vida ao cookie
		if (cookie != null) {
			usuario = cookie.getValue();
			cookie.setMaxAge(10 * 60);
			rep.addCookie(cookie);
		}
		*/
		System.out.println("Usuario " + usuario + " acessando a URI " + req.getRequestURI());
		//continua carregando  a pagina
		chain.doFilter(request, response);
	}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
