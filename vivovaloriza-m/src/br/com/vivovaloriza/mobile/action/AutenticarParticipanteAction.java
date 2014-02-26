package br.com.vivovaloriza.mobile.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import br.com.vivovaloriza.mobile.integration.response.AutenticarParticipanteResponse;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.util.Constantes;
import br.com.vivovaloriza.mobile.util.GenericoWS;

public class AutenticarParticipanteAction {

    private String message;
    private String anNomeOpr;

    public AutenticarParticipanteAction() {
    }

    public String execute() {

    	String STRUTS2_RETURN = "SUCCESS";
    	
    	try {
			
	    	HttpServletRequest request = ServletActionContext.getRequest();
	    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
	    	String actionName = ActionContext.getContext().getName();
	
			HttpSession session = request.getSession();
			session.removeAttribute(Constantes.BEAN_PARTICIPANTE_AUTENTICADO);
	
	    	GenericoWS generico = new GenericoWS( actionName );
	
	    	Enumeration enumeration = request.getParameterNames();
	        while (enumeration.hasMoreElements()) {
	            String parameterName = (String) enumeration.nextElement();
	        	generico.incluirTag(parameterName, request.getParameter(parameterName) );
	        }
			String xmlChamada = generico.formatarChamada();
	
			String xml = "";
			if(SOAP_URL.equals("LOCAL")) {
				xml = "<"+actionName+"Response>" +
						"<anNome>THIAGO DOTOLI BENTO</anNome>" +
						"<dtUltimoAcesso>2014-01-31 21:33:22</dtUltimoAcesso>" +
						"<caDoc>30256219826</caDoc>" +
						"<autorizacoes></autorizacoes>" +
						"<resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_TVG_RESP_XML_AUTENTICA</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
			} else {					
				xml = GenericoWS.executar(SOAP_URL,xmlChamada);
			}
	
			XStream xStream = new XStream(new Dom4JDriver());
	        xStream.alias(actionName+"Response", AutenticarParticipanteResponse.class);
	        xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);
	        
	        AutenticarParticipanteResponse autenticarParticipanteResponse = (AutenticarParticipanteResponse) xStream.fromXML(xml);
        
	        if( autenticarParticipanteResponse.getResultadoProcessamento().getCnRetorno() == 0 ) {
	        	session.setAttribute(Constantes.BEAN_PARTICIPANTE_AUTENTICADO, autenticarParticipanteResponse);
	        } else {
	        	setMessage("Login ou Senha inválidos!");
	        	STRUTS2_RETURN = "LOGIN";
	        }

    	} catch (Exception e) {
        	setMessage("Falha no Login");
        	STRUTS2_RETURN = "LOGIN";
		}

        return STRUTS2_RETURN;
    }

	public String getAnNomeOpr() {
		return anNomeOpr;
	}

	public void setAnNomeOpr(String anNomeOpr) {
		this.anNomeOpr = anNomeOpr;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}