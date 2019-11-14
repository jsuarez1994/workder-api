package com.workderapi.controllers;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workderapi.dtos.MailDTO;
import com.workderapi.entity.Order;
import com.workderapi.entity.User;
import com.workderapi.services.UserServiceIface;
import com.workderapi.util.Constants.ConstantsEntity;
import com.workderapi.util.Constants.ConstantsWS;
import com.workderapi.util.Util;

@CrossOrigin(origins = ConstantsWS.WS_DNS)
@RestController
@RequestMapping(ConstantsWS.WS_BASE_WORKDER_API)
public class UserController {

	@Autowired
	UserServiceIface userService;

	/*-----------------------METHODS-----------------------*/

	/**
	 * Name: index()
	 * 
	 * @Params:
	 * 
	 *          Description: Retorna todos los usuarios de la BD
	 */
	@RequestMapping(value = ConstantsWS.WS_USERS, method = RequestMethod.GET)
	public List<User> index() {
		return userService.findAll();
	}

	/**
	 * Name: show()
	 * 
	 * @Params: id
	 * 
	 *          Description: Muestra usuario a partir de su ID
	 */
	@RequestMapping(value = ConstantsWS.WS_USER_ID, method = RequestMethod.GET)
	public User show(@PathVariable(ConstantsWS.ID) Long id) {
		return userService.findById(id);
	}

	/**
	 * Name: create()
	 * 
	 * @Params: user D
	 * 
	 *          escription: Crea/Actualiza usuario
	 */
	@RequestMapping(value = ConstantsWS.WS_USER, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	/**
	 * Name: delete()
	 * 
	 * @Params: id
	 * 
	 *          Description: Elimina usuario a partir de su ID
	 */
	@RequestMapping(value = ConstantsWS.WS_USER_ID, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(ConstantsWS.ID) Long id) {
		userService.delete(id);
	}

	/**
	 * Name: login()
	 * 
	 * @Params: user
	 * 
	 *          Description: Se logea en el sistema a partir de email y password
	 */
	@RequestMapping(value = ConstantsWS.WS_USER_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody User user) {
		return userService.login(user.getEmail(), DigestUtils.sha256Hex(user.getPassword()));
	}

	/**
	 * Name: findByCompany()
	 * 
	 * @Params: idCompany
	 * 
	 *          Description: Retorna una lista de usuarios activos a partir del id
	 *          de la entidad Company
	 */
	@RequestMapping(value = ConstantsWS.WS_USER_ACTIVE_COMPANY_ID, method = RequestMethod.GET)
	public List<User> findByCompany(@PathVariable(ConstantsWS.ID) Long idCompany) {
		return userService.findByCompanyAndUserActivatedTrue(idCompany);
	}

	/**
	 * Name: findByOrder()
	 * 
	 * @Params: order
	 * 
	 *          Description: Retorna un usuario asociado a una entidad Orden
	 */
	@RequestMapping(value = ConstantsWS.WS_USER_ORDER, method = RequestMethod.POST)
	public User findByOrder(@RequestBody Order order) {
		User user = userService.findByOrder(order);

		User out = new User();

		out.setId(user.getId());
		out.setName(user.getName().trim());
		out.setSurname(user.getSurname().trim());
		out.setEmail(user.getEmail().trim());
		out.setPathPhoto(user.getPathPhoto().trim());
		out.setPosition(user.getPosition());

		return out;

	}

	/**
	 * Name: sendEmail()
	 * 
	 * @Params: email
	 * 
	 *          Description: Retorna un usuario asociado a una entidad Orden
	 */
	@RequestMapping(value = ConstantsWS.WS_USER_SEND_MAIL, method = RequestMethod.POST)
	public MailDTO sendEmail(@RequestBody MailDTO email) {
		// Creamos la variable para la salida
		MailDTO mailExit = email;

		try {
			Properties prop = Util.chargePropertiesMail();

			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email.getFromEmail(), email.getPassword());
				}
			});

			Transport.send(Util.generateMessage(session, email));

		} catch (MessagingException e) {
			System.out.println(e.getMessage());
			// La nuleamos para retornarla
			mailExit = null;
		}

		return (null != mailExit) ? email : mailExit;

	}

}
