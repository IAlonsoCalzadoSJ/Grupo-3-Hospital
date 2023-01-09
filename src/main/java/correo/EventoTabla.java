package correo;

import java.io.File;
import java.io.IOException;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jsoup.Jsoup;

public class EventoTabla implements ListSelectionListener {
	JTable t;
	boolean done = true;
	Tuberia t2;

	public EventoTabla(JTable table, Tuberia t2) {
		// TODO Auto-generated constructor stub
		this.t = table;
		this.t2 = t2;
	}

	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		if(done&&t.getRowCount()>0) {
			try {
				Message m=t2.sacardatos(Integer.valueOf(t.getValueAt(t.getSelectedRow(), 0).toString()));
				VistaLeer leer  = new VistaLeer();
				String a=m.getContentType();
				Multipart multi = (Multipart) m.getContent();
			
				String quien=m.getFrom()[0].toString();
				String header=m.getSubject().toString();
				try {
					String contenido ="";
					
						  
							   for(int o=0;o<multi.getCount();o++) {
								   
								   BodyPart b=multi.getBodyPart(o);
								  // System.out.println("tipo:"+b.getContentType());
								 if(b.getContentType().equals("text/html")) {
								   System.out.print(multi.getCount()+"cuenta");
									String hola=Jsoup.parse(b.getContent().toString()).text();
									contenido=contenido+hola;
									leer.getTable().setText(contenido);
								  }
							   else if(b.getContentType().contains(("multipart/alternative"))) {
								   System.out.print("hay archivo adjuunto");
								 // File f=(File) b.getContent();
								     //System.out.print(f.getName());
								   
							   }
							 /*  else if(b.getContentType().contains(("image/jpeg"))) {
								   System.out.print("hay image");
									   
								   
							   }*/
								 
							   else if(b.getContentType().equals("text/plain")) {
								   String hola=b.getContent().toString();
									contenido=contenido+hola;
									leer.getTable().setText(contenido);
							   }
								   
							   }
						 
							   
							   
						   
					
					
					
				
				if(quien.contains("<")||quien.contains(">")) {
					quien=quien.substring(quien.indexOf("<")+1,quien.indexOf(">"));
					}
				leer.getTextField().setText(quien);
				leer.getTextField_1().setText(header);
				
				
				done=false;
				leer.setVisible(true);
				for(int i=0;i<leer.getBotones().size();i++) {
					leer.getBotones().get(i).addActionListener(new EventoBotonesLeer(this,leer));
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
			catch(Exception si){
				
			}
	}
		else {
			done=false;
		}
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
