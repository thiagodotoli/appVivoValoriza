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

public class ParceiroCategoriasAction {
	
	List<DominioVO> categorias;

	public ParceiroCategoriasAction() {
	}
	
    public String execute() {
		
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String SOAP_URL = request.getSession().getServletContext().getInitParameter("soap.url");
    	String actionName = "obterListaDominio";

    	GenericoWS generico = new GenericoWS( actionName );
    	generico.incluirTag("caTpDom", "CA_CATEGORIA" );
		String xmlChamada = generico.formatarChamada();

		String xml = "";
		if(SOAP_URL.equals("LOCAL")) {
			xml = "<"+actionName+"Response><itens>" +
					"<item><caDom>BR</cnSeq><anDescr>Bares / Restaurantes</anDescr></item>" +
					"<item><caDom>CP</cnSeq><anDescr>Compras</anDescr></item>" +
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

		setCategorias( listarDominioResponse.getItens().getList() );
    	
    	return "SUCCESS";
	}

	public List<DominioVO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<DominioVO> categorias) {
		this.categorias = categorias;
	}


}
