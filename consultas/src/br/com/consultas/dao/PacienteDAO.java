package br.com.consultas.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.consultas.pojos.Paciente;

/**
 * A classe <code>PacienteDAO</code> representa um objecto de acesso a dados (data
 * access object - DAO).
 * 
 * Todas as opera�›es em SQL e JDBC da aplica�‹o s‹o realizadas pelo DAO.
 * 
 * @author bibianafonso@gmail.com
 * 
 */
public class PacienteDAO {

	private static final String selectAll = "select * from paciente";
	private static final String selectPacienteCode = "select * from paciente where cod = ?";
	private static final String insertPaciente = "insert into paciente(nome, telefone) values (?, ?)";

	
	/**
	 * Metodo responsavel por buscar todos registros da 
	 * tabela paciente.
	 * @return lista de pacientes.
	 */
	public List<Paciente> buscar() {
		ArrayList<Paciente> pacienteLista = new ArrayList<Paciente>();
		Paciente paciente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("properties/consulta.properties"));
			String url = properties.getProperty("url");
			
			con = DriverManager.getConnection(url, properties);

			stmt = con.prepareStatement(selectAll);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt("cod");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				paciente = new Paciente(cod, nome, telefone);
				pacienteLista.add(paciente);
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
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return pacienteLista;
	}
	
	/**
	 * Metodo responsavel por trazer apenas um paciente por codigo.
	 * @param cod - id do paciente
	 * @return
	 */
	public Paciente buscar(Integer cod){
		
		Paciente paciente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("properties/consulta.properties"));
			String url = properties.getProperty("url");
			
			con = DriverManager.getConnection(url, properties);

			stmt = con.prepareStatement(selectPacienteCode);
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int newCode = rs.getInt("cod");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				paciente = new Paciente(newCode, nome, telefone);
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
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return paciente;
	}
	
	/**
	 * Metod responsavel por adicionar um paciente.
	 * @param paciente
	 */
	public void inserir(Paciente paciente){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("properties/consulta.properties"));
			String url = properties.getProperty("url");
			
			con = DriverManager.getConnection(url, properties);

			stmt = con.prepareStatement(insertPaciente);
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getTelefone());
			int r = stmt.executeUpdate();
			
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir opera�‹o");
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
				// FIXME: comunicar erro ao programa cliente
			}
		}
	}
	
	public static void main(String[] args) {
		PacienteDAO pacienteDAO = new PacienteDAO();
		List<Paciente> pacientes = pacienteDAO.buscar(); // retorna todos
		System.out.println("Inicio - Buscar();");
		for(Paciente paciente : pacientes){
			System.out.println("Nome: " + paciente.getNome() + ", Telefone:" + paciente.getTelefone());
		}
		System.out.println("Fim - Buscar();");
		System.out.println("Inicio - Buscar(codigo);");
		Paciente paciente = pacienteDAO.buscar(3); // retorna apenas pelo codigo
		System.out.println("Nome: " + paciente.getNome() + ", Telefone:" + paciente.getTelefone());
		System.out.println("Fim - Buscar(codigo);");
		
		
		// Paciente
		Paciente novoPaciente = new Paciente(null, "Erick","33322332");
		pacienteDAO.inserir(novoPaciente);
		
	}
	
}