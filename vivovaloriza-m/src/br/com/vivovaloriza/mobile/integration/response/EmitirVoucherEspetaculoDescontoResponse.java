package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import org.jsoup.Jsoup;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;

public class EmitirVoucherEspetaculoDescontoResponse implements Serializable {

    private String anNome;
    private String dtVoucher;
    private String cnVoucher;
    private String anCodigoBarra;
    private String anTitulo;
    private String anSubTitulo;
    private String anDesc;
    private String anImagem;
	private ResultadoProcessamento resultadoProcessamento;
		
	public String getAnNome() {
		return anNome;
	}
	public void setAnNome(String anNome) {
		this.anNome = Jsoup.parse(anNome).text();
	}
	public String getDtVoucher() {
		return dtVoucher;
	}
	public void setDtVoucher(String dtVoucher) {
		this.dtVoucher = dtVoucher;
	}
	public String getCnVoucher() {
		return cnVoucher;
	}
	public void setCnVoucher(String cnVoucher) {
		this.cnVoucher = cnVoucher;
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
	public String getAnCodigoBarra() {
		return anCodigoBarra;
	}
	public void setAnCodigoBarra(String anCodigoBarra) {
		this.anCodigoBarra = anCodigoBarra;
	}
	
	
	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}
	
	
}
