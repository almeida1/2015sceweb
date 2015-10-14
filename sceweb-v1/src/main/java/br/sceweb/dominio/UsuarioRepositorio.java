package br.sceweb.dominio;


import br.sceweb.servico.HibernateUsuarioDAO;
import br.sceweb.servico.IUsuarioDAO;

public class UsuarioRepositorio {
	private IUsuarioDAO daoUsuario;

	public UsuarioRepositorio() {
		this.daoUsuario = new HibernateUsuarioDAO();
	}
	public boolean login(String nome, String senha) {
			return daoUsuario.login(nome, senha);
	}

}
