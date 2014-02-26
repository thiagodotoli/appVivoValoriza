package br.com.vivovaloriza.mobile.integration.vo.itens;

import java.util.ArrayList;
import java.util.List;

import br.com.vivovaloriza.mobile.integration.vo.EspetaculoDescontoVO;

public class ListaEspetaculosDescontoVO {

	private List<EspetaculoDescontoVO> list;

	public ListaEspetaculosDescontoVO() {
		list = new ArrayList<EspetaculoDescontoVO>();
	}

	public List<EspetaculoDescontoVO> getList() {
		return list;
	}

	public void setList(List<EspetaculoDescontoVO> list) {
		this.list = list;
	}

}