package Controller;

import java.sql.Connection;

import Model.Conexao;
import Model.Usuario;
import Model.UsuarioDAO;

public class UsuarioController {
	
	public String insereUsuario(String setor, String login, String senha,
			String nome, String email, String dataNascimento, String telefone, String RG, String CPF) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Usuario usuario = new Usuario();
		UsuarioDAO udao = new UsuarioDAO(con);
		usuario.setNome(nome);
		usuario.setCPF(CPF);
		usuario.setTelefone(telefone);
		usuario.setDataNascimento(dataNascimento);
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setRG(RG);
		usuario.setSenha(senha);
		usuario.setSetor(setor);
		resultado = udao.inserir(usuario);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String alteraUsuario(String email, String telefone, String setor, String senha, String CPF) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Usuario usuario = new Usuario();
		UsuarioDAO udao = new UsuarioDAO(con);
		usuario.setCPF(CPF);
		usuario.setTelefone(telefone);
		usuario.setSetor(setor);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		resultado = udao.alterar(usuario);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String excluiUsuario(String CPF) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Usuario usuario = new Usuario();
		UsuarioDAO udao = new UsuarioDAO(con);
		usuario.setCPF(CPF);
		resultado = udao.excluir(usuario);
		Conexao.fecharConexao(con);
		
		return resultado;
	}
	
	public String listaUsuario() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		UsuarioDAO udao = new UsuarioDAO(con);
		resultado = udao.listarTodos();
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}

}
