package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;

public class ReservarVagaEventoResponse implements Serializable {

	private String anTitulo;
	private String dtEvento;
	private String anFiguraDetNomeArq;
	private String anFiguraTmbNomeArq;
	private String anTrailer;
	private String cnMktEvtSeq;
	private String anClassifEtaria;
	private String nmAcomp;
	private String anLocal;
	private String anEndereco;
	private String cnReserva;
	private String anGenero;
	private String anSinopse;
	private String anObservacao;
	private String caAcaoPermitida;
	private ResultadoProcessamento resultadoProcessamento;
		
	public String getAnTitulo() {
		return anTitulo;
	}

	public void setAnTitulo(String anTitulo) {
		this.anTitulo = anTitulo;
	}

	public String getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(String dtEvento) {
		this.dtEvento = dtEvento;
	}

	public String getAnFiguraDetNomeArq() {
		return anFiguraDetNomeArq;
	}

	public void setAnFiguraDetNomeArq(String anFiguraDetNomeArq) {
		this.anFiguraDetNomeArq = anFiguraDetNomeArq;
	}

	public String getAnFiguraTmbNomeArq() {
		return anFiguraTmbNomeArq;
	}

	public void setAnFiguraTmbNomeArq(String anFiguraTmbNomeArq) {
		this.anFiguraTmbNomeArq = anFiguraTmbNomeArq;
	}

	public String getAnTrailer() {
		return anTrailer;
	}

	public void setAnTrailer(String anTrailer) {
		this.anTrailer = anTrailer;
	}

	public String getCnMktEvtSeq() {
		return cnMktEvtSeq;
	}

	public void setCnMktEvtSeq(String cnMktEvtSeq) {
		this.cnMktEvtSeq = cnMktEvtSeq;
	}

	public String getAnClassifEtaria() {
		return anClassifEtaria;
	}

	public void setAnClassifEtaria(String anClassifEtaria) {
		this.anClassifEtaria = anClassifEtaria;
	}

	public String getNmAcomp() {
		return nmAcomp;
	}

	public void setNmAcomp(String nmAcomp) {
		this.nmAcomp = nmAcomp;
	}

	public String getAnLocal() {
		return anLocal;
	}

	public void setAnLocal(String anLocal) {
		this.anLocal = anLocal;
	}

	public String getAnEndereco() {
		return anEndereco;
	}

	public void setAnEndereco(String anEndereco) {
		this.anEndereco = anEndereco;
	}

	public String getCnReserva() {
		return cnReserva;
	}

	public void setCnReserva(String cnReserva) {
		this.cnReserva = cnReserva;
	}

	public String getAnGenero() {
		return anGenero;
	}

	public void setAnGenero(String anGenero) {
		this.anGenero = anGenero;
	}

	public String getAnSinopse() {
		return anSinopse;
	}

	public void setAnSinopse(String anSinopse) {
		this.anSinopse = anSinopse;
	}

	public String getAnObservacao() {
		return anObservacao;
	}

	public void setAnObservacao(String anObservacao) {
		this.anObservacao = anObservacao;
	}

	public String getCaAcaoPermitida() {
		return caAcaoPermitida;
	}

	public void setCaAcaoPermitida(String caAcaoPermitida) {
		this.caAcaoPermitida = caAcaoPermitida;
	}

	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}

	public void setResultadoProcessamento(
			ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}

}