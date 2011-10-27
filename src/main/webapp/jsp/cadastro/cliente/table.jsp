<%@ taglib uri="http://www.mentaframework.org/tags-mtw/" prefix="mtw"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<mtw:useI18N />
<display:table id="table" class="table" name="clientes" size="countClientes" sort="external" pagesize="30" partialList="true" 
	requestURI="cliente.list.mtw" >		

	<display:column titleKey="editar">
		<a href="cliente.edit.mtw?idCliente=${table.idCliente}">
			<mtw:i18n key="editar"/>
		</a>
	</display:column>

	<display:column property="razaoSocial" sortable="true" sortName="razaoSocial" titleKey="razao.social" />
	<display:column property="nomeFantasia" sortable="true" sortName="nomeFantasia" titleKey="nome.fantasia" />

	<display:column titleKey="ativo">
		<mtw:out value="table.ativo" onTrue="!sim!" onFalse="!nao!" />
	</display:column>
</display:table>