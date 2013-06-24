package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import swing.ConsultaGUI;

public class MenuAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String opcao = e.getActionCommand();
    	if(opcao.equalsIgnoreCase("Marcar consulta")){
   		 JFrame frame = new JFrame ("Consultas");
	     frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
	     frame.getContentPane().add (new ConsultaGUI());
	     frame.pack();
	     frame.setVisible (true);
    		
    	}else if(opcao.equalsIgnoreCase("sobre")){ 
    		// 
    	}
		
	}

}
