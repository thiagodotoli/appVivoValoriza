package br.com.vivovaloriza.mobile.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import br.com.vivovaloriza.mobile.util.Constantes;
import br.com.vivovaloriza.mobile.integration.response.AutenticarParticipanteResponse;
import br.com.vivovaloriza.mobile.integration.response.EmitirVoucherEspetaculoDescontoResponse;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class VoucherConfirmarAction extends ActionSupport {

	String anNome;    
	String dtVoucher;    
	String anCodigoBarra;    
	String anTitulo;    
	String anSubTitulo;    
	String anDesc;
	String anImagem;	

	public VoucherConfirmarAction() {
    }
    
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String TEATRO_URL = request.getSession().getServletContext().getInitParameter("teatro.url");
    	String actionName = ActionContext.getContext().getName();

    	HttpSession session = request.getSession();
		AutenticarParticipanteResponse autenticarParticipanteResponse = (AutenticarParticipanteResponse) session.getAttribute(Constantes.BEAN_PARTICIPANTE_AUTENTICADO);
    	
    	GenericoWS generico = new GenericoWS( actionName );
    	generico.incluirTag("caDoc", autenticarParticipanteResponse.getCaDoc() );

    	Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = (String) enumeration.nextElement();
        	generico.incluirTag(parameterName, request.getParameter(parameterName) );
        }
		String xmlChamada = generico.formatarChamada();

		String xml = "";
		if(SOAP_URL.equals("LOCAL")) {
			xml = "<"+actionName+"Response><itens>" +
					"<item><cnSeq>1</cnSeq><anTitulo>Espetaculo 1</anTitulo><anSubTitulo>...</anSubTitulo><anDesc>TESTE LOCALO</anDesc><anImagem></anImagem><dtInicio>01/12/2013</dtInicio><dtFim>31/12/2013</dtFim><boAcessoAssinante>S</boAcessoAssinante><nmOrdem>1</nmOrdem><caOprAlt>A0000</caOprAlt></item>" +
					"<item><cnSeq>2</cnSeq><anTitulo>Espetaculo 2</anTitulo><anSubTitulo>...</anSubTitulo><anDesc>TESTE LOCALO</anDesc><anImagem></anImagem><dtInicio>01/11/2013</dtInicio><dtFim>31/01/2014</dtFim><boAcessoAssinante>S</boAcessoAssinante><nmOrdem>1</nmOrdem><caOprAlt>A0000</caOprAlt></item>" +
					"</itens><resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", EmitirVoucherEspetaculoDescontoResponse.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);

		EmitirVoucherEspetaculoDescontoResponse emitirVoucherEspetaculoDescontoResponse = (EmitirVoucherEspetaculoDescontoResponse) xStream.fromXML(xml);

		setAnNome( emitirVoucherEspetaculoDescontoResponse.getAnNome() );
		setDtVoucher ( emitirVoucherEspetaculoDescontoResponse.getDtVoucher() );
		setAnCodigoBarra( emitirVoucherEspetaculoDescontoResponse.getAnCodigoBarra() );
		setAnTitulo( emitirVoucherEspetaculoDescontoResponse.getAnTitulo() );
		setAnSubTitulo( emitirVoucherEspetaculoDescontoResponse.getAnSubTitulo() );
		setAnDesc( emitirVoucherEspetaculoDescontoResponse.getAnDesc() );
		setAnImagem( TEATRO_URL + emitirVoucherEspetaculoDescontoResponse.getAnImagem() );
		
    	return "SUCCESS";
	}
    
	public String getAnNome() {
		return anNome;
	}

	public void setAnNome(String anNome) {
		this.anNome = anNome;
	}

	public String getDtVoucher() {
		return dtVoucher;
	}

	public void setDtVoucher(String dtVoucher) {
		this.dtVoucher = dtVoucher;
	}

	public String getAnCodigoBarra() {
		return anCodigoBarra;
	}

	public void setAnCodigoBarra(String anCodigoBarra) {
		this.anCodigoBarra = anCodigoBarra;
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
