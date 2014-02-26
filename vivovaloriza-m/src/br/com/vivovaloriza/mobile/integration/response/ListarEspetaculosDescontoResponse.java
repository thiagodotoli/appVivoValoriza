package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaEspetaculosDescontoVO;

public class ListarEspetaculosDescontoResponse implements Serializable {

	private ListaEspetaculosDescontoVO itens;

	private ResultadoProcessamento resultadoProcessamento;

	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}

	public ListaEspetaculosDescontoVO getItens() {
		return itens;
	}
	public void setItens(ListaEspetaculosDescontoVO itens) {
		this.itens = itens;
	}

	
}