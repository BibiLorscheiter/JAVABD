package Action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Action responsável por limpar a grid de consulta
 * @author Bibiana
 *
 */
@SuppressWarnings("serial")
public class LimpaGridAction extends AbstractAction {

	private JTable table;

	public LimpaGridAction(JTable table) {
		this.table = table;
	}

	@Override
	// limpa a grid apos consulta
	public void actionPerformed(ActionEvent arg0) {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		while (dm.getRowCount() != 0) {
			dm.removeRow(0);
				
		}
		
	}
}
