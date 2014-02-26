package br.com.vivovaloriza.mobile.integration.vo;

import java.io.Serializable;

import org.jsoup.Jsoup;

public class ParceiroVO implements Serializable {

	private String cnParceiro;    
	private String anNome;    
	private String anLegenda;    
	private String anUrlWebsite;
	private String boAbrirUrlJanelaSeparada;
	private String anFiguraDetNomeArq;
	private String boExibeUrlWebsite;
	private String boExibeRegulamento;
	private String boExibeVoucher;

	public String getCnParceiro() {
		return cnParceiro;
	}
	public void setCnParceiro(String cnParceiro) {
		this.cnParceiro = cnParceiro;
	}
	public String getAnNome() {
		return anNome;
	}
	public void setAnNome(String anNome) {
		this.anNome = Jsoup.parse(anNome).text();
	}
	public String getAnLegenda() {
		return anLegenda;
	}
	public void setAnLegenda(String anLegenda) {
		this.anLegenda = Jsoup.parse(anLegenda).text();
	}
	public String getAnUrlWebsite() {
		return anUrlWebsite;
	}
	public void setAnUrlWebsite(String anUrlWebsite) {
		this.anUrlWebsite = anUrlWebsite;
	}
	public String getAnFiguraDetNomeArq() {
		return anFiguraDetNomeArq;
	}
	public void setAnFiguraDetNomeArq(String anFiguraDetNomeArq) {
		this.anFiguraDetNomeArq = anFiguraDetNomeArq;
	}
	public String getBoExibeUrlWebsite() {
		return boExibeUrlWebsite;
	}
	public void setBoExibeUrlWebsite(String boExibeUrlWebsite) {
		this.boExibeUrlWebsite = boExibeUrlWebsite;
	}
	public String getBoExibeRegulamento() {
		return boExibeRegulamento;
	}
	public void setBoExibeRegulamento(String boExibeRegulamento) {
		this.boExibeRegulamento = boExibeRegulamento;
	}
	public String getBoExibeVoucher() {
		return boExibeVoucher;
	}
	public void setBoExibeVoucher(String boExibeVoucher) {
		this.boExibeVoucher = boExibeVoucher;
	}

	public String getBoAbrirUrlJanelaSeparada() {
		return boAbrirUrlJanelaSeparada;
	}
	public void setBoAbrirUrlJanelaSeparada(String boAbrirUrlJanelaSeparada) {
		this.boAbrirUrlJanelaSeparada = boAbrirUrlJanelaSeparada;
	}
	
	
}