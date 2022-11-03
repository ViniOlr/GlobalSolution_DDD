package Model;

public class Empresa {
	
	private String nome, endereco;
	private int cnpj, quantidadeFuncionarios, telefone;
	
	public Empresa() {
		
	}

	public Empresa(String nome, String endereco, int cnpj, int quantidadeFuncionarios, int telefone) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}
	public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
}
