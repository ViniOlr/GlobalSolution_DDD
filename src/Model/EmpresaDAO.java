package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO implements IDAO {
	
	private Connection con;
	private Empresa empresa;
	
	public EmpresaDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public String inserir(Object obj) {
		empresa = (Empresa) obj;
		String sql = "INSERT INTO T_SE_EMPRESA (id_empresa, cnpj, nome, qtd_funcionarios, endereco, telefone)"
				+ "VALUES (SQ_SE_EMPRESA.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNome());
			ps.setInt(3, empresa.getQuantidadeFuncionarios());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
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
		empresa = (Empresa) obj;
		String sql = "UPDATE T_SE_EMPRESA SET qtd_funcionarios = ?, endereco = ?, telefone = ? WHERE cnpj = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, empresa.getQuantidadeFuncionarios());
			ps.setString(2, empresa.getEndereco());
			ps.setString(3, empresa.getTelefone());
			ps.setString(4, empresa.getCnpj());
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
		empresa = (Empresa) obj;
		String sql = "DELETE FROM T_SE_EMPRESA WHERE cnpj = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, empresa.getCnpj());
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
		String sql = "SELECT * FROM T_SE_EMPRESA";
		String lista = "Lista de empresas:\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					lista += "ID da empresa: " + rs.getInt(1) + "\n";
					lista += "CNPJ: " + rs.getInt(2) + "\n";
					lista += "Nome: " + rs.getString(3) + "\n";
					lista += "Quantidade de Funcionários: " + rs.getInt(4) + "\n";
					lista += "Endereço: " + rs.getString(5) + "\n";	
					lista += "Telefone: " + rs.getString(6) + "\n\n";									
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
