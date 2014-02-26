package br.com.vivovaloriza.mobile.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jsoup.Jsoup;

import br.com.vivovaloriza.mobile.integration.response.ObterParceiroRegulamentoResponse;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ParceiroExibirAction extends ActionSupport {

	private String cnParceiro;    
	private String anParceiro;    
	private String anLegenda;    
	private String anRegulamento;    
	private String anFiguraDetNomeArq;
	private String caCategoria;
	private String boExibeRegulamento;

	public ParceiroExibirAction() {
    }
    
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String IMAGEM_URL = request.getSession().getServletContext().getInitParameter("imagem.url") + "parceiros/";
    	String actionName = ActionContext.getContext().getName();

    	GenericoWS generico = new GenericoWS( actionName );

    	//Enumeration enumeration = request.getParameterNames();
    	//while (enumeration.hasMoreElements()) {
    	//  String parameterName = (String) enumeration.nextElement();
        //generico.incluirTag("cnParceiro", request.getParameter(parameterName) );
    	setBoExibeRegulamento(request.getParameter("boExibeRegulamento")); 
    	setCaCategoria(request.getParameter("caCategoria")); 

    	setCnParceiro(request.getParameter("cnParceiro")); 
        generico.incluirTag("cnParceiro", getCnParceiro() );
       	//}
		String xmlChamada = generico.formatarChamada();

		String xml = "";
		if(SOAP_URL.equals("LOCAL")) {
			xml = "<"+actionName+"Response><anParceiro>Parceiro 1</anParceiro><anLegenda>50% de <strong>desconto</strong> é d+</anLegenda><anRegulamento>TESTE LOCALO</anRegulamento><anFiguraDetNomeArq></anFiguraDetNomeArq>" +
					"<resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ObterParceiroRegulamentoResponse.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);

		ObterParceiroRegulamentoResponse obterParceiroRegulamentoResponse = (ObterParceiroRegulamentoResponse) xStream.fromXML(xml);

		setAnParceiro( obterParceiroRegulamentoResponse.getAnParceiro() );
		setAnLegenda( obterParceiroRegulamentoResponse.getAnLegenda() );
		setAnRegulamento( obterParceiroRegulamentoResponse.getAnRegulamento() );
		setAnFiguraDetNomeArq( IMAGEM_URL + obterParceiroRegulamentoResponse.getAnFiguraDetNomeArq() );

    	return "SUCCESS";
	}

	public String getCnParceiro() {
		return cnParceiro;
	}

	public void setCnParceiro(String cnParceiro) {
		this.cnParceiro = cnParceiro;
	}

	public String getAnParceiro() {
		return anParceiro;
	}

	public void setAnParceiro(String anParceiro) {
		this.anParceiro = Jsoup.parse(anParceiro).text();
	}

	public String getAnLegenda() {
		return anLegenda;
	}

	public void setAnLegenda(String anLegenda) {
		this.anLegenda = Jsoup.parse(anLegenda).text();
	}

	public String getAnRegulamento() {
		return anRegulamento;
	}

	public void setAnRegulamento(String anRegulamento) {
		if(this.boExibeRegulamento.equals("N")){
			anRegulamento = "";
		} else { 
			anRegulamento = Jsoup.parse(anRegulamento).text();
		}
		this.anRegulamento = anRegulamento;
	}

	public String getAnFiguraDetNomeArq() {
		return anFiguraDetNomeArq;
	}

	public void setAnFiguraDetNomeArq(String anFiguraDetNomeArq) {
		this.anFiguraDetNomeArq = anFiguraDetNomeArq;
	}

	public String getCaCategoria() {
		return caCategoria;
	}

	public void setCaCategoria(String caCategoria) {
		this.caCategoria = caCategoria;
	}

	public String getBoExibeRegulamento() {
		return boExibeRegulamento;
	}

	public void setBoExibeRegulamento(String boExibeRegulamento) {
		this.boExibeRegulamento = boExibeRegulamento;
	}
	
	

}
