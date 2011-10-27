package br.com.javacia.mentawai.displaytag.web.action;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mentawai.core.BaseAction;
import org.mentawai.filter.Pagination;
import org.mentawai.util.MockAction;
import org.mockito.Mockito;

import br.com.javacia.mentawai.displaytag.model.pojo.Cliente;
import br.com.javacia.mentawai.displaytag.model.service.ClienteService;

public class ClienteActionTest {
	
	private ClienteAction clienteAction;
	private ClienteService clienteService;

	@Before
	public void setUp() throws Exception {
		this.clienteService = Mockito.mock(ClienteService.class);
		
		this.clienteAction = new ClienteAction(clienteService);
		MockAction.init(clienteAction);
	}

	@Test
	public void testSave() {
		Cliente cliente = new Cliente("Razao", "Nome", true);
		
		Assert.assertEquals(BaseAction.SUCCESS, clienteAction.save(cliente));
		
		Mockito.verify(clienteService).save(cliente);
	}

	@Test
	public void testEdit() {
		
		//Teste com sucesso no load.
		Cliente cliente = new Cliente(1);
		Cliente clienteRetorno = new Cliente(1, "Razao1", "Nome1", true);
		Mockito.when(clienteService.load(cliente)).thenReturn(clienteRetorno);
		
		Assert.assertEquals(BaseAction.SUCCESS, clienteAction.edit(cliente));
		Assert.assertEquals(clienteRetorno, clienteAction.getOutput().getValue("cliente"));
		
		//Teste sem sucesso no load.
		cliente = new Cliente(2);
		Mockito.when(clienteService.load(cliente)).thenReturn(null);
		
		Assert.assertEquals(BaseAction.SUCCESS, clienteAction.edit(cliente));
		Assert.assertEquals(null, clienteAction.getOutput().getValue("cliente"));
		
	}

	@Test
	public void testList() {

		Cliente cliente = new Cliente("Razao1", "Nome1", true);
		Pagination pagination = new Pagination(0, 50, "razaoSocial", false);
		
		//Teste com elementos na lista.
		List<Cliente> listClientes = createListClientes(3);
		Mockito.when(clienteService.listByHint(cliente, pagination)).thenReturn(listClientes);
		Mockito.when(clienteService.countByHint(cliente)).thenReturn(listClientes.size());
		
		Assert.assertEquals(BaseAction.SUCCESS, clienteAction.list(cliente, pagination));
		
		Assert.assertEquals(listClientes, clienteAction.getOutput().getValue("clientes"));
		Assert.assertEquals(3, clienteAction.getOutput().getValue("countClientes"));
		
		//Teste sem elementos na lista.
		listClientes = createListClientes(0);
		Mockito.when(clienteService.listByHint(cliente, pagination)).thenReturn(listClientes);
		Mockito.when(clienteService.countByHint(cliente)).thenReturn(listClientes.size());
		
		Assert.assertEquals(BaseAction.SUCCESS, clienteAction.list(cliente, pagination));
		
		Assert.assertEquals(listClientes, clienteAction.getOutput().getValue("clientes"));
		Assert.assertEquals(0, clienteAction.getOutput().getValue("countClientes"));
		
	}

	private List<Cliente> createListClientes(int count) {
		List<Cliente> clientes = new ArrayList<Cliente>();

		for (int i = 1; i <= count; i++) {
			clientes.add(new Cliente(i, "razao" + i, "nome" + i, true));	
		}

		return clientes;
	}

}
