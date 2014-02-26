package br.com.vivovaloriza.mobile.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import br.com.vivovaloriza.mobile.util.Constantes;
import br.com.vivovaloriza.mobile.integration.response.AutenticarParticipanteResponse;
import br.com.vivovaloriza.mobile.integration.response.ReservarVagaEventoResponse;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class IngressosGratisReservarAction extends ActionSupport {

	public IngressosGratisReservarAction() {
    }

	private String anNome;
	private String anTitulo;
    private String dtEvento;
    private String anFiguraDetNomeArq;
    private String anFiguraTmbNomeArq;
    private String anTrailer;
    private String cnMktEvtSeq;
    private String anClassifEtaria;
    private String nmAcomp;
    private String anLocal;
    private String anEndereco;
    private String cnReserva;
    private String anGenero;
    private String anSinopse;
    private String anObservacao;
    private String caMktEvtCod;
    private String caTpEvento;
	private String anMensagemAlerta;

    public String execute() {

    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String IMAGEM_URL = request.getSession().getServletContext().getInitParameter("imagem.url")+"eventos/";
    	String actionName = ActionContext.getContext().getName();

    	HttpSession session = request.getSession();
		AutenticarParticipanteResponse autenticarParticipanteResponse = (AutenticarParticipanteResponse) session.getAttribute(Constantes.BEAN_PARTICIPANTE_AUTENTICADO);

		setAnNome( autenticarParticipanteResponse.getAnNome() ); 

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
			"<anTitulo>TARDE DE PALHAÇADAS</anTitulo>" +
			"<dtEvento>2014-02-07 21:00:00</dtEvento>" +
			"<anFiguraDetNomeArq></anFiguraDetNomeArq>" +
			"<anFiguraTmbNomeArq></anFiguraTmbNomeArq>" +
			"<anTrailer>http://www.inhotim.org.br/</anTrailer>" +
			"<cnMktEvtSeq>1</cnMktEvtSeq>" +
			"<anClassifEtaria>10 anos</anClassifEtaria>" +
			"<nmAcomp>1</nmAcomp>" +
			"<anLocal>TEATRO ALFREDO MESQUITA</anLocal>" +
			"<anEndereco>AV SANTOS DUMONT, 1770, SANTANA - SAO PAULO, CEP: 02012-010</anEndereco>" +
			"<cnReserva>123</cnReserva>" +
			"<anGenero>DRAMA</anGenero>" +
			"<anSinopse>Fruto de uma pesquisa de vinte anos e criado por Jairo Mattos, o espetáculo presta uma justa homenagem aos palhaços brasileiros. Com números clássicos de palhaços circenses, inspirados em nomes como Arrelia, Fuzarca, Torresmo, Carequinha, o espetáculo foi todo formatado para obter a total interatividade do público, tanto nos números de platéia, quanto na convocação, pelo elenco, da participação das crianças com perguntas, gestos e músicas.</anSinopse>" +
			"<anObservacao>RECOMENDAMOS RETIRAR SEUS INGRESSOS COM 45 MINUTOS DE ANTECEDÊNCIA. CASO VOCÊ NÃO ESTEJA PRESENTE ATÉ 30 MINUTOS ANTES DO INICIO DO ESPETÁCULO, OS SEUS LUGARES FICARÃO SUJEITOS A LOTAÇÃO DA SALA."+(char)10+"Estacionamento por conta do assinante."+(char)10+"Venda de ingressos extras no local."+(char)10+"Não será permitida a entrada após o início do espetáculo."+(char)10+"É OBRIGATÓRIA A APRESENTAÇÃO DA PÁGINA DE CONFIRMAÇÃO DE RESERVA IMPRESSA.</anObservacao>" +
			"<caAcaoPermitida>RESERVAR</caAcaoPermitida>" +
			"<resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta>Reserva realizada com sucesso!</anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ReservarVagaEventoResponse.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);

		ReservarVagaEventoResponse reservarVagaEventoResponse = (ReservarVagaEventoResponse) xStream.fromXML(xml);

		setAnTitulo( reservarVagaEventoResponse.getAnTitulo() );
		setDtEvento( reservarVagaEventoResponse.getDtEvento() );
	    setAnFiguraDetNomeArq( IMAGEM_URL + reservarVagaEventoResponse.getAnFiguraDetNomeArq() );
	    setAnFiguraTmbNomeArq( IMAGEM_URL + reservarVagaEventoResponse.getAnFiguraTmbNomeArq() );
	    setAnTrailer( reservarVagaEventoResponse.getAnTrailer() );
	    setCnMktEvtSeq( reservarVagaEventoResponse.getCnMktEvtSeq() );
	    setAnClassifEtaria( reservarVagaEventoResponse.getAnClassifEtaria() );
	    setNmAcomp( reservarVagaEventoResponse.getNmAcomp() );
	    setAnLocal( reservarVagaEventoResponse.getAnLocal() );
	    setAnEndereco( reservarVagaEventoResponse.getAnEndereco() );
	    setCnReserva( reservarVagaEventoResponse.getCnReserva() );
	    setAnGenero( reservarVagaEventoResponse.getAnGenero() );
	    setAnSinopse( reservarVagaEventoResponse.getAnSinopse() );
	    setAnObservacao( reservarVagaEventoResponse.getAnObservacao() );
		
		setAnMensagemAlerta( reservarVagaEventoResponse.getResultadoProcessamento().getAnMensagemAlerta() ); 
		
    	return "SUCCESS";
	}

	public String getAnMensagemAlerta() {
		return anMensagemAlerta;
	}

	public void setAnMensagemAlerta(String anMensagemAlerta) {
		this.anMensagemAlerta = anMensagemAlerta;
	}

	public String getAnTitulo() {
		return anTitulo;
	}

	public void setAnTitulo(String anTitulo) {
		this.anTitulo = anTitulo;
	}

	public String getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(String dtEvento) {
		SimpleDateFormat sdf_xml = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf_data = new SimpleDateFormat("dd/MM/yyyy");  			
		SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm");  			

		try {
			Date date = sdf_xml.parse( dtEvento );
			dtEvento = sdf_data.format(date)+ " às "+sdf_time.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		this.dtEvento = dtEvento;
	}

	public String getAnFiguraDetNomeArq() {
		return anFiguraDetNomeArq;
	}

	public void setAnFiguraDetNomeArq(String anFiguraDetNomeArq) {
		this.anFiguraDetNomeArq = anFiguraDetNomeArq;
	}

	public String getAnFiguraTmbNomeArq() {
		return anFiguraTmbNomeArq;
	}

	public void setAnFiguraTmbNomeArq(String anFiguraTmbNomeArq) {
		this.anFiguraTmbNomeArq = anFiguraTmbNomeArq;
	}

	public String getAnTrailer() {
		return anTrailer;
	}

	public void setAnTrailer(String anTrailer) {
		this.anTrailer = anTrailer;
	}

	public String getCnMktEvtSeq() {
		return cnMktEvtSeq;
	}

	public void setCnMktEvtSeq(String cnMktEvtSeq) {
		this.cnMktEvtSeq = cnMktEvtSeq;
	}

	public String getAnClassifEtaria() {
		return anClassifEtaria;
	}

	public void setAnClassifEtaria(String anClassifEtaria) {
		this.anClassifEtaria = anClassifEtaria;
	}

	public String getNmAcomp() {
		return nmAcomp;
	}

	public void setNmAcomp(String nmAcomp) {
		this.nmAcomp = nmAcomp;
	}

	public String getAnLocal() {
		return anLocal;
	}

	public void setAnLocal(String anLocal) {
		this.anLocal = anLocal;
	}

	public String getAnEndereco() {
		return anEndereco;
	}

	public void setAnEndereco(String anEndereco) {
		this.anEndereco = anEndereco;
	}

	public String getCnReserva() {
		return cnReserva;
	}

	public void setCnReserva(String cnReserva) {
		this.cnReserva = cnReserva;
	}

	public String getAnGenero() {
		return anGenero;
	}

	public void setAnGenero(String anGenero) {
		this.anGenero = anGenero;
	}

	public String getAnSinopse() {
		return anSinopse;
	}

	public void setAnSinopse(String anSinopse) {
		this.anSinopse = anSinopse;
	}

	public String getAnObservacao() {
		return anObservacao;
	}

	public void setAnObservacao(String anObservacao) {
		this.anObservacao = anObservacao;
	}

	public String getCaMktEvtCod() {
		return caMktEvtCod;
	}

	public void setCaMktEvtCod(String caMktEvtCod) {
		this.caMktEvtCod = caMktEvtCod;
	}

	public String getCaTpEvento() {
		return caTpEvento;
	}

	public void setCaTpEvento(String caTpEvento) {
		this.caTpEvento = caTpEvento;
	}

	public String getAnNome() {
		return anNome;
	}

	public void setAnNome(String anNome) {
		this.anNome = anNome;
	}
	
}
