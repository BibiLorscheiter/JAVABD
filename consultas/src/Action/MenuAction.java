package Action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import swing.ConsultaGUI;
/**
 * Action responsável pelas opções do menu
 * chamada na PrincipalGUI
 * @author Bibiana
 *
 */
//action da tela inicial
@SuppressWarnings("serial")
public class MenuAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		String opcao = e.getActionCommand();
		if (opcao.equalsIgnoreCase("Marcar consulta")) {
			JFrame frame = new JFrame("Consultas");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().add(new ConsultaGUI());
			frame.pack();
			frame.setVisible(true);
			frame.setIconImage(new ImageIcon("imagem/consulta.png").getImage());

		} else if (opcao.equalsIgnoreCase("Sair")) {
			System.exit(0);
		}

	}

}
