package Controller;

import java.sql.Connection;

import Model.Conexao;
import Model.Empresa;
import Model.EmpresaDAO;

public class EmpresaController {
	
	public String insereEmpresa(String nome, String endereco, String cnpj, int quantidadeFuncionarios, String telefone) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Empresa empresa = new Empresa();
		EmpresaDAO edao = new EmpresaDAO(con);
		empresa.setCnpj(cnpj);
		empresa.setEndereco(endereco);
		empresa.setNome(nome);
		empresa.setQuantidadeFuncionarios(quantidadeFuncionarios);
		empresa.setTelefone(telefone);
		resultado = edao.inserir(empresa);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String alteraEmpresa(String endereco, String cnpj, int quantidadeFuncionarios, String telefone) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Empresa empresa = new Empresa();
		EmpresaDAO edao = new EmpresaDAO(con);
		empresa.setCnpj(cnpj);
		empresa.setEndereco(endereco);
		empresa.setQuantidadeFuncionarios(quantidadeFuncionarios);
		empresa.setTelefone(telefone);
		resultado = edao.alterar(empresa);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String excluiEmpresa(String cnpj) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Empresa empresa = new Empresa();
		EmpresaDAO edao = new EmpresaDAO(con);
		empresa.setCnpj(cnpj);
		resultado = edao.excluir(empresa);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String listaEmpresa() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		EmpresaDAO edao = new EmpresaDAO(con);
		resultado = edao.listarTodos();
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}

}
