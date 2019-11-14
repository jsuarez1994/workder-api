package com.workderapi.util;

public final class Constants {
	
	public static final String EMPTY = "";
	public static final String FORMAT_DATE = "yyyy-MM-dd";

	
	/**
	 * Constantes para uso de las entidades.
	 * */
	public final class ConstantsEntity {
		// PHOTO DEFAULT
		public static final String PATH_PHOTO_DEFAULT = "../../assets/images/user.png";

	}
	
	
	/**
	 * Constantes para mail
	 * */
	public final class ConstantsMail {
		public static final String MAIL_SMTP_PORT = "mail.smtp.port";
		public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
		public static final String MAIL_SMTP_ENABLE = "mail.smtp.starttls.enable";
		
		public static final String MAIL_PORT = "587";
		public static final String MAIL_AUTH = "true";
		public static final String MAIL_ENABLE = "true";
	}
	
	/**
	 * Constantes utilizadas en los controladores. Determina la url de cada metodo.
	 */
	public final class ConstantsWS {
		public ConstantsWS() {}

		// BASE URL API
		public static final String WS_BASE_WORKDER_API = "/workder_api";
		public static final String WS_DNS = "http://localhost:4200";

		// AUX
		public static final String ID = "id";

		// USER WS
		public static final String WS_USERS = "/users";
		public static final String WS_USER = "/user";
		public static final String WS_USER_ID = "/user/{id}";
		public static final String WS_USER_LOGIN = "/user/login";
		public static final String WS_USER_ACTIVE_COMPANY_ID = "/users/active/{id}";
		public static final String WS_USER_ORDER = "/user/order";
		public static final String WS_USER_SEND_MAIL = "/user/mail";

		// COMPANY WS
		public static final String WS_COMPANYS = "/companys";
		public static final String WS_COMPANY = "/company";
		public static final String WS_COMPANY_ID = "/company/{id}";

		// ORDER WS
		public static final String WS_ORDERS = "/orders";
		public static final String WS_ORDER = "/order";
		public static final String WS_ORDER_ID = "/order/{id}";
		public static final String WS_ORDERS_COMPLETE = "/orders/complete";
		public static final String WS_ORDERS_INCOMPLETE = "/orders/incomplete";
		public static final String WS_ORDERS_USER = "/orders/user";
		public static final String WS_ORDERS_COMPANY_COMPLETE = "/orders/company_complete";
		public static final String WS_ORDERS_COMPANY_INCOMPLETE = "/orders/company_incomplete";

		// POSITION WS
		public static final String WS_POSITIONS = "/positions";
		public static final String WS_POSITION = "/position";
		public static final String WS_POSITION_ID = "/position/{id}";

		// ROL WS
		public static final String WS_ROLS = "/rols";
		public static final String WS_ROL = "/rol";
		public static final String WS_ROL_ID = "/rol/{id}";

		// SECTOR WS
		public static final String WS_SECTORS = "/sectors";
		public static final String WS_SECTOR = "/sector";
		public static final String WS_SECTOR_ID = "/sector/{id}";
	}
	
	/**
	 * Constantes para pattern
	 * 
	 * */
	public final class ConstantsRegex {
		
		public static final String REGEX_MAIL = "^(.+)@(.+)$";
		public static final String REGEX_STRINGS = "([^0-9&+,:;=?@#]*)";
		public static final String REGEX_SPECIAL_CHARACTERS = "[$&+,:;=?@#|'<>-^*()%!]";
		
	}

}
