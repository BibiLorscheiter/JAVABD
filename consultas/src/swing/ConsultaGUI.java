package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import Action.ConsultaAction;
import Action.LimpaGridAction;
import Action.VerificarConsultaAction;

public class ConsultaGUI extends JPanel {



private static final long serialVersionUID = 1L;

private JTextField horaText;
private JLabel horaLbl;
private JToggleButton okBtn;	
private JToggleButton confirmarBtn;
private JLabel pacienteLbl;
private JTextField pacienteText;
private JToggleButton limpaBtn;

 public ConsultaGUI() {

	 
	 horaText = new JTextField (5);
	 horaLbl = new JLabel ("Data/hora:");
	 limpaBtn = new JToggleButton ("Limpar",false);
	 
	 okBtn = new JToggleButton ("OK", false);
	 confirmarBtn = new JToggleButton ("Verificar disponibilidade", false);
	 pacienteLbl = new JLabel ("Cod Paciente:");
	 pacienteText = new JTextField (5);

	 String[] columns = {
        "Paciente",
        "Data"
       };
	 
	    JScrollPane pane = new JScrollPane();
     	pane.setBounds(100, 110, 300, 163);
     	pane.setBorder(BorderFactory.createLineBorder(Color.black, 4));
     	this.add(pane);

     	DefaultTableModel model = new DefaultTableModel();
	 	
	 	JTable table = new JTable(model);
	    
	 	//JTable table = new JTable(data, columns);
       	table.setPreferredScrollableViewportSize(new Dimension(500, 400));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
       	table.setFillsViewportHeight(true);
       	table.setBounds(10, 130, 580, 100);
       	table.setVisible(true);

       	model.addColumn("Paciente");
	 	model.addColumn("Data");
	 	
	 	pane.setViewportView(table);
		pane.setVisible(true);
	 
	 	
       	
       	setPreferredSize (new Dimension (601, 324));
       	setLayout (null);
       	
       	//add components
       	add (horaText);
       	add (horaLbl);
   		//add (dataLbl);    		
   		//add (dataText);
       	add (okBtn);
       	add (confirmarBtn);
       	add (pacienteLbl);
       	add (pacienteText);
       	add (limpaBtn);
       	
        horaText.setBounds (110, 55, 150, 20);
        horaLbl.setBounds (20, 55, 90, 20);
        limpaBtn.setBounds (200, 285, 101, 25);
        okBtn.setBounds (485, 285, 100, 25);
        confirmarBtn.setBounds (300, 285, 190, 25);
        pacienteLbl.setBounds (20, 30, 90, 25);
        pacienteText.setBounds (110, 30, 150, 20);
    
        ConsultaAction insere = new ConsultaAction(pacienteText, horaText);
        okBtn.addActionListener(insere);
    	
        VerificarConsultaAction verifica = new VerificarConsultaAction(horaText, table);
        confirmarBtn.addActionListener(verifica);	
        
        
        LimpaGridAction limpa = new LimpaGridAction(table);
        limpaBtn.addActionListener(limpa);	
    }
 
 		

    public static void main (String[] args) {

        JFrame frame = new JFrame ("Consultas");
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ConsultaGUI());
        frame.pack();
        frame.setSize(650, 400);
        frame.setVisible(true);
    }

}