package correo;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Store;

public class HiloTiempo extends Thread {
	Tuberia t;
	private Store store;

	public HiloTiempo(Store store,Tuberia t) {
		this.store = store;
		this.t = t;
	}

	public void run() {
		try {
			t.todocorreo(store);
			while (true) {
				try {
					sleep(1000);
					System.out.print(t.tiempo+"s");
					t.tiempo++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(t.tiempo>=60) {
					t.todocorreo(store);
				}
			}
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
	}

}
