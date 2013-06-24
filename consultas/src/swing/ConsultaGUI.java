package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import Action.ConsultaAction;

public class ConsultaGUI extends JPanel {



private static final long serialVersionUID = 1L;

private JTextField horaText;
private JLabel horaLbl;
private JLabel dataLbl;
private JTextField dataText;
private JToggleButton okBtn;
private JToggleButton confirmarBtn;
private JLabel pacienteLbl;
private JTextField pacienteText;

 public ConsultaGUI() {

        //construct components
	 horaText = new JTextField (5);
	 horaLbl = new JLabel ("Hora:");
	 dataLbl = new JLabel ("Data:");
	 dataText = new JTextField (5);
	 okBtn = new JToggleButton ("OK", false);
	 confirmarBtn = new JToggleButton ("Verificar disponibilidade", false);
	 pacienteLbl = new JLabel ("Cod Paciente:");
	 pacienteText = new JTextField (5);

	 String[] columns = {
        "Paciente",
        "Data",
        "Hora"
       };
	 
	 Object[][] data = {
			 {"Bibiana 1", "23/06/2012", "11:00"},
			 {"Bibiana 2", "23/06/2012", "11:00"}
			 };

        JTable table = new JTable(data, columns);
       	table.setPreferredScrollableViewportSize(new Dimension(500, 70));
       	table.setFillsViewportHeight(true);
       	table.setBounds(10, 130, 580, 100);
       	table.setVisible(true);
       	setPreferredSize (new Dimension (601, 324));
       	setLayout (null);

       	//add components
       	add (horaText);
       	add (horaLbl);
   		add (dataLbl);    		
   		add (dataText);
       	add (okBtn);
       	add (confirmarBtn);
       	add (pacienteLbl);
       	add (pacienteText);
       	add (table);
       		//set component bounds (only needed by Absolute Positioning)

        horaText.setBounds (110, 55, 150, 20);
        horaLbl.setBounds (20, 55, 40, 20);
        dataLbl.setBounds (20, 80, 35, 20);
        dataText.setBounds (110, 80, 150, 20);
        okBtn.setBounds (485, 285, 100, 25);
        confirmarBtn.setBounds (300, 285, 190, 25);
        pacienteLbl.setBounds (20, 30, 90, 25);
        pacienteText.setBounds (110, 30, 150, 20);
        
        ConsultaAction action = new ConsultaAction(pacienteText, horaText, dataText);
        okBtn.addActionListener(action);
        	
        	
        
    }
 
 		

    public static void main (String[] args) {

        JFrame frame = new JFrame ("Consultas");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ConsultaGUI());
        frame.pack();
        frame.setVisible (true);
    }

}
	    