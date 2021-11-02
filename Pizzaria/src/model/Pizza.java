package model;

public class Pizza {
	private String nome;
	private String modificações;
	private double preço;
	private String tipo;
	private boolean bordaRecheada;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModificações() {
		return modificações;
	}
	public void setModificações(String modificações) {
		this.modificações = modificações;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isBordaRecheada() {
		return bordaRecheada;
	}
	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}		
}
