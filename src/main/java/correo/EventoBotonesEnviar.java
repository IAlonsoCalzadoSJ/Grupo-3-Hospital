package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.swing.JFileChooser;

public class EventoBotonesEnviar implements ActionListener {
VistaEnviar ev;
Enviar enviar;
	public EventoBotonesEnviar(VistaEnviar ev, Enviar enviar) {
		// TODO Auto-generated constructor stub
		this.ev=ev;
		this.enviar=enviar;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(ev.getBotones().get(0))) {
			//ir patras
			ev.dispose();
			System.out.print("me voy");

		}
		else if(e.getSource().equals(ev.getBotones().get(1))) {
			//file
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION)
			{
			   File fichero = fileChooser.getSelectedFile();
			   // Aquí debemos abrir y leer el fichero.
			  enviar.setF(fichero);
			}
			
		}
		else if(e.getSource().equals(ev.getBotones().get(2))) {
			//send
			System.out.print("envio");
			try {
				enviar.enviar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ev.dispose();
			
		}
	}

}
