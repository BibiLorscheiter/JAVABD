package swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Action.MenuAction;
import Action.SobreAction;

/**
 * Tela do menu principal
 * @author bibianafonso@gmail.com
 *
 */
//class de interface do menu inicial
@SuppressWarnings("serial")
public class PrincipalGUI  {
	
	private static void createGUI() {
		JFrame frame = new JFrame();
		
		//ITENS DO MENU E ACTIONS SENDO CHAMADAS
		JMenuItem cadastro = new JMenuItem("Marcar consulta");
		cadastro.addActionListener(new MenuAction());
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new MenuAction());
		JMenuItem sobre = new JMenuItem("Ajuda");
		sobre.addActionListener(new SobreAction());
	
		
		
		//ADICIONA ITENS DO MENU
		JMenu menu = new JMenu("Menu");
		menu.add(cadastro);
		menu.add(sobre);
		menu.add(sair);
						
		JLabel label = new JLabel("               Lorscheiter's Consultório Médico.");
		frame.add(label); 
		
		
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
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
	}

}