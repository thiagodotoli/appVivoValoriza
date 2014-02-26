package br.com.vivovaloriza.mobile.integration.vo.itens;

import java.util.ArrayList;
import java.util.List;

import br.com.vivovaloriza.mobile.integration.vo.AutorizacaoPerfilVO;

public class ListaAutorizacoesVO {

	private List<AutorizacaoPerfilVO> list;

	public ListaAutorizacoesVO() {
		list = new ArrayList<AutorizacaoPerfilVO>();
	}

	public List<AutorizacaoPerfilVO> getList() {
		return list;
	}

	public void setList(List<AutorizacaoPerfilVO> list) {
		this.list = list;
	}

}