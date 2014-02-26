package br.com.vivovaloriza.mobile.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jsoup.Jsoup;

import br.com.vivovaloriza.mobile.integration.response.ListarEspetaculosDescontoResponse;
import br.com.vivovaloriza.mobile.integration.vo.EspetaculoDescontoVO;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaEspetaculosDescontoVO;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class EspetaculosDescontoListarAction extends ActionSupport {

	List<EspetaculoDescontoVO> especatuloDesconto;
	
    public EspetaculosDescontoListarAction() {
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
			xml = "<"+actionName+"Response><itens>" +
					"<item><cnSeq>1</cnSeq><anTitulo>Espetaculo 1</anTitulo><anSubTitulo>...</anSubTitulo><anDesc>TESTE LOCALO</anDesc><anImagem></anImagem><dtInicio>01/12/2013</dtInicio><dtFim>31/12/2013</dtFim><boAcessoAssinante>S</boAcessoAssinante><nmOrdem>1</nmOrdem><caOprAlt>A0000</caOprAlt></item>" +
					"<item><cnSeq>2</cnSeq><anTitulo>Espetaculo 2</anTitulo><anSubTitulo>...</anSubTitulo><anDesc>TESTE LOCALO</anDesc><anImagem></anImagem><dtInicio>01/11/2013</dtInicio><dtFim>31/01/2014</dtFim><boAcessoAssinante>S</boAcessoAssinante><nmOrdem>1</nmOrdem><caOprAlt>A0000</caOprAlt></item>" +
					"</itens><resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ListarEspetaculosDescontoResponse.class);
		xStream.alias("itens", ListaEspetaculosDescontoVO.class);
		xStream.alias("item", EspetaculoDescontoVO.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);
		xStream.addImplicitCollection(ListaEspetaculosDescontoVO.class, "list");

		ListarEspetaculosDescontoResponse listarEspetaculosDescontoResponse = (ListarEspetaculosDescontoResponse) xStream.fromXML(xml);

        setEspecatuloDesconto( listarEspetaculosDescontoResponse.getItens().getList() , IMAGEM_URL  );
    	
    	return "SUCCESS";
	}

	public List<EspetaculoDescontoVO> getEspecatuloDesconto() {
		return especatuloDesconto;
	}

	public void setEspecatuloDesconto(List<EspetaculoDescontoVO> list , String IMAGEM_URL) {
		
		String anImagem = null;
		
		for (int i = 0; i < list.size() ; i++) {
			//PROD: http://www.tvantagens.com.br/estatico/imagens/teatro/atormentada.jpg
			//DESE: http://10.129.112.122/tvantagens/estatico/imagens/teatro/atormentada.jpg
			anImagem = IMAGEM_URL + list.get(i).getAnImagem(); 
			list.get(i).setAnImagem( anImagem );

			list.get(i).setAnTitulo( list.get(i).getAnTitulo() );
			list.get(i).setAnSubTitulo( list.get(i).getAnSubTitulo() );
			list.get(i).setAnDesc( list.get(i).getAnDesc() );
		}
		
		this.especatuloDesconto = list;
	}
	
    
    
}
