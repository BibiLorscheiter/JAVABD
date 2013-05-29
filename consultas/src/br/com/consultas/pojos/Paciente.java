package br.com.consultas.pojos;

public class Paciente {
	private Integer cod;
	private String nome;
	private String telefone;
	
	public Paciente(Integer cod, String nome, String telefone){
		this.cod = cod;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public Paciente() {}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	} 	
}
