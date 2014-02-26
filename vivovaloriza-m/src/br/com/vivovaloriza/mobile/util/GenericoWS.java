package br.com.vivovaloriza.mobile.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class GenericoWS extends HttpServlet {
	
	private String nomeChamada;
	private List<String> tagNome;
	private List<String> tagConteudo;

    public GenericoWS(String nomeChamada) {
    	setNomeChamada(nomeChamada);
    	this.tagNome = new ArrayList<String>();
    	this.tagConteudo = new ArrayList<String>();
    }

	public void incluirTag(String tagNome , String conteudo) {
		this.tagNome.add(tagNome);
		this.tagConteudo.add(conteudo);
	}

    public String getNomeChamada() {
    	return this.nomeChamada;
    }

    public void setNomeChamada(String nomeChamada) {
    	this.nomeChamada = nomeChamada.trim();
    }

	public String formatarChamada() {
		
		String xml = "<"+getNomeChamada()+">"; 
		for (int i = 0; i < this.tagNome.size(); i++) {
			if (this.tagConteudo.get(i)!=null) { 
				xml = xml + "<"+this.tagNome.get(i)+">";
				xml = xml + this.tagConteudo.get(i);
				xml = xml + "</"+this.tagNome.get(i)+">";
			}
		}
		
		xml = xml + "</"+this.nomeChamada+">";
		return xml;
	}
	
	public static String executar(String URL,String chamadaXml) {

		//String chamadaXml = formatarChamada();
    	String xml = null;

		try {
			//String URL = "http://10.129.112.122:8080/servicebus/services/Generico";
			//String URL = "http://sitetva.ajato.com.br/servicebus/services/Generico";  // Producao

			// Namespace e nome para o objeto SOAP
			// Obter do WSDL. Ex.: http://sitetva.ajato.com.br/servicebus/services/Generico?wsdl
			// No nosso caso, NAMESPACE=gnws e Método=executar
			SoapObject soap = new SoapObject("gnws", "executar");

			// Esse método "executar" tem 04 parâmetros (ver pág. 10 do manual)
			// Nesse exemplo vou utilizar dados inválidos, só para obtermos uma resposta

			// Adiciona os parâmetros (no nosso caso, apenas um texto XML)
			soap.addProperty("in0", 60);
			soap.addProperty("in1", "tvantagensreport");
			soap.addProperty("in2", "1v4n1483n5@r3p0rt");
			soap.addProperty("in3", chamadaXml );

			// Cria o envelope com o objeto SOAP
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.setOutputSoapObject(soap);

			// Cria o HttpTransport para enviar os dados (SOAP)
			HttpTransportSE httpTransport = new HttpTransportSE(URL);

			// Faz a requisição
			httpTransport.call("", envelope);

			// Recupera o resultado
			Object resposta = envelope.getResponse();
			xml = resposta.toString();
/*
			XStream xStream = new XStream(new Dom4JDriver());
            xStream.alias("enderecos", ArrayList.class);
            xStream.alias("endereco", EnderecoImportVO.class);

            ArrayList<EnderecoImportVO> enderecos = (ArrayList) xStream.fromXML(xml);

            for (EnderecoImportVO enderecoImportVo : enderecos) {

            	EnderecoVO enderecoVo = new EnderecoVO(); 
            	PredioVO predioVo = new PredioVO(); 
            	DomicilioVO domicilioVo = new DomicilioVO();

            	enderecoVo.setEndCod            (Integer.parseInt(enderecoImportVo.getEndCod()));
            	enderecoVo.setLogrTp            (enderecoImportVo.getLogrTp());
            	enderecoVo.setLogrCod           (Integer.parseInt(enderecoImportVo.getLogrCod()));
            	enderecoVo.setLogrNom           (enderecoImportVo.getLogrNom());
            	enderecoVo.setEndNum            (Integer.parseInt(enderecoImportVo.getEndLogrNro()));
            	enderecoVo.setEndCep            (enderecoImportVo.getEndCepNum());
            	enderecoVo.setBairrNom          (enderecoImportVo.getBairrNom());
            	enderecoVo.setUfCod             (enderecoImportVo.getUfCod());
            	enderecoVo.setCidNom            (enderecoImportVo.getCidNom());

            	predioVo.setPrdSeq              (Integer.parseInt(enderecoImportVo.getPrdSeq()));
            	predioVo.setPrdNom              (enderecoImportVo.getPrdNome());
            	predioVo.setPrdBlcNom           (enderecoImportVo.getPrdBlcNom());

            	domicilioVo.setEndCod            (Integer.parseInt(enderecoImportVo.getEndCod()));
            	domicilioVo.setPrdSeq            (Integer.parseInt(enderecoImportVo.getPrdSeq()));
            	domicilioVo.setDomCod            (Integer.parseInt(enderecoImportVo.getDomCod()));
            	domicilioVo.setDomNum            (enderecoImportVo.getApto());
            	domicilioVo.setDomCompl          (enderecoImportVo.getCaCompl1());            	
            	domicilioVo.setDomCttTpPessoa    (enderecoImportVo.getCaTpPessoa());
            	domicilioVo.setDomCttNom         (enderecoImportVo.getAnNome());
            	domicilioVo.setDomCttSexo        (enderecoImportVo.getCaSexo());
            	domicilioVo.setDomCttTpDoc       (enderecoImportVo.getCaTpDoc());
            	domicilioVo.setDomCttDoc         (enderecoImportVo.getCaDoc());
            	domicilioVo.setCnIdAssinatura    (enderecoImportVo.getCnIdAssinatura());
            	domicilioVo.setCnAssinante       (Integer.parseInt(enderecoImportVo.getCnAssinante()));
            	domicilioVo.setProduto           (enderecoImportVo.getProduto());
            	domicilioVo.setTecnologia        (enderecoImportVo.getTecnologia());
            	domicilioVo.setCnVendedor        (enderecoImportVo.getCnVendedor());
            	domicilioVo.setCaOpr             (enderecoImportVo.getCaOpr());
            	domicilioVo.setCaCanalVenda      (enderecoImportVo.getCaCanalVenda());
            	domicilioVo.setCaArea            (enderecoImportVo.getCaArea());
            	domicilioVo.setAssSts            (enderecoImportVo.getAssSts());
            	domicilioVo.setAssTp             (enderecoImportVo.getAssTp());
            	domicilioVo.setTransmissao       (enderecoImportVo.getTransmissao());
            	domicilioVo.setCaTpImov          (enderecoImportVo.getCaTpImov());
            	domicilioVo.setCaTpNode          (enderecoImportVo.getCaTpNode());
            	domicilioVo.setCaSistDistrPtv    (enderecoImportVo.getCaSistDistrPtv());
            	domicilioVo.setCaSistDistrIntInd (enderecoImportVo.getCaSistDistrIntInd());

            	try {
            		domicilioVo.setDomCttDdd1 (Integer.parseInt(enderecoImportVo.getDddTelPrinc()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDomCttFone1 (Integer.parseInt(enderecoImportVo.getTelPrinc()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDomCttDdd2 (Integer.parseInt(enderecoImportVo.getDddCel1()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDomCttFone2 (Integer.parseInt(enderecoImportVo.getTelCel1()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDomCttDdd3 (Integer.parseInt(enderecoImportVo.getDddCel2()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDomCttFone3 (Integer.parseInt(enderecoImportVo.getTelCel2()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDomCttDdd4 (Integer.parseInt(enderecoImportVo.getDddTelCom()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDomCttFone4 (Integer.parseInt(enderecoImportVo.getTelCom()));
            	}catch (Exception e) {}
            	try {
            		domicilioVo.setDtCadastro (new Timestamp(sdf.parse(enderecoImportVo.getDtCadastro()).getTime()));
				} catch (Exception e) {}
            	try {
            		domicilioVo.setDtAgendamento (new Timestamp(sdf.parse(enderecoImportVo.getDtAgendamento()).getTime()));
				} catch (Exception e) {}
            	try {
            		domicilioVo.setDtLibSistDistrPtv (new Timestamp(sdf.parse(enderecoImportVo.getDtLibSistDistrPtv()).getTime()));
				} catch (Exception e) {}
            	try {
            		domicilioVo.setDtLibSistDistrIntInd (new Timestamp(sdf.parse(enderecoImportVo.getDtLibSistDistrIntInd()).getTime()));
				} catch (Exception e) {}

				new Endereco().incluir(enderecoVo);
				new Predio().incluir(predioVo);
				new Domicilio().incluir(domicilioVo);

				System.out.println(domicilioVo.getDomCttNom());
            }
*/

		} catch (Exception e) {
			System.out.println(e);
		}
		return xml;
	}

}