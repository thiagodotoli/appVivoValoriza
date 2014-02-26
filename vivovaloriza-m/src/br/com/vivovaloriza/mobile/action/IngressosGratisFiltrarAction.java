package br.com.vivovaloriza.mobile.action;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import br.com.vivovaloriza.mobile.integration.response.ListarDominioResponse;
import br.com.vivovaloriza.mobile.integration.vo.DominioVO;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaDominioVO;
import br.com.vivovaloriza.mobile.util.GenericoWS;

public class IngressosGratisFiltrarAction {
	
	List<DominioVO> tipos;

	public IngressosGratisFiltrarAction() {
	}
	
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String actionName = "obterListaDominio";

    	GenericoWS generico = new GenericoWS( actionName );
    	generico.incluirTag("caTpDom", "CA_TP_EVENTO" );
    	generico.incluirTag("nmVar1", "1" );
		String xmlChamada = generico.formatarChamada();

		String xml = "";
		if(SOAP_URL.equals("LOCAL")) {
			xml = "<"+actionName+"Response><itens>" +
					"<item><caDom>PCT</caDom><anDescr>Peça-Teatral</anDescr><anVar1></anVar1><anVar2></anVar2><nmVar1></nmVar1><nmVar2></nmVar2><dtVar1></dtVar1><dtVar2></dtVar2></item>" +
					"<item><caDom>PRE</caDom><anDescr>Pré-Estréia</anDescr><anVar1></anVar1><anVar2></anVar2><nmVar1></nmVar1><nmVar2></nmVar2><dtVar1></dtVar1><dtVar2></dtVar2></item>" +
					"</itens><resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_TVG_RESP_XML_DOM_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ListarDominioResponse.class);
		xStream.alias("itens", ListaDominioVO.class);
		xStream.alias("item", DominioVO.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);
		xStream.addImplicitCollection(ListaDominioVO.class, "list");

		ListarDominioResponse listarDominioResponse = (ListarDominioResponse) xStream.fromXML(xml);

		setTipos( listarDominioResponse.getItens().getList() );
    	
    	return "SUCCESS";
	}

	public List<DominioVO> getTipos() {
		return tipos;
	}

	public void setTipos(List<DominioVO> tipos) {
		this.tipos = tipos;
	}


}
