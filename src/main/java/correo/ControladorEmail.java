package correo;

import common.Usuario;

public class ControladorEmail {
Email e;
HiloTiempo h;
Tuberia t;
ClienteCorreo c;
Usuario u;
public ControladorEmail(Usuario u) {
	this.u=u;
	 e= new Email();
	 c= new ClienteCorreo(u);
	 t= new Tuberia(e);
	 
	 h= new HiloTiempo(c.getSt(),t);
	 h.start();
	
	
	meterListeners();
	e.setVisible(true);
}
public void meterListeners(){
	for(int i=0;i<e.getBotones().size();i++) {
		e.getBotones().get(i).addActionListener(new EventoBotones(e,t,c.getSt(),u,h));
	}
	e.getTable().getSelectionModel().addListSelectionListener(new EventoTabla(e.getTable(),t));
	
}
}
