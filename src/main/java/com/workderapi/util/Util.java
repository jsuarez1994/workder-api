package com.workderapi.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.workderapi.dtos.MailDTO;
import com.workderapi.util.Constants.ConstantsMail;

public class Util {

	/**
	 * Name: chargePropertiesMail Description: Carga la propiedad para enviar email
	 */
	public static Properties chargePropertiesMail() {
		Properties mailServerProperties = System.getProperties();
		mailServerProperties.put(ConstantsMail.MAIL_SMTP_PORT, ConstantsMail.MAIL_PORT);
		mailServerProperties.put(ConstantsMail.MAIL_SMTP_AUTH, ConstantsMail.MAIL_AUTH);
		mailServerProperties.put(ConstantsMail.MAIL_SMTP_ENABLE, ConstantsMail.MAIL_ENABLE);

		return mailServerProperties;
	}

	/**
	 * Name: generateMessage
	 * 
	 * @throws MessagingException
	 * @throws AddressException
	 * @Params: session
	 * @Params: email Description: Genera el mensaje a partir del DTO email y
	 *          session
	 */
	public static Message generateMessage(Session session, MailDTO email) throws AddressException, MessagingException {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email.getFromEmail()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToEmail()));
		message.setSubject(email.getTitle());
		message.setText(email.getText());

		return message;
	}

}
