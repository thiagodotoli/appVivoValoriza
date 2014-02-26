package br.com.vivovaloriza.mobile.integration.vo;

import java.io.Serializable;

public class IngressoGratisVO implements Serializable {

	private String caMktEvtCod;    
	private String anTitulo;    
	private String dtEvento;    
	private String anFiguraDetNomeArq;
	private String anFiguraTmbNomeArq;
	private String caAcaoPermitida;
	private String caChave;

	public String getCaMktEvtCod() {
		return caMktEvtCod;
	}
	public void setCaMktEvtCod(String caMktEvtCod) {
		this.caMktEvtCod = caMktEvtCod;
	}
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
	public String getCaAcaoPermitida() {
		return caAcaoPermitida;
	}
	public void setCaAcaoPermitida(String caAcaoPermitida) {
		this.caAcaoPermitida = caAcaoPermitida;
	}
	public String getCaChave() {
		return caChave;
	}
	public void setCaChave(String caChave) {
		this.caChave = caChave;
	}

	
}