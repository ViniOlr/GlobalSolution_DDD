package Controller;

import java.sql.Connection;

import Model.Carro;
import Model.CarroDAO;
import Model.Conexao;

public class CarroController {
	
	public String insereCarro(String marca, String modelo, int ano, int kmPorLitro, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Carro carro = new Carro();
		CarroDAO cdao = new CarroDAO(con);
		carro.setMarca(marca);
		carro.setModelo(modelo);
		carro.setAno(ano);
		carro.setKmPorLitro(kmPorLitro);
		carro.setPlaca(placa);
		resultado = cdao.inserir(carro);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String alteraCarro(int kmPorLitro, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Carro carro = new Carro();
		CarroDAO cdao = new CarroDAO(con);
		carro.setKmPorLitro(kmPorLitro);
		carro.setPlaca(placa);
		resultado = cdao.alterar(carro);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String excluiCarro(String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Carro carro = new Carro();
		CarroDAO cdao = new CarroDAO(con);
		carro.setPlaca(placa);
		resultado = cdao.excluir(carro);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String listaCarro() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		CarroDAO cdao = new CarroDAO(con);
		resultado = cdao.listarTodos();
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}

}
