
package br.sceweb.dominio;

import java.util.ArrayList;
import java.util.Collection;



import java.util.List;

import br.sceweb.servico.HibernateEmpresaDAO;
import br.sceweb.servico.IEmpresaDAO;

/**
 * @author: edson
 * @version 
 */
public class EmpresaRepositorio {
	private IEmpresaDAO daoEmpresa;
	
	public EmpresaRepositorio() {
		daoEmpresa = new HibernateEmpresaDAO();
	}
	/**
	 * Cadastra a empresa na base de dados
	 * @param empresa
	 * @return boolean true cadastrado false nao cadastrado
	 */
	public String save (Empresa empresa){
		return daoEmpresa.cadastra(empresa);
		
	}
	public List<Empresa> findAll(){
		return daoEmpresa.findAll();
	}
	public ArrayList<Empresa> consulta(String cnpj){
		return (ArrayList<Empresa>) daoEmpresa.consulta(cnpj);
	}
}
