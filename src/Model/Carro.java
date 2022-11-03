package Model;

public class Carro {
	
	private String marca, modelo, placa;
	private int ano, kmPorLitro;
	
	public Carro() {
		
	}

	public Carro(String marca, String modelo, String placa, int ano, int kmPorLitro) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.kmPorLitro = kmPorLitro;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getKmPorLitro() {
		return kmPorLitro;
	}

	public void setKmPorLitro(int kmPorLitro) {
		this.kmPorLitro = kmPorLitro;
	}

}
