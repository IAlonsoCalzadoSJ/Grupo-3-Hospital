package correo;

public class ControladorEmail {
Email e;
HiloTiempo h;
Tuberia t;
ClienteCorreo c;
public ControladorEmail() {
	 e= new Email();
	 c= new ClienteCorreo();
	 t= new Tuberia(e);
	 
	 h= new HiloTiempo(c.getSt(),t);
	 h.start();
	
	meterListeners();
	e.setVisible(true);
}
public void meterListeners(){
	for(int i=0;i<e.getBotones().size();i++) {
		e.getBotones().get(i).addActionListener(new EventoBotones(e,t,c.getSt()));
	}
	e.getTable().getSelectionModel().addListSelectionListener(new EventoTabla(e.getTable()));
	
}
}
