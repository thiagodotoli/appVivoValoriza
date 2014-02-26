package br.com.vivovaloriza.mobile.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import br.com.vivovaloriza.mobile.integration.response.ExibirEspetaculoDescontoResponse;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class EspetaculosDescontoExibirAction extends ActionSupport {

	String cnSeq;    
	String anTitulo;    
	String anSubTitulo;    
	String anDesc;
	String anImagem;
	
    public EspetaculosDescontoExibirAction() {
    }
    
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String IMAGEM_URL = request.getSession().getServletContext().getInitParameter("imagem.url")+"teatro/";
    	String actionName = ActionContext.getContext().getName();

    	GenericoWS generico = new GenericoWS( actionName );

    	Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = (String) enumeration.nextElement();
        	generico.incluirTag(parameterName, request.getParameter(parameterName) );
        }
		String xmlChamada = generico.formatarChamada();

		String xml = "";
		if(SOAP_URL.equals("LOCAL")) {
			xml = "<"+actionName+"Response><cnSeq>1</cnSeq><anTitulo>Espetaculo 1</anTitulo><anSubTitulo>...</anSubTitulo><anDesc>TESTE LOCALO</anDesc><anImagem></anImagem>" +
					"<resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ExibirEspetaculoDescontoResponse.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);

		ExibirEspetaculoDescontoResponse exibirEspetaculoDescontoResponse = (ExibirEspetaculoDescontoResponse) xStream.fromXML(xml);

		setCnSeq( exibirEspetaculoDescontoResponse.getCnSeq() );
		setAnTitulo( exibirEspetaculoDescontoResponse.getAnTitulo() );
		setAnSubTitulo( exibirEspetaculoDescontoResponse.getAnSubTitulo() );
		setAnDesc( exibirEspetaculoDescontoResponse.getAnDesc() );
		setAnImagem( IMAGEM_URL + exibirEspetaculoDescontoResponse.getAnImagem() );

    	return "SUCCESS";
	}

	public String getCnSeq() {
		return cnSeq;
	}

	public void setCnSeq(String cnSeq) {
		this.cnSeq = cnSeq;
	}

	public String getAnTitulo() {
		return anTitulo;
	}

	public void setAnTitulo(String anTitulo) {
		this.anTitulo = anTitulo;
	}

	public String getAnSubTitulo() {
		return anSubTitulo;
	}

	public void setAnSubTitulo(String anSubTitulo) {
		this.anSubTitulo = anSubTitulo;
	}

	public String getAnDesc() {
		return anDesc;
	}

	public void setAnDesc(String anDesc) {
		this.anDesc = anDesc;
	}

	public String getAnImagem() {
		return anImagem;
	}

	public void setAnImagem(String anImagem) {
		this.anImagem = anImagem;
	}

    
    
}
