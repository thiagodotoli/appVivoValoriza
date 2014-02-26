package br.com.vivovaloriza.mobile.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jsoup.Jsoup;

import br.com.vivovaloriza.mobile.integration.response.AutenticarParticipanteResponse;
import br.com.vivovaloriza.mobile.integration.response.ObterEventosDisponiveisResponse;
import br.com.vivovaloriza.mobile.integration.vo.IngressoGratisVO;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaIngressosGratisVO;
import br.com.vivovaloriza.mobile.util.Constantes;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class IngressosGratisListarAction extends ActionSupport {
	
	private String caTpEvento;
	List<IngressoGratisVO> ingressosGratis;
	
    public IngressosGratisListarAction() {
    }
    
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String actionName = ActionContext.getContext().getName();

    	HttpSession session = request.getSession();
		AutenticarParticipanteResponse autenticarParticipanteResponse = (AutenticarParticipanteResponse) session.getAttribute(Constantes.BEAN_PARTICIPANTE_AUTENTICADO);
    	
    	GenericoWS generico = new GenericoWS( actionName );
    	generico.incluirTag("caDoc", autenticarParticipanteResponse.getCaDoc() );

    	setCaTpEvento( request.getParameter("caTpEvento") );
       	generico.incluirTag("caTpEvento", getCaTpEvento() );

    	/*Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = (String) enumeration.nextElement();
        	generico.incluirTag(parameterName, request.getParameter(parameterName) );
        }*/
		String xmlChamada = generico.formatarChamada();

		String xml = "";
		if(SOAP_URL.equals("LOCAL")) {
			xml = "<"+actionName+"Response><itens>" +
					"<item><caMktEvtCod>PRE00001</caMktEvtCod><anTitulo>TARDE DE PALHAÇADAS</anTitulo><dtEvento>2014-02-08 21:30:00</dtEvento><anFiguraDetNomeArq></anFiguraDetNomeArq><anFiguraTmbNomeArq></anFiguraTmbNomeArq><caAcaoPermitida>RESERVAR</caAcaoPermitida><caChave>3075a1e55c43381b6886b1adbb444318</caChave></item>" +
					"<item><caMktEvtCod>PCT00002</caMktEvtCod><anTitulo>Antes só do que mal casado</anTitulo><dtEvento>2014-02-07 21:00:00</dtEvento><anFiguraDetNomeArq></anFiguraDetNomeArq><anFiguraTmbNomeArq></anFiguraTmbNomeArq><caAcaoPermitida>CANCELAR</caAcaoPermitida><caChave>3075a1e55c43381b6886b1adbb444318</caChave></item>" +
					"<item><caMktEvtCod>PCT00003</caMktEvtCod><anTitulo>O SEGREDO DAS IRMÃS PERIGUETES</anTitulo><dtEvento>2014-02-07 21:00:00</dtEvento><anFiguraDetNomeArq></anFiguraDetNomeArq><anFiguraTmbNomeArq></anFiguraTmbNomeArq><caAcaoPermitida>ESGOTADO</caAcaoPermitida><caChave>3075a1e55c43381b6886b1adbb444318</caChave></item>" +
					"<item><caMktEvtCod>PCT00004</caMktEvtCod><anTitulo>QUEM RI POR ÚLTIMO É LOIRA OU PORTUGUÊS</anTitulo><dtEvento>2014-02-07 21:00:00</dtEvento><anFiguraDetNomeArq></anFiguraDetNomeArq><anFiguraTmbNomeArq></anFiguraTmbNomeArq><caAcaoPermitida>INDISPONIVEL</caAcaoPermitida><caChave>3075a1e55c43381b6886b1adbb444318</caChave></item>" +
					"</itens><resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ObterEventosDisponiveisResponse.class);
		xStream.alias("itens", ListaIngressosGratisVO.class);
		xStream.alias("item", IngressoGratisVO.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);
		xStream.addImplicitCollection(ListaIngressosGratisVO.class, "list");

		ObterEventosDisponiveisResponse obterEventosDisponiveisResponse = (ObterEventosDisponiveisResponse) xStream.fromXML(xml);
		setIngressosGratis( obterEventosDisponiveisResponse.getItens().getList() );
    	
    	return "SUCCESS";
	}

	public List<IngressoGratisVO> getIngressosGratis() {
		return ingressosGratis;
	}

	public void setIngressosGratis(List<IngressoGratisVO> list) {
		
		String caAcaoPermitida = "";
		String caChave = "";
		Date date = null;
		
		for (int i = 0; i < list.size(); i++) {
			caAcaoPermitida = list.get(i).getCaAcaoPermitida();
			
			if (caAcaoPermitida.equals("CANCELAR")) {
				caAcaoPermitida = "cancelar a reserva";
			} else if (caAcaoPermitida.equals("ENCERRADA")){
				caAcaoPermitida = "reservas encerradas"; 
			} else if (caAcaoPermitida.equals("FILA-ESPERAR")){
				caAcaoPermitida = "fila de espera"; 
			} else if (caAcaoPermitida.equals("FILA-SAIR")){
				caAcaoPermitida = "sair da fila"; 
			}

			list.get(i).setCaAcaoPermitida(caAcaoPermitida.toLowerCase());

			caChave = "obterDetalheEvento.action?caMktEvtCod="+list.get(i).getCaMktEvtCod()+"&caTpEvento="+getCaTpEvento()+"&caChave="+list.get(i).getCaChave();
			list.get(i).setCaChave(caChave);
			
			list.get(i).getDtEvento();

			try {
				SimpleDateFormat sdf_xml = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date = sdf_xml.parse( list.get(i).getDtEvento() );
				SimpleDateFormat sdf_data = new SimpleDateFormat("dd/MM/yyyy");  			
				SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm");  			
				list.get(i).setDtEvento("Em "+sdf_data.format(date)+ " às "+sdf_time.format(date) );

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		this.ingressosGratis = list;
	}

	public String getCaTpEvento() {
		return caTpEvento;
	}

	public void setCaTpEvento(String caTpEvento) {
		this.caTpEvento = caTpEvento;
	}

}