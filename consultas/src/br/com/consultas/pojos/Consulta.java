package br.com.consultas.pojos; // pojo - plain old java object

import java.sql.Date;

public class Consulta {
	private Integer cod;
	private Integer codPaciente;
	private Date dataConsulta;
	private String hora;
	
public Consulta (Integer cod, Integer cod_paciente, Date data_consulta, String hora){
   this.cod = cod;        
   this.codPaciente = cod_paciente;
   this.dataConsulta = data_consulta;
   this.hora = hora;
}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public Integer getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(Integer codPaciente) {
		this.codPaciente = codPaciente;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
