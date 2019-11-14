package com.workderapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.omg.CORBA.UserException;
import org.springframework.util.StringUtils;

import com.workderapi.dtos.MailDTO;
import com.workderapi.entity.User;
import com.workderapi.util.Constants.ConstantsMail;
import com.workderapi.util.Constants.ConstantsRegex;

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

	/**
	 * Method for clear values of objects return object
	 * @param <T>
	 */
	public static Object clearValues(Object o) {

		if (o instanceof User) {
			return (Object)clearValuesUser((User) o);
		}
		return o;
	}

	/**
	 * 
	 * */
	private static User clearValuesUser(User user) {
		// Validacion EMAIL
		user.setEmail((patternValue(ConstantsRegex.REGEX_MAIL, user.getEmail().trim())) ? user.getEmail().trim()
				: Constants.EMPTY);
		// Validacion NAME
		user.setName((patternValue(ConstantsRegex.REGEX_STRINGS, user.getName().trim())) ? user.getName().trim()
				: Constants.EMPTY);
		// Validacion SURNAME
		user.setSurname((patternValue(ConstantsRegex.REGEX_STRINGS, user.getName().trim())) ? user.getName().trim()
				: Constants.EMPTY);
		// Validacion PASSWORD
		user.setPassword(user.getPassword().trim());
		return user;
	}

	/**
	 * Comprueba cualquier valor a partir de un pattern
	 * 
	 * @return Boolean
	 */
	private static boolean patternValue(String regex, String value) {
		return Pattern.compile(regex).matcher(value).matches();
	}
}
