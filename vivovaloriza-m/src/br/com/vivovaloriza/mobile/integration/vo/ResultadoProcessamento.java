package br.com.vivovaloriza.mobile.integration.vo;

public class ResultadoProcessamento {

	private int nmLinhasAfetadas;
	private int cnRetorno;
	private String anDescricaoRetorno;
	private String anMensagemAlerta;
	private String anProcedure;
	private int cnErroOracle;
	private String anErroOracle;

   public int getNmLinhasAfetadas() {
		return nmLinhasAfetadas;
	}
	public void setNmLinhasAfetadas(int nmLinhasAfetadas) {
		this.nmLinhasAfetadas = nmLinhasAfetadas;
	}
	public int getCnRetorno() {
		return cnRetorno;
	}
	public void setCnRetorno(int cnRetorno) {
		this.cnRetorno = cnRetorno;
	}
	public String getAnDescricaoRetorno() {
		return anDescricaoRetorno;
	}
	public void setAnDescricaoRetorno(String anDescricaoRetorno) {
		this.anDescricaoRetorno = anDescricaoRetorno;
	}
	public String getAnProcedure() {
		return anProcedure;
	}
	public void setAnProcedure(String anProcedure) {
		this.anProcedure = anProcedure;
	}
	public int getCnErroOracle() {
		return cnErroOracle;
	}
	public void setCnErroOracle(int cnErroOracle) {
		this.cnErroOracle = cnErroOracle;
	}
	public String getAnErroOracle() {
		return anErroOracle;
	}
	public void setAnErroOracle(String anErroOracle) {
		this.anErroOracle = anErroOracle;
	}
	public String getAnMensagemAlerta() {
		return anMensagemAlerta;
	}
	public void setAnMensagemAlerta(String anMensagemAlerta) {
		this.anMensagemAlerta = anMensagemAlerta;
	}
		
}