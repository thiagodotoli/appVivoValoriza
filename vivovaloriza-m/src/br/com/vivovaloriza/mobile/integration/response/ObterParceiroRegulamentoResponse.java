package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import org.jsoup.Jsoup;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;

public class ObterParceiroRegulamentoResponse implements Serializable {

	private String anParceiro;    
	private String anLegenda;    
	private String anRegulamento;    
	private String anFiguraDetNomeArq;
	private ResultadoProcessamento resultadoProcessamento;
	
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
		this.anRegulamento = Jsoup.parse(anRegulamento).text();
	}
	public String getAnFiguraDetNomeArq() {
		return anFiguraDetNomeArq;
	}
	public void setAnFiguraDetNomeArq(String anFiguraDetNomeArq) {
		this.anFiguraDetNomeArq = anFiguraDetNomeArq;
	}
	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(
			ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}


	
}