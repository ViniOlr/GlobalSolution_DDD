package Controller;

import java.sql.Connection;

import Model.Conexao;
import Model.Motorista;
import Model.MotoristaDAO;

public class MotoristaController {
	
	public String insereMotorista(String categoriaHabilitacao, String numeroHabilitacao, String dataExpedicao,
			String nome, String email, String dataNascimento, String telefone,String RG, String CPF) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Motorista motorista = new Motorista();
		MotoristaDAO mdao = new MotoristaDAO(con);
		motorista.setNome(nome);
		motorista.setCPF(CPF);
		motorista.setTelefone(telefone);
		motorista.setDataNascimento(dataNascimento);
		motorista.setEmail(email);
		motorista.setRG(RG);
		motorista.setNumeroHabilitacao(numeroHabilitacao);
		motorista.setCategoriaHabilitacao(categoriaHabilitacao);
		motorista.setDataExpedicao(dataExpedicao);
		resultado = mdao.inserir(motorista);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String alteraMotorista(String email, String telefone, String CPF) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Motorista motorista = new Motorista();
		MotoristaDAO mdao = new MotoristaDAO(con);
		motorista.setCPF(CPF);
		motorista.setTelefone(telefone);
		motorista.setEmail(email);
		resultado = mdao.alterar(motorista);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String excluiMotorista(String CPF) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Motorista motorista = new Motorista();
		MotoristaDAO mdao = new MotoristaDAO(con);
		motorista.setCPF(CPF);
		resultado = mdao.excluir(motorista);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String listaMotorista() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		MotoristaDAO mdao = new MotoristaDAO(con);
		resultado = mdao.listarTodos();
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}

}
