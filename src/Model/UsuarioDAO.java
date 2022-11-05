package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements IDAO{
	
	private Connection con;
	private Usuario usuario;
	
	public UsuarioDAO(Connection con) {
		setCon(con);
	}
	
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
		String sql = "INSERT INTO T_SE_USUARIO (rm, nome, rg, cpf, telefone, email, data_nascimento, setor, login, senha)"
				+ "VALUES (SQ_SE_USUARIO_RM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getRG());
			ps.setString(3, usuario.getCPF());
			ps.setString(4, usuario.getTelefone());
			ps.setString(5, usuario.getEmail());
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
		String sql = "UPDATE T_SE_USUARIO SET email = ?, telefone = ?, setor = ?, senha = ? WHERE cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getTelefone());
			ps.setString(3, usuario.getSetor());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getCPF());
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
		String sql = "DELETE FROM T_SE_USUARIO WHERE cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, usuario.getCPF());
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
					lista += "RM: " + rs.getInt(1) + "\n";
					lista += "Nome: " + rs.getString(2) + "\n";
					lista += "RG: " + rs.getString(3) + "\n";
					lista += "CPF: " + rs.getString(4) + "\n";
					lista += "Telefone: " + rs.getString(5) + "\n";
					lista += "Email: " + rs.getString(6) + "\n";
					lista += "Data de Nascimento: " + rs.getString(7) + "\n";
					lista += "Setor: " + rs.getString(8) + "\n";
					lista += "Login: " + rs.getString(9) + "\n";
					lista += "Senha: " + rs.getString(10) + "\n\n";					
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
