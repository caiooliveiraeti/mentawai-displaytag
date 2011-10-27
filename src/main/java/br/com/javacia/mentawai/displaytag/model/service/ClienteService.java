package br.com.javacia.mentawai.displaytag.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.mentawai.filter.Pagination;

import br.com.javacia.mentawai.displaytag.model.pojo.Cliente;

public class ClienteService {

	private static List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void save(Cliente cliente) {
		
		if(cliente.getIdCliente() > 0){
			
			clientes.set(cliente.getIdCliente() - 1, cliente);
			
		}else{

			clientes.add(cliente);
			cliente.setIdCliente(clientes.size());	
		}
		
	}

	public Cliente load(Cliente cliente) {
		return clientes.get(cliente.getIdCliente() - 1);
	}

	public List<Cliente> listByHint(Cliente cliente, Pagination pagination) {
		if(clientes.size() == 0){
			return clientes;
		}
		
		List<Cliente> listResult = filterByHint(cliente);
		
		int limitRecord = pagination.getInitRecord() + pagination.getLimitRecord();
		
		if(limitRecord > listResult.size() ){
			limitRecord = listResult.size();
		}
		
		List<Cliente> subList = listResult.subList(pagination.getInitRecord(), limitRecord);
		
		Collections.sort(subList, new ClienteComparator(pagination.getSortAttribute(), pagination.isDesc()));
		
		return subList;
	}
	
	private class ClienteComparator implements Comparator<Cliente>{

		private boolean desc;
		private String sortAttribute;

		public ClienteComparator(String sortAttribute, boolean desc) {
			this.sortAttribute = sortAttribute;
			this.desc = desc;
		}

		public int compare(Cliente o1, Cliente o2) {
			int compareTo = -1;

			if ("nomeFantasia".equals(sortAttribute)) {
				compareTo = o1.getNomeFantasia().compareTo(o2.getNomeFantasia());
			} else if ("razaoSocial".equals(sortAttribute)) {
				compareTo = o1.getRazaoSocial().compareTo(o2.getRazaoSocial());
			}

			if (desc) {
				return compareTo * -1;
			} else {
				return compareTo;
			}
		}
		
	}

	protected List<Cliente> filterByHint(Cliente clienteHint) {
		List<Cliente> clientesResult = new ArrayList<Cliente>(clientes);
		
		Iterator<Cliente> iterator = clientesResult.iterator();
		
		while (iterator.hasNext()) {
			Cliente cliente = (Cliente) iterator.next();
			
			if(startsWithHint(cliente.getNomeFantasia(), clienteHint.getNomeFantasia()) &&
			   startsWithHint(cliente.getRazaoSocial(), clienteHint.getRazaoSocial())){
				
				continue;
				
			}
			
			iterator.remove();
			
		}
		
		return clientesResult;
	}

	private boolean startsWithHint(String value, String valueHint) {
		
		if(value == null || "".equals(value)){
			return true;
		}
		
		valueHint = valueHint == null ? "" : valueHint;
		
		return value.startsWith(valueHint);
	}

	public int countByHint(Cliente cliente) {
		List<Cliente> listResult = filterByHint(cliente);
		
		return listResult.size();
	}

}
