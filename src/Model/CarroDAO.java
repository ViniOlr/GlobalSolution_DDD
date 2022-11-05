package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO implements IDAO {
	
	private Connection con;
	private Carro carro;
	
	
	
	public CarroDAO(Connection con) {
		setCon(con);
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	@Override
	public String inserir(Object obj) {
		carro = (Carro) obj;
		String sql = "INSERT INTO T_SE_CARRO (id_carro, marca, modelo, ano, placa, km_por_litro)"
				+ "VALUES(SQ_SE_CARRO.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMarca());
			ps.setString(2, carro.getModelo());
			ps.setInt(3, carro.getAno());
			ps.setString(4, carro.getPlaca());
			ps.setInt(5, carro.getKmPorLitro());
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
		carro = (Carro) obj;
		String sql = "UPDATE T_SE_CARRO SET km_por_litro = ? WHERE placa = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carro.getKmPorLitro());
			ps.setString(2, carro.getPlaca());
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
		carro = (Carro) obj;
		String sql = "DELETE FROM T_SE_CARRO WHERE placa = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getPlaca());
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
		String sql = "SELECT * FROM T_SE_CARRO";
		String lista = "Lista de carros:\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					lista += "ID do carro: " + rs.getInt(1) + "\n";
					lista += "Marca: " + rs.getString(2) + "\n";
					lista += "Modelo: " + rs.getString(3) + "\n";
					lista += "Ano: " + rs.getInt(4) + "\n";
					lista += "Placa: " + rs.getString(5) + "\n";	
					lista += "Km p/ Litro: " + rs.getInt(6) + "\n\n";									
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
