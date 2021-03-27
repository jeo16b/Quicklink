package com.project2.util;

import com.project2.ajax.ClientMessage;

public class ClientMessageUtil {
	
public static final ClientMessage REGISTRATION_SUCCESSFUL = new ClientMessage("REGISTRATION SUCCESSFUL");
	
public static final ClientMessage SOMETHING_WRONG = new ClientMessage("SOMETHING WENT WRONG");

public static final ClientMessage LOGIN_SUCCESSFUL = new ClientMessage("LOGIN COMPLETED");

public static final ClientMessage LOGIN_ERROR = new ClientMessage("LOGIN ERROR\nUSERNAME OR PASSWORD INCORRECT");

public static final ClientMessage UPDATE_SUCCESSFUL = new ClientMessage("UPDATED SUCCESSFULLY");

public static final ClientMessage UPDATE_ERROR = new ClientMessage("ERROR UPDATING");

public static final ClientMessage DELETE_SUCCESSFUL = new ClientMessage("DELETED SUCCESSFULLY");

public static final ClientMessage DELETE_ERROR = new ClientMessage("ERROR DELETING");

}
