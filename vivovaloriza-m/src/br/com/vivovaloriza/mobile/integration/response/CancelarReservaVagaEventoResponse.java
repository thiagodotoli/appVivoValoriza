package br.com.vivovaloriza.mobile.integration.response;

import java.io.Serializable;

import br.com.vivovaloriza.mobile.integration.vo.ResultadoProcessamento;

public class CancelarReservaVagaEventoResponse implements Serializable {

	private ResultadoProcessamento resultadoProcessamento;

	public ResultadoProcessamento getResultadoProcessamento() {
		return resultadoProcessamento;
	}

	public void setResultadoProcessamento(
			ResultadoProcessamento resultadoProcessamento) {
		this.resultadoProcessamento = resultadoProcessamento;
	}
	
}