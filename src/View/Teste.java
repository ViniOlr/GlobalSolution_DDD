package View;

import java.sql.*;

import Model.Conexao;
import Model.Motorista;
import Model.Usuario;
import Model.UsuarioDAO;
import Model.MotoristaDAO;

public class Teste {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();

		/*Usuario usuario = new Usuario();
		usuario.setNome("Vinicius de Oliveira");
		usuario.setCPF(526764518);
		usuario.setTelefone("(11) 96630-9946");
		usuario.setDataNascimento("15-05-2003");
		usuario.setEmail("vini@gmail.com");
		usuario.setLogin("Vini");
		usuario.setRG(575331641);
		usuario.setSenha("1234");
		usuario.setSetor("Administrativo");
		usuario.setRM(1);
		
		UsuarioDAO udao = new UsuarioDAO(con);
		//System.out.println(udao.inserir(usuario));
		//System.out.println(udao.alterar(usuario));
		//System.out.println(udao.excluir(usuario));
		//System.out.println(udao.listarTodos());*/
		
		/*Motorista motorista = new Motorista();
		motorista.setNome("Vinicius");
		motorista.setCPF(526764518);
		motorista.setTelefone("(11) 96630-9946");
		motorista.setDataNascimento("15-05-2003");
		motorista.setEmail("vini@gmail.com");
		motorista.setRG(575331641);
		motorista.setNumeroHabilitacao(123456789);
		motorista.setCategoriaHabilitacao("AB");
		motorista.setDataExpedicao("24-06-2022");
		
		MotoristaDAO mdao = new MotoristaDAO(con);
		//System.out.println(mdao.inserir(motorista));
		//System.out.println(mdao.alterar(motorista));
		//System.out.println(mdao.excluir(motorista));
		//System.out.println(mdao.listarTodos());*/
		
		Conexao.fecharConexao(con);

	}

}
