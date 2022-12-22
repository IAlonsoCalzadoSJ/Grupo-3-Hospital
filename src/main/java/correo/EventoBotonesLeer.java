package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBotonesLeer implements ActionListener {

	EventoTabla eventoTabla;
	VistaLeer leer;
	public EventoBotonesLeer(EventoTabla eventoTabla, VistaLeer leer) {
		this.eventoTabla = eventoTabla; 
		this.leer=leer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		eventoTabla.setDone(true);
leer.dispose();

	}

}
