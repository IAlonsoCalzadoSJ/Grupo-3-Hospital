package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Store;

import common.Usuario;

public class EventoBotones implements ActionListener {
	Email email;
	Tuberia t;
	Store st;
	Usuario u;
	HiloTiempo h;

	public EventoBotones(Email e, Tuberia t, Store st, Usuario u, HiloTiempo h) {
		// TODO Auto-generated constructor stub
		this.h = h;
		this.u = u;
		this.email = e;
		this.t = t;
		this.st = st;
	}

	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		if (ev.getSource().equals(email.getBotones().get(0))) {
			// refresh
			try {
				t.todocorreo(st);
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("Refrescar");

		} else if (ev.getSource().equals(email.getBotones().get(1))) {
			// enviar
			System.out.print("Envio");
			Enviar e = new Enviar(u);

		} else if (ev.getSource().equals(email.getBotones().get(2))) {
			// Volver
			System.out.print("Vuelvo");
			t.setVivo(false);
			email.dispose();
			h.stop();
		}
	}

}
