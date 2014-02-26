package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaIngressosGratisVO;

public class ObterEventosDisponiveisResponse implements Serializable {

	private ListaIngressosGratisVO itens;

	private ResultadoProcessamento resultadoProcessamento;

	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}

	public ListaIngressosGratisVO getItens() {
		return itens;
	}
	public void setItens(ListaIngressosGratisVO itens) {
		this.itens = itens;
	}

	
}