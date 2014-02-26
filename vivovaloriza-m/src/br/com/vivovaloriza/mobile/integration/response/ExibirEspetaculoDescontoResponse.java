package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import org.jsoup.Jsoup;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;

public class ExibirEspetaculoDescontoResponse implements Serializable {

    private String cnSeq;
    private String anTitulo;
    private String anSubTitulo;
    private String anDesc;
    private String anImagem;
	private ResultadoProcessamento resultadoProcessamento;

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
	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}
	
}