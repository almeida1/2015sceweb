package br.sceweb.dominio;


import java.util.ArrayList;


import java.util.List;

import org.apache.log4j.Logger;

import br.sceweb.servico.HibernateEmpresaDAO;

public class Fachada {
	Empresa empresa;
	EmpresaRepositorio empresaRepositorio;
    HibernateEmpresaDAO daoEmpresa;
    Logger logger = Logger.getLogger(Fachada.class);
    public Fachada(){
    	empresaRepositorio = new EmpresaRepositorio();
    	daoEmpresa = new HibernateEmpresaDAO();
    	
    }
	public boolean login(String userName, String password){
		String url = "";
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		
		return repositorio.login(userName, password);
		
	}
	

	public String incluirEmpresa(String nomeDaEmpresa, String cnpj, String nomeFantasia, String endereco, String telefone, 
		   String responsavel, String telefoneResponsavel, String setor, String email) {
		
		empresa = new Empresa();
		String codigoRetorno="";
		try {
			empresa.setNomeDaEmpresa(nomeDaEmpresa);
			empresa.setCnpj(cnpj);
			empresa.setNomeFantasia(nomeFantasia);
			empresa.setEndereco(endereco);
			empresa.setTelefone(telefone);
			empresa.setResponsavel(responsavel);
			empresa.setTelefoneResponsavel(telefoneResponsavel);
			empresa.setSetor(setor);
			empresa.setEmail(email);
		} catch (Exception e) {
			
			codigoRetorno =  e.getMessage();
			return codigoRetorno;
		}
		codigoRetorno = daoEmpresa.cadastra(empresa);
		return codigoRetorno;
		
	}
	public ArrayList<Empresa> consultaCNPJ(String cnpj){
		
		return empresaRepositorio.consulta(cnpj);
	}
	public int excluirEmpresa(String cnpj){
		logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>obtem parametro do cnpj para exclusao ="+ cnpj );
		return daoEmpresa.exclui(cnpj);
		
	}
	public List<Empresa> listaTodas(){
		return (List<Empresa>) empresaRepositorio.findAll();
	}
}