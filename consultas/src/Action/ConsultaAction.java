package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.consultas.dao.ConsultaDAO;
import br.com.consultas.dao.PacienteDAO;
import br.com.consultas.pojos.Consulta;
import br.com.consultas.pojos.Paciente;

import swing.ConsultaGUI;

public class ConsultaAction implements ActionListener {

	private JTextField codigo;
	private JTextField data;

	public ConsultaAction(JTextField codigo, JTextField data) {
		this.codigo = codigo;
		this.data = data;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int c = Integer.parseInt(codigo.getText());
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



		Consulta novaConsulta = new Consulta(1, c, date);

        p.inserir(novaConsulta);
        
        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
		
	}
}
