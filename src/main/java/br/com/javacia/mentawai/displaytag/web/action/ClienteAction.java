package br.com.javacia.mentawai.displaytag.web.action;

import org.mentawai.core.BaseAction;
import org.mentawai.filter.Pagination;

import br.com.javacia.mentawai.displaytag.model.pojo.Cliente;
import br.com.javacia.mentawai.displaytag.model.service.ClienteService;

public class ClienteAction extends BaseAction {

	private ClienteService clienteService;
	
	public ClienteAction(){
		this(new ClienteService());
	}
	
	public ClienteAction(ClienteService clienteService){
		this.clienteService = clienteService;
	}
	
	public void form() {}

	public String save(Cliente cliente) {

		clienteService.save(cliente);

		return SUCCESS;
	}

	public String edit(Cliente cliente) {

		output.setValue("cliente", clienteService.load(cliente));

		return SUCCESS;
	}

	public String list(Cliente cliente, Pagination pagination) {
		output.setValue("clientes",	clienteService.listByHint(cliente, pagination));
		output.setValue("countClientes", (int) clienteService.countByHint(cliente));

		return SUCCESS;

	}
	
}
