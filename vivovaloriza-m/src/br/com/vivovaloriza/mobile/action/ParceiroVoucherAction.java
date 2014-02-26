package br.com.vivovaloriza.mobile.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import br.com.vivovaloriza.mobile.util.Constantes;
import br.com.vivovaloriza.mobile.integration.response.AutenticarParticipanteResponse;
import br.com.vivovaloriza.mobile.integration.response.EmitirVoucherEspetaculoDescontoResponse;
import br.com.vivovaloriza.mobile.integration.response.ObterParceiroVoucherResponse;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ParceiroVoucherAction extends ActionSupport {

	String cnRelacionamento;
	String anNome;    
	String anParceiro;    
	String anLegenda;    
	String dtIniVoucher;    
	String dtFimVoucher;    
	String caCodigoBarras;
	String anFiguraDetNomeArq;	
	String dtEmissao;	

	public ParceiroVoucherAction() {
    }
    
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String IMAGEM_URL = request.getSession().getServletContext().getInitParameter("imagem.url") + "parceiros/";
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
					"<cnRelacionamento>9669699</cnRelacionamento>" +
					"<anNome>THIAGO DOTOLI BENTO</anNome>" +
					"<anParceiro>Americanas.com</anParceiro>" +
					"<anLegenda>50% teste</anLegenda>" +
					"<dtIniVoucher>2013-11-01 00:00:00</dtIniVoucher>" +
					"<dtFimVoucher>2014-03-22 59:59:00</dtFimVoucher>" +
					"<caCodigoBarras>P005681360000001</caCodigoBarras>" +
					"<anFiguraDetNomeArq>parc0004-tmb.jpg</anFiguraDetNomeArq>" +
					"<dtEmissao>2014-02-01 13:41:22</dtEmissao>" +
					"<resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ObterParceiroVoucherResponse.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);

		ObterParceiroVoucherResponse obterParceiroVoucherResponse = (ObterParceiroVoucherResponse) xStream.fromXML(xml);


		setCnRelacionamento( obterParceiroVoucherResponse.getCnRelacionamento() );
		setAnNome( obterParceiroVoucherResponse.getAnNome() );   
		setAnParceiro( obterParceiroVoucherResponse.getAnParceiro() );    
		setAnLegenda( obterParceiroVoucherResponse.getAnLegenda() );    
		setDtEmissao( obterParceiroVoucherResponse.getDtEmissao() );
		setDtIniVoucher( obterParceiroVoucherResponse.getDtIniVoucher() );
		setDtFimVoucher( obterParceiroVoucherResponse.getDtFimVoucher() );

		try {
			SimpleDateFormat sdf_xml = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf_frontend = new SimpleDateFormat("dd/MM/yyyy HH:mm");  			
			setDtEmissao( sdf_frontend.format( sdf_xml.parse( getDtEmissao() ) ) );

			if(!getDtIniVoucher().isEmpty()){
				setDtIniVoucher("Válido de: "+ sdf_frontend.format( sdf_xml.parse( getDtIniVoucher() ) ) +" até: "+ sdf_frontend.format( sdf_xml.parse(getDtFimVoucher()) ) );
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setCaCodigoBarras( obterParceiroVoucherResponse.getCaCodigoBarras() );
		setAnFiguraDetNomeArq( IMAGEM_URL + obterParceiroVoucherResponse.getAnFiguraDetNomeArq() );	

		return "SUCCESS";
	}

	public String getCnRelacionamento() {
		return cnRelacionamento;
	}

	public void setCnRelacionamento(String cnRelacionamento) {
		this.cnRelacionamento = cnRelacionamento;
	}

	public String getAnNome() {
		return anNome;
	}

	public void setAnNome(String anNome) {
		this.anNome = anNome;
	}

	public String getAnParceiro() {
		return anParceiro;
	}

	public void setAnParceiro(String anParceiro) {
		this.anParceiro = anParceiro;
	}

	public String getAnLegenda() {
		return anLegenda;
	}

	public void setAnLegenda(String anLegenda) {
		this.anLegenda = anLegenda;
	}

	public String getDtIniVoucher() {
		return dtIniVoucher;
	}

	public void setDtIniVoucher(String dtIniVoucher) {
		this.dtIniVoucher = dtIniVoucher;
	}

	public String getDtFimVoucher() {
		return dtFimVoucher;
	}

	public void setDtFimVoucher(String dtFimVoucher) {
		this.dtFimVoucher = dtFimVoucher;
	}

	public String getCaCodigoBarras() {
		return caCodigoBarras;
	}

	public void setCaCodigoBarras(String caCodigoBarras) {
		this.caCodigoBarras = caCodigoBarras;
	}

	public String getAnFiguraDetNomeArq() {
		return anFiguraDetNomeArq;
	}

	public void setAnFiguraDetNomeArq(String anFiguraDetNomeArq) {
		this.anFiguraDetNomeArq = anFiguraDetNomeArq;
	}

	public String getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	
	
}
