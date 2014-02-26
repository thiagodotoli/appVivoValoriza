package br.com.vivovaloriza.mobile.integration.vo.itens;

import java.util.ArrayList;
import java.util.List;

import br.com.vivovaloriza.mobile.integration.vo.IngressoGratisVO;

public class ListaIngressosGratisVO {

	private List<IngressoGratisVO> list;

	public ListaIngressosGratisVO() {
		list = new ArrayList<IngressoGratisVO>();
	}

	public List<IngressoGratisVO> getList() {
		return list;
	}

	public void setList(List<IngressoGratisVO> list) {
		this.list = list;
	}

}