package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import org.jsoup.Jsoup;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;

public class ObterParceiroVoucherResponse implements Serializable {

	private String cnRelacionamento;    
	private String anNome;    
	private String anParceiro;    
	private String anLegenda;    
	private String dtIniVoucher;    
	private String dtFimVoucher;    
	private String caCodigoBarras;
	private String anFiguraDetNomeArq;
	private String dtEmissao;
	private ResultadoProcessamento resultadoProcessamento;

	public String getCnRelacionamento() {
		return cnRelacionamento;
	}
	public void setCnRelacionamento(String cnRelacionamento) {
		this.cnRelacionamento = cnRelacionamento;
	}
	public String getAnNome() {
		return anNome;
	}
	public void setAnNome(String anNome) {
		this.anNome = Jsoup.parse(anNome).text();
	}
	public String getAnParceiro() {
		return anParceiro;
	}
	public void setAnParceiro(String anParceiro) {
		this.anParceiro = Jsoup.parse(anParceiro).text();
	}
	public String getDtIniVoucher() {
		return dtIniVoucher;
	}
	public void setDtIniVoucher(String dtIniVoucher) {
		this.dtIniVoucher = dtIniVoucher;
	}
	public String getDtFimVoucher() {
		return dtFimVoucher;
	}
	public void setDtFimVoucher(String dtFimVoucher) {
		this.dtFimVoucher = dtFimVoucher;
	}
	public String getCaCodigoBarras() {
		return caCodigoBarras;
	}
	public void setCaCodigoBarras(String caCodigoBarras) {
		this.caCodigoBarras = caCodigoBarras;
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
	public String getAnLegenda() {
		return anLegenda;
	}
	public void setAnLegenda(String anLegenda) {
		this.anLegenda = anLegenda;
	}
	public String getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	
	
	
}