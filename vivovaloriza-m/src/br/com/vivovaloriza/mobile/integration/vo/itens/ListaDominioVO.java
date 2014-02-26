package br.com.vivovaloriza.mobile.integration.vo.itens;

import java.util.ArrayList;
import java.util.List;

import br.com.vivovaloriza.mobile.integration.vo.DominioVO;

public class ListaDominioVO {

	private List<DominioVO> list;

	public ListaDominioVO() {
		list = new ArrayList<DominioVO>();
	}

	public List<DominioVO> getList() {
		return list;
	}

	public void setList(List<DominioVO> list) {
		this.list = list;
	}

}
