package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MotoristaDAO implements IDAO {
	
	private Connection con;
	private Motorista motorista;
	
	public MotoristaDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	@Override
	public String inserir(Object obj) {
		motorista = (Motorista) obj;
		String sql = "INSERT INTO T_SE_MOTORISTA (id_motorista, nome, rg, cpf, telefone, email, data_nascimento, numero_habilitacao, categoria_habilitacao, data_expedicao)"
				+ "VALUES (SQ_SE_MOTORISTA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, motorista.getNome());
			ps.setInt(2, motorista.getRG());
			ps.setInt(3, motorista.getCPF());
			ps.setString(4, motorista.getTelefone());
			ps.setString(5, motorista.getEmail());
			ps.setString(6, motorista.getDataNascimento());
			ps.setInt(7, motorista.getNumeroHabilitacao());
			ps.setString(8, motorista.getCategoriaHabilitacao());
			ps.setString(9, motorista.getDataExpedicao());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@Override
	public String alterar(Object obj) {
		motorista = (Motorista) obj;
		String sql = "UPDATE T_SE_MOTORISTA SET telefone = ?, email = ? WHERE cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, motorista.getTelefone());
			ps.setString(2, motorista.getEmail());
			ps.setInt(3, motorista.getCPF());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@Override
	public String excluir(Object obj) {
		motorista = (Motorista) obj;
		String sql = "DELETE FROM T_SE_MOTORISTA WHERE cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, motorista.getCPF());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@Override
	public String listarTodos() {
		String sql = "SELECT * FROM T_SE_MOTORISTA";
		String lista = "Lista de motoristas:\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					lista += "RM: " + rs.getInt(1) + "\n";
					lista += "Nome: " + rs.getString(2) + "\n";
					lista += "RG: " + rs.getInt(3) + "\n";
					lista += "CPF: " + rs.getInt(4) + "\n";
					lista += "Telefone: " + rs.getString(5) + "\n";
					lista += "Email: " + rs.getString(6) + "\n";
					lista += "Data de Nascimento: " + rs.getString(7) + "\n";
					lista += "Numero da Habilitação: " + rs.getInt(8) + "\n";
					lista += "Categoria da Habilitação: " + rs.getString(9) + "\n";
					lista += "Data da Expedição: " + rs.getString(10) + "\n\n";					
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
