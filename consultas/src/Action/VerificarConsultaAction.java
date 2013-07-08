package Action;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.consultas.dao.ConsultaDAO;
import br.com.consultas.pojos.Consulta;

// action do botão de verificar consultas já cadastradas
@SuppressWarnings("serial")
public class VerificarConsultaAction extends AbstractAction {

	private JTextField data;
	private JTable table;

	public VerificarConsultaAction(JTextField data, JTable table) {
		this.data = data;
		this.table = table;
	}

	// metodo que converte texto do JtextField para date
	public Date Converte(JTextField data) {
		String campo = data.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = new Date(sdf.parse(campo).getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	@SuppressWarnings("unused")
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

		// chama metodo que converte Jtextfield e busca no array de consultas
		// pela data inserida
		Date campodata = Converte(data);
		List<Consulta> consultas = p.buscar(campodata);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Consulta consulta : consultas) {
			model.addRow(new Object[] { consulta.getCodPaciente(),
					sdf.format(consulta.getDataConsulta()) });
		}

		JOptionPane.showMessageDialog(null, "Consultado com sucesso!");

	}
}
