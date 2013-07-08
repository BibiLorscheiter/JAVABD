package br.com.consultas.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.consultas.pojos.Consulta;

/**
 * A classe <code>ConsultaDAO</code> representa um objecto de acesso a dados
 * (data access object - DAO).
 * 
 * Todas as opera›es em SQL e JDBC da aplica‹o s‹o realizadas pelo DAO.
 * 
 * @author bibianafonso@gmail.com
 * 
 */

@SuppressWarnings("unused")
public class ConsultaDAO {

	private static final String selectForDate = "select * from consulta where data_consulta::date = ?"; //order by data_consulta
	private static final String selectConsultaCode = "select * from consulta where cod = ?";
	private static final String insertConsulta = "insert into consulta(cod_paciente, data_consulta) values (?, ?)";



	/**
	 * Metodo responsavel por buscar todos registros da tabela consulta.
	 * 
	 * @return lista de consultas.
	 */
	public List<Consulta> buscar(Date data) {
		Date date = data;
		ArrayList<Consulta> consultaLista = new ArrayList<Consulta>();
		Consulta consulta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(
					"properties/consulta.properties"));
			String url = properties.getProperty("url");

			con = DriverManager.getConnection(url, properties);

			stmt = con.prepareStatement(selectForDate);
	
			
			stmt.setDate(1, (java.sql.Date) date);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt("cod");
				int cod_paciente = rs.getInt("cod_paciente");
				Timestamp data_consulta = rs.getTimestamp("data_consulta");

				consulta = new Consulta(cod, cod_paciente, data_consulta);
				consultaLista.add(consulta);
			}

		} catch (RuntimeException e) {

			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return consultaLista;
	}

	/**
	 * Metodo responsavel por trazer apenas uma consulta por codigo.
	 * 
	 * @param cod
	 *            - id da consulta
	 * @return
	 */
	public Consulta buscar(Integer cod) {

		Consulta consulta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(
					"properties/consulta.properties"));
			String url = properties.getProperty("url");

			con = DriverManager.getConnection(url, properties);

			stmt = con.prepareStatement(selectConsultaCode);
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int newCode = rs.getInt("cod");
				int cod_paciente = rs.getInt("cod_paciente");
				Date data_consulta = rs.getDate("data_consulta");
				consulta = new Consulta(newCode, cod_paciente, data_consulta);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return consulta;
	}

	/**
	 * Metod responsavel por adicionar um paciente consulta.
	 * 
	 * @param consulta
	 */
	public void inserir(Consulta consulta) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(
					"properties/consulta.properties"));
			String url = properties.getProperty("url");

			con = DriverManager.getConnection(url, properties);

			stmt = con.prepareStatement(insertConsulta);
			stmt.setInt(1, consulta.getCodPaciente());
			stmt.setTimestamp(2, new Timestamp(consulta.getDataConsulta().getTime()));
			int r = stmt.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir consulta");
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
	}

	public static void main(String[] args) {
		/*ConsultaDAO consultaDAO = new ConsultaDAO();
		List<Consulta> consultas = consultaDAO.buscar(); // retorna todos
		System.out.println("Inicio - Buscar();");
		 DateFormat df = new SimpleDateFormat("h:mm a");
		for (Consulta consulta : consultas) {
			
		}
		System.out.println("Fim - Buscar();");
		System.out.println("Inicio - Buscar(codigo);");
		Consulta consulta = consultaDAO.buscar(44); // retorna apenas pelo
													// codigo
		
		System.out.println("Fim - Buscar(codigo);");

		String strDate = "2014-11-11 09:30:00"; // insert nova data
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;

		try {
			date = new Date(sdf.parse(strDate).getTime());

			// System.out.println("Hora: " + S);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Consulta
		Consulta novaConsulta = new Consulta(1, 2, date);
		consultaDAO.inserir(novaConsulta);
	*/
	}

}