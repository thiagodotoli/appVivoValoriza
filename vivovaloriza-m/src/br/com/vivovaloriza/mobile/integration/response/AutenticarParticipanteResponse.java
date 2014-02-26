package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaAutorizacoesVO;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaEspetaculosDescontoVO;

public class AutenticarParticipanteResponse implements Serializable {

	private String caDoc;    
	private String anNome;    
	private String dtUltimoAcesso;    

	private ListaAutorizacoesVO autorizacoes;

	private ResultadoProcessamento resultadoProcessamento;
		
	public String getCaDoc() {
		return caDoc;
	}
	public void setCaDoc(String caDoc) {
		this.caDoc = caDoc;
	}
	public String getAnNome() {
		return anNome;
	}
	public void setAnNome(String anNome) {
		this.anNome = anNome;
	}

	public String getDtUltimoAcesso() {
		return dtUltimoAcesso;
	}
	public void setDtUltimoAcesso(String dtUltimoAcesso) {
		this.dtUltimoAcesso = dtUltimoAcesso;
	}
	public ListaAutorizacoesVO getAutorizacoes() {
		return autorizacoes;
	}
	public void setAutorizacoes(ListaAutorizacoesVO autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(
			ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}
	
	
	
}