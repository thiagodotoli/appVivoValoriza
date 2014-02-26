package br.com.vivovaloriza.mobile.action;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import br.com.vivovaloriza.mobile.integration.response.AutenticarParticipanteResponse;
import br.com.vivovaloriza.mobile.integration.response.ObterParceirosMuralResponse;
import br.com.vivovaloriza.mobile.integration.vo.ParceiroVO;
import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaParceirosVO;
import br.com.vivovaloriza.mobile.util.Constantes;
import br.com.vivovaloriza.mobile.util.GenericoWS;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ParceiroListarAction extends ActionSupport {

	private String caCategoria;
	List<ParceiroVO> parceiros;
	
    public ParceiroListarAction() {
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
			xml = "<"+actionName+"Response><itens>" +
					"<item><cnParceiro>1</cnParceiro><anNome>Parceiro 1</anNome><anLegenda>50% é <strong>desconto</strong> no site</anLegenda>       <anUrlWebsite>http://www.ETNA.com.br</anUrlWebsite>      <boAbrirUrlJanelaSeparada>S</boAbrirUrlJanelaSeparada><boExibeUrlWebsite>N</boExibeUrlWebsite><boExibeRegulamento>S</boExibeRegulamento><boExibeVoucher>N</boExibeVoucher><anFiguraDetNomeArq>parc0001-tmb.jpg</anFiguraDetNomeArq></item>" +
					"<item><cnParceiro>2</cnParceiro><anNome>Parceiro 2</anNome><anLegenda>Compre um lanche e ganhe outro</anLegenda><anUrlWebsite>http://www.burgerking.com.br</anUrlWebsite>                <boAbrirUrlJanelaSeparada>S</boAbrirUrlJanelaSeparada><boExibeUrlWebsite>S</boExibeUrlWebsite><boExibeRegulamento>N</boExibeRegulamento><boExibeVoucher>S</boExibeVoucher><anFiguraDetNomeArq>parc0002-tmb.jpg</anFiguraDetNomeArq></item>" +
					"<item><cnParceiro>3</cnParceiro><anNome>Parceiro 3</anNome><anLegenda>Promoção submarino</anLegenda><anUrlWebsite>http://www.submarino.com.br</anUrlWebsite>                             <boAbrirUrlJanelaSeparada>S</boAbrirUrlJanelaSeparada><boExibeUrlWebsite>N</boExibeUrlWebsite><boExibeRegulamento>N</boExibeRegulamento><boExibeVoucher>S</boExibeVoucher><anFiguraDetNomeArq>parc0002-tmb.jpg</anFiguraDetNomeArq></item>" +
					"<item><cnParceiro>4</cnParceiro><anNome>Parceiro 4</anNome><anLegenda>Promoção 3 submarino</anLegenda><anUrlWebsite>http://www.submarino.com.br</anUrlWebsite>                           <boAbrirUrlJanelaSeparada>S</boAbrirUrlJanelaSeparada><boExibeUrlWebsite>S</boExibeUrlWebsite><boExibeRegulamento>N</boExibeRegulamento><boExibeVoucher>N</boExibeVoucher><anFiguraDetNomeArq>parc0002-tmb.jpg</anFiguraDetNomeArq></item>" +
					"</itens><resultadoProcessamento><nmLinhasAfetadas>1</nmLinhasAfetadas><cnRetorno>0</cnRetorno><anDescricaoRetorno></anDescricaoRetorno><anMensagemAlerta></anMensagemAlerta><anProcedure>PRC_INT_REL_RESP_XML_LOCAL_LST</anProcedure><cnErroOracle>0</cnErroOracle><anErroOracle></anErroOracle></resultadoProcessamento></"+actionName+"Response>";				
		} else {					
			xml = GenericoWS.executar(SOAP_URL,xmlChamada);
		}

		XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias(actionName+"Response", ObterParceirosMuralResponse.class);
		xStream.alias("itens", ListaParceirosVO.class);
		xStream.alias("item", ParceiroVO.class);
		xStream.alias("resultadoProcessamento", ResultadoProcessamento.class);
		xStream.addImplicitCollection(ListaParceirosVO.class, "list");

		ObterParceirosMuralResponse obterParceirosMuralResponse = (ObterParceirosMuralResponse) xStream.fromXML(xml);
		
		setCaCategoria( obterParceirosMuralResponse.getCaCategoria() );
		setParceiros( obterParceirosMuralResponse.getItens().getList() , IMAGEM_URL  );
    	
    	return "SUCCESS";
	}

	public List<ParceiroVO> getParceiros() {
		return parceiros;
	}

	public void setParceiros(List<ParceiroVO> list , String IMAGEM_URL) {
		
		String anImagem, url = null;
		
		for (int i = 0; i < list.size() ; i++) {
			//PROD: http://www.tvantagens.com.br/estatico/imagens/teatro/atormentada.jpg
			//DESE: http://10.129.112.122/tvantagens/estatico/imagens/teatro/atormentada.jpg
			anImagem = IMAGEM_URL + list.get(i).getAnFiguraDetNomeArq(); 
			list.get(i).setAnFiguraDetNomeArq( anImagem );
		
			list.get(i).setAnNome( list.get(i).getAnNome() );
			list.get(i).setAnLegenda( list.get(i).getAnLegenda() );
			url = "obterParceiroRegulamento.action?cnParceiro="+list.get(i).getCnParceiro()+"&caCategoria="+getCaCategoria()+"&boExibeRegulamento="+list.get(i).getBoExibeRegulamento(); 
			
			if(list.get(i).getBoExibeVoucher().equals("N")){
				if(list.get(i).getBoExibeUrlWebsite().equals("S")){
					url = list.get(i).getAnUrlWebsite();
					list.get(i).setBoExibeVoucher("ir para o site");
					list.get(i).setBoExibeUrlWebsite("_blank");
				} else {
					list.get(i).setBoExibeVoucher("saiba mais");
					list.get(i).setAnUrlWebsite(url);
					list.get(i).setBoExibeUrlWebsite("");
				}
			} else {
				list.get(i).setBoExibeVoucher("emitir voucher");
				list.get(i).setBoExibeUrlWebsite("");
			}
			list.get(i).setAnUrlWebsite(url);
		
		}
		
		this.parceiros = list;
	}

	public String getCaCategoria() {
		return caCategoria;
	}

	public void setCaCategoria(String caCategoria) {
		this.caCategoria = caCategoria;
	}
    
}
