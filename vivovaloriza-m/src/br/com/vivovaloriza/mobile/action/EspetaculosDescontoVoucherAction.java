package br.com.vivovaloriza.mobile.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class EspetaculosDescontoVoucherAction extends ActionSupport {

	String anNome;    
	String dtVoucher;    
	String anTitulo;    
	String anSubTitulo;    
	String anDesc;
	String anImagem;
	String cnVoucher;

	public EspetaculosDescontoVoucherAction() {
    }
    
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String IMAGEM_URL = request.getSession().getServletContext().getInitParameter("imagem.url")+"teatro/";
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
			xml = "<"+actionName+"Response>" +
					"<anNome>THIAGO DOTOLI BENTO</anNome>" +
					"<dtVoucher>2014-01-01 21:00:00</dtVoucher>" +
					"<cnVoucher>123455</cnVoucher>" +
					"<anCodigoBarra></anCodigoBarra>" +
					"<anTitulo>Um Lugar Qualquer</anTitulo>" +
					"<anSubTitulo>50% de desconto em ingressos</anSubTitulo>" +
					"<anDesc>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet </anDesc>" +
					"<anImagem></anImagem>" +
					"<resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", EmitirVoucherEspetaculoDescontoResponse.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);

		EmitirVoucherEspetaculoDescontoResponse emitirVoucherEspetaculoDescontoResponse = (EmitirVoucherEspetaculoDescontoResponse) xStream.fromXML(xml);

		setAnNome( emitirVoucherEspetaculoDescontoResponse.getAnNome() );
		setDtVoucher ( emitirVoucherEspetaculoDescontoResponse.getDtVoucher() );
		setAnTitulo( emitirVoucherEspetaculoDescontoResponse.getAnTitulo() );
		setAnSubTitulo( emitirVoucherEspetaculoDescontoResponse.getAnSubTitulo() );
		setAnDesc( emitirVoucherEspetaculoDescontoResponse.getAnDesc() );
		setAnImagem( IMAGEM_URL + emitirVoucherEspetaculoDescontoResponse.getAnImagem() );
		setCnVoucher( emitirVoucherEspetaculoDescontoResponse.getCnVoucher() );

		try {
			SimpleDateFormat sdf_xml = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf_frontend = new SimpleDateFormat("dd/MM/yyyy HH:mm");  			
			setDtVoucher( sdf_frontend.format( sdf_xml.parse( getDtVoucher() ) ) );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public String getCnVoucher() {
		return cnVoucher;
	}

	public void setCnVoucher(String cnVoucher) {
		this.cnVoucher = cnVoucher;
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
