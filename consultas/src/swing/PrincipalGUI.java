package swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Action.MenuAction;

/**
 * Classe de tela de marcação de consultas chamada pela
 * PrincipalGui (menu inicial)
 * @author bibianafonso@gmail.com
 *
 */
//class de interface do menu inicial
@SuppressWarnings("serial")
public class PrincipalGUI extends JPanel {

	public PrincipalGUI() {
		JFrame frame = new JFrame();
		
		//ITENS DO MENU
		JMenuItem cadastro = new JMenuItem("Marcar consulta");
		cadastro.addActionListener(new MenuAction());
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new MenuAction());

		//ADICIONA ITENS DO MENU
		JMenu menu = new JMenu("Menu");
		menu.add(cadastro);
		menu.add(sair);
		add(menu);

		//ADICIONA MENU A BARRA
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		frame.setSize(300, 300);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("imagem/consulta.png").getImage());
	}

	public static void main(String[] s) {
		new PrincipalGUI();
	}

}