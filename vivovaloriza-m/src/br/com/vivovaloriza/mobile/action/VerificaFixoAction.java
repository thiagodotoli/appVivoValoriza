package br.com.vivovaloriza.mobile.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import br.com.vivovaloriza.mobile.integration.response.ListarEspetaculosDescontoResponse;
import br.com.vivovaloriza.mobile.integration.vo.EspetaculoDescontoVO;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaEspetaculosDescontoVO;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class VerificaFixoAction extends ActionSupport {

    public VerificaFixoAction() {
    }
    
    public String execute() {
    	return "SUCCESS";
	}

}
