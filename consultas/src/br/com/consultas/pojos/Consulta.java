package br.com.consultas.pojos; // pojo - plain old java object

import java.util.Date;
import java.sql.Timestamp;

public class Consulta {
	private Integer cod;
	private Integer codPaciente;
	private Date dataConsulta;
	
	
public Consulta (Integer cod, Integer cod_paciente, Date data_consulta){
   this.cod = cod;        
   this.codPaciente = cod_paciente;
   this.dataConsulta = data_consulta;
   
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
	public void setDataConsulta(Timestamp dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
}
