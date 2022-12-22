package correo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;

public class Messages {
	Image i;
	String getTextFromMessage(Message message) throws MessagingException, IOException {
		if (message.isMimeType("text/plain")) {
			return message.getContent().toString();
		}
		if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			return getTextFromMimeMultipart(mimeMultipart);
		}
		return "";
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		String result = "";
		for (int i = 0; i < mimeMultipart.getCount(); i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				return result + "\n" + bodyPart.getContent(); // without return, same text appears twice in my tests
			}
			result += this.parseBodyPart(bodyPart);
		}
		return result;
	}

	private String parseBodyPart(BodyPart bodyPart) throws MessagingException, IOException {
		if (bodyPart.isMimeType("text/html")) {

			return "\n" + org.jsoup.Jsoup.parse(bodyPart.getContent().toString()).text();
		}
		if (bodyPart.isMimeType("image/*")) {

			return "imagen";
			// "\n" + org.jsoup.Jsoup.parse(bodyPart.getContent().toString()).text();
		}
		if (bodyPart.getContent() instanceof MimeMultipart) {
		//	File f=bodyPart.setFileName("imagen");
			 
			
			return getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			
			
			
		}

		return "imagen";
	}

}
