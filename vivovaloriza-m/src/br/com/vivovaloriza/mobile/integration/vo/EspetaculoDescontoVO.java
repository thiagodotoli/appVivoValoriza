package br.com.vivovaloriza.mobile.integration.vo;

import java.io.Serializable;

import org.jsoup.Jsoup;

public class EspetaculoDescontoVO implements Serializable {

	private String cnSeq;    
	private String anTitulo;    
	private String anSubTitulo;    
	private String anDesc;
	private String anImagem;
	private String dtInicio;
	private String dtFim;
	private String boAcessoAssinante;
	private String nmOrdem;
	private String caOprAlt;

	public String getCnSeq() {
		return cnSeq;
	}
	public void setCnSeq(String cnSeq) {
		this.cnSeq = cnSeq;
	}
	public String getAnTitulo() {
		return anTitulo;
	}
	public void setAnTitulo(String anTitulo) {
		this.anTitulo = Jsoup.parse(anTitulo).text();
	}
	public String getAnSubTitulo() {
		return anSubTitulo;
	}
	public void setAnSubTitulo(String anSubTitulo) {
		this.anSubTitulo = Jsoup.parse(anSubTitulo).text();
	}
	public String getAnDesc() {
		return anDesc;
	}
	public void setAnDesc(String anDesc) {
		this.anDesc = Jsoup.parse(anDesc).text();
	}
	public String getAnImagem() {
		return anImagem;
	}
	public void setAnImagem(String anImagem) {
		this.anImagem = anImagem;
	}
	public String getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}
	public String getDtFim() {
		return dtFim;
	}
	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}
	public String getBoAcessoAssinante() {
		return boAcessoAssinante;
	}
	public void setBoAcessoAssinante(String boAcessoAssinante) {
		this.boAcessoAssinante = boAcessoAssinante;
	}
	public String getNmOrdem() {
		return nmOrdem;
	}
	public void setNmOrdem(String nmOrdem) {
		this.nmOrdem = nmOrdem;
	}
	public String getCaOprAlt() {
		return caOprAlt;
	}
	public void setCaOprAlt(String caOprAlt) {
		this.caOprAlt = caOprAlt;
	}
	
	
}