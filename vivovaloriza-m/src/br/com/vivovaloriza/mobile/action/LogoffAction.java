package br.com.vivovaloriza.mobile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import br.com.vivovaloriza.mobile.util.Constantes;

public class LogoffAction {

	public String execute() {

    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(Constantes.BEAN_PARTICIPANTE_AUTENTICADO);

		return "SUCCESS";	
	}
}