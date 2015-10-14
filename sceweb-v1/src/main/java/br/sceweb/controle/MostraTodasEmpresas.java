package br.sceweb.controle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sceweb.dominio.EmpresaRepositorio;
import br.sceweb.dominio.Empresa;

public class MostraTodasEmpresas implements IComando {
	EmpresaRepositorio empresaRepositorio;

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) 	throws Exception {
		empresaRepositorio = new EmpresaRepositorio();
		List<Empresa> empresas = empresaRepositorio.findAll();
		request.setAttribute("empresas", empresas);
		return "/visao/FormConsultarTodos.jsp";
	}

}
