package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	
	private final Cookie[] cookies;
	
	//Construtor
	public Cookies(Cookie[] cookies) {
		
		this.cookies = cookies;
	}
	
	//verifica se o cookie do usuario logado existe, se nao retorna nulo
	 public Cookie getUsuarioLogado() {
			 
		if (cookies !=null) {
		// Varre os cookies procurando por usuario
			for(Cookie cookie : cookies){
				if (cookie.getName().equals("usuario.logado")){
					return cookie;
				}
			}
		}
		return null;
	}
}
