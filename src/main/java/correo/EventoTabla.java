package correo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EventoTabla implements  ListSelectionListener {
JTable t;
	public EventoTabla(JTable table) {
		// TODO Auto-generated constructor stub
		this.t=table;
	}

	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		 System.out.println(t.getValueAt(t.getSelectedRow(), 0).toString()+"");	
	}

	

}
