package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.consultas.dao.ConsultaDAO;
import br.com.consultas.dao.PacienteDAO;
import br.com.consultas.pojos.Consulta;
import br.com.consultas.pojos.Paciente;

import swing.ConsultaGUI;

public class VerificarConsultaAction implements ActionListener {

	private JTextField data;
	private JTable table;
     //action do botão de verificar consultas já cadastradas
	public VerificarConsultaAction(JTextField data, JTable table) {
		this.data = data;
		this.table=table;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ConsultaDAO p = new ConsultaDAO();
		
		
		String strDate = data.getText(); // insert nova data
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = new Date(sdf.parse(strDate).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Consulta> consultas = p.buscar();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel() ; 
		for (Consulta consulta : consultas) {
			model.addRow(new Object[] {consulta.getCodPaciente(), sdf.format(consulta.getDataConsulta())});
		}
		
		
		
		//JScrollPane pane = new JScrollPane(model);
        
        JOptionPane.showMessageDialog(null, "Consultado com sucesso!");
		
	}
}
