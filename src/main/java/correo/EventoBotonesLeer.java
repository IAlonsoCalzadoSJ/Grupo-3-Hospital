package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBotonesLeer implements ActionListener {

	EventoTabla eventoTabla = new EventoTabla(null);
	
	public EventoBotonesLeer(EventoTabla eventoTabla) {
		this.eventoTabla = eventoTabla; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
