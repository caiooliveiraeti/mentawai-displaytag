package br.com.javacia.mentawai.displaytag.web;

import org.mentawai.core.ActionConfig;
import org.mentawai.filter.OVFilter;
import org.mentawai.filter.PaginationDisplayTagFilter;
import org.mentawai.filter.VOFilter;
import org.mentawai.i18n.LocaleManager;
import org.mentawai.list.BaseListData;
import org.mentawai.list.ListManager;

import br.com.javacia.mentawai.displaytag.model.pojo.Cliente;
import br.com.javacia.mentawai.displaytag.web.action.ClienteAction;

public class ApplicationManagerSys extends org.mentawai.core.ApplicationManager {

	

	@Override
    public void loadLocales() {
		LocaleManager.add("pt_BR");
    }
	
	@Override
	public void loadActions() {
		
		/*********************************************************
		 * Crud Cliente
		 *********************************************************/
		ActionConfig formCliente = action("/cadastro/cliente", ClienteAction.class, "form")
			.fwdOk("/jsp/cadastro/cliente/form.jsp");
		
		action("/cadastro/cliente", ClienteAction.class, "save")
			.filter(new VOFilter(Cliente.class))
			.redirOk("/cadastro/cliente.form.mtw?status=true")
			.fwdError("/jsp/cadastro/cliente/form.jsp")
			.chainError(formCliente);
		
		action("/cadastro/cliente", ClienteAction.class, "edit")
			.filter(new VOFilter(Cliente.class))
			.filter(new OVFilter("cliente"))
			.fwdOk("/jsp/cadastro/cliente/form.jsp")
			.redirError("/jsp/error/404.jsp");
		
		action("/cadastro/cliente", ClienteAction.class, "list")
			.filter(new PaginationDisplayTagFilter("table", "nomeFantasia"))
			.filter(new VOFilter("cliente", Cliente.class))
			.fwdOk("/jsp/cadastro/cliente/list.jsp");
	
	}
	
	@Override
	public void loadLists() throws Exception {
		ListManager.addList(new BaseListData("listaSimNao", BaseListData.ORDER_BY_ID));
	}
}
