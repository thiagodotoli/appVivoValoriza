package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;
import br.com.vivovaloriza.mobile.integration.vo.itens.ListaDominioVO;

public class ListarDominioResponse implements Serializable {

	private ListaDominioVO itens;

	private ResultadoProcessamento resultadoProcessamento;

	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}
	public void setResultadoProcessamento(ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}

	public ListaDominioVO getItens() {
		return itens;
	}
	public void setItens(ListaDominioVO itens) {
		this.itens = itens;
	}

	
}