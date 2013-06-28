package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Action.MenuAction;

//class de interface do menu inicial
public class PrincipalGUI extends JFrame implements ActionListener {

	public static void main(String[] s) {
		new PrincipalGUI();
	}

	public PrincipalGUI() {

		super("Consultas");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		JMenuItem cadastro = new JMenuItem("Marcar consulta");
		cadastro.addActionListener(new MenuAction());
		JMenuItem sair = new JMenuItem ("Sair");
		sair.addActionListener(new MenuAction());

		// Name the JMenu & Add Items
		JMenu menu = new JMenu("Menu");
		menu.add(cadastro);
		menu.add(sair);

		// Add JMenu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
		setSize(300, 300);
		setLocation(200, 200);
		setVisible(true);
		setIconImage(new ImageIcon("imagem/consulta.png").getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}