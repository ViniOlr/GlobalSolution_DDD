package Model;


public class Motorista extends Pessoa {
	
	private String categoriaHabilitacao, dataExpedicao, numeroHabilitacao;
	
	public Motorista() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Motorista(String categoriaHabilitacao, String numeroHabilitacao, String dataExpedicao) {
		super();
		this.categoriaHabilitacao = categoriaHabilitacao;
		this.numeroHabilitacao = numeroHabilitacao;
		this.dataExpedicao = dataExpedicao;
	}

	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}
	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}
	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}
	public void setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}
	public String getDataExpedicao() {
		return dataExpedicao;
	}
	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

}