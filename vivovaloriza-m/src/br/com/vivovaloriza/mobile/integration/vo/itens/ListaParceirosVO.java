package br.com.vivovaloriza.mobile.integration.vo.itens;

import java.util.ArrayList;
import java.util.List;

import br.com.vivovaloriza.mobile.integration.vo.ParceiroVO;

public class ListaParceirosVO {

	private List<ParceiroVO> list;

	public ListaParceirosVO() {
		list = new ArrayList<ParceiroVO>();
	}

	public List<ParceiroVO> getList() {
		return list;
	}

	public void setList(List<ParceiroVO> list) {
		this.list = list;
	}

}