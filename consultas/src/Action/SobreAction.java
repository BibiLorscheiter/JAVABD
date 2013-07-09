package Action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SobreAction extends AbstractAction {
	
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Consultório Médico.\n(c) 2013 Bibiana Lorscheiter");
	}

}
