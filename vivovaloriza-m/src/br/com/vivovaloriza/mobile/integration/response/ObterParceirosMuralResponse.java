package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaParceirosVO;

public class ObterParceirosMuralResponse implements Serializable {

	private String caCategoria;
	private String anTituloCategoria;

	private ListaParceirosVO itens;

	private ResultadoProcessamento resultadoProcessamento;

	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}

	public ListaParceirosVO getItens() {
		return itens;
	}
	public void setItens(ListaParceirosVO itens) {
		this.itens = itens;
	}
	public String getCaCategoria() {
		return caCategoria;
	}
	public void setCaCategoria(String caCategoria) {
		this.caCategoria = caCategoria;
	}
	public String getAnTituloCategoria() {
		return anTituloCategoria;
	}
	public void setAnTituloCategoria(String anTituloCategoria) {
		this.anTituloCategoria = anTituloCategoria;
	}

	
	
}