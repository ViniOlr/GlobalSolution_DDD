package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements IDAO{
	
	private Connection con;
	private Usuario usuario;
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String inserir(Object obj) {
		usuario = (Usuario) obj;
		String sql = "INSERT INTO T_SE_USUARIO (NOME, EMAIL, RG, CPF, TELEFONE, DATA_NASCIMENTO, SETOR, LOGIN, SENHA, RM)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, SQ_SE_USUARIO_RM)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setInt(3, usuario.getRG());
			ps.setInt(4, usuario.getCPF());
			ps.setInt(5, usuario.getTelefone());
			ps.setString(6, usuario.getDataNascimento());
			ps.setString(7, usuario.getSetor());
			ps.setString(8, usuario.getLogin());
			ps.setString(9, usuario.getSenha());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	@Override
	public String alterar(Object obj) {
		usuario = (Usuario) obj;
		String sql = "UPDATE T_SE_USUARIO SET EMAIL = ?, TELEFONE = ?, SETOR = ?, SENHA = ? WHERE RM = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, usuario.getEmail());
			ps.setInt(2, usuario.getTelefone());
			ps.setString(3, usuario.getSetor());
			ps.setString(4, usuario.getSenha());
			ps.setInt(5, usuario.getRM());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	@Override
	public String excluir(Object obj) {
		usuario = (Usuario) obj;
		String sql = "DELETE FROM T_SE_USUARIO WHERE RM = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, usuario.getRM());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	@Override
	public String listarTodos() {
		String sql = "SELECT * FROM T_SE_USUARIO";
		String lista = "Lista de usuários:\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					lista += "Nome:" + rs.getString(1) + "\n";
				}
				return lista;
			} else {
				return "Nenhum usuario cadastrado.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

}
