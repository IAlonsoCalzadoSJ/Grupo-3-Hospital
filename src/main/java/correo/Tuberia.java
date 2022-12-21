package correo;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.table.DefaultTableModel;

public class Tuberia {
	 int msjs=0;
	int tiempo = 0;
	Folder inbox2;
	Email e;
	Store st;
	boolean vivo=true;

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public Store getSt() {
		return st;
	}

	public void setSt(Store st) {
		this.st = st;
	}

	public Tuberia(Email e) {
		// TODO Auto-generated constructor stub
		this.e=e;
	}

	public synchronized void todocorreo(Store store) throws NoSuchProviderException, MessagingException, IOException {
	//	Message[] m;
		

		Folder inbox = store.getFolder("INBOX");
		if (inbox == null) {
			System.out.println("No INBOX");
			System.exit(1);
		}
		inbox.open(Folder.READ_ONLY);
		inbox2=inbox;
		correos(inbox);
	}

	public  synchronized void correos(Folder inbox) throws NoSuchProviderException, MessagingException, IOException {
		tiempo=0;
		if(inbox.hasNewMessages()||inbox.getNewMessageCount()!=0||msjs==0||inbox.getMessageCount()!=msjs) {
			DefaultTableModel model = new DefaultTableModel(); 
			model.addColumn("Remitente");
			model.addColumn("Asunto");
			model.addColumn("Fecha/hora");
			
	
			
		
			Message[] messages = inbox.getMessages();

			for (int i = messages.length - 1; i > 0; i--) {
				String a="";
				
				Address[] quien = messages[i].getFrom();
				
				for(int j=0;j<quien.length;j++) {
					 a=quien[j].toString();
					if(a.contains("<")||a.contains(">")) {
					a=a.substring(a.indexOf("<")+1,a.indexOf(">"));
					System.out.print(a+"Imprimo aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					}
				}
				Date fecha = messages[i].getSentDate();
				String asunto = messages[i].getSubject();
				if(!a.equals("")) {
				System.out.println(asunto + fecha + a);
				model.addRow(new Object[] {a,messages[i].getSubject(),messages[i].getSentDate()});
				e.getTable().setModel(model);
				
				}
				else {
					System.out.println(asunto + fecha + quien[0]);
				model.addRow(new Object[] {messages[i].getFrom()[0],messages[i].getSubject(),messages[i].getSentDate()});
				e.getTable().setModel(model);
				}
				
				i=i;
			
			}
			
			System.out.println(messages.length);
		
		}
		else {
			System.out.println("no hay nada nuevo"+msjs+inbox.getNewMessageCount());
			Message[] messages = inbox.getMessages();
 
		
			
			System.out.println(messages.length);
			/*	Address[] quien = messages[messages.length - 1].getFrom();
				Date fecha = messages[messages.length - 1].getSentDate();
				String asunto = messages[messages.length - 1].getSubject();
				System.out.println(asunto + fecha + quien[0]);*/
			
			
		}
		msjs = inbox.getMessageCount();
		tiempo=0;
	}
}
