package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ConsultaAction implements ActionListener{
	
	private JTextField codigo;
	private JTextField data;
	private JTextField hora;
	
	public ConsultaAction(JTextField codigo, JTextField data, JTextField hora ){
		this.codigo = codigo;
		this. data = data;
		this. hora = hora;				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Código:" + codigo + "Data:" + data + "Hora:" + hora);
	}
}
