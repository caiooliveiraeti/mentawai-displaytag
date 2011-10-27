<%@ taglib uri="http://www.mentaframework.org/tags-mtw/" prefix="mtw"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<mtw:useI18N />
<html>
	<head>
		<title><mtw:i18n key="title.cadastro.cliente" /></title>
	</head>
	<body>
		<form id="formCrudCliente" method="post" action="<mtw:contextPath />/cadastro/cliente.save.mtw">
			<fieldset class="crudBox">
				<legend><mtw:i18n key="title.cadastro.cliente" /></legend>
				
				<fieldset>
					<div class="row">
						<label class="lblField" for="razaoSocial"><mtw:i18n key="razao.social" /></label> 
						<span class="field"> 
							<mtw:input id="razaoSocial" name="razaoSocial" type="text" klass="required"/>
						</span>
						<label class="validationField" for="razaoSocial">
							<mtw:outError field="razaoSocial"><mtw:out /></mtw:outError>
						</label> 
					</div>
					
					<div class="row">
						<label class="lblField" for="nomeFantasia"><mtw:i18n key="nome.fantasia" /></label> 
						<span class="field"> 
							<mtw:input id="nomeFantasia" name="nomeFantasia" type="text" klass="required"/>
						</span>
						<label class="validationField" for="nomeFantasia">
							<mtw:outError field="nomeFantasia"><mtw:out /></mtw:outError>
						</label> 
					</div>
					
					<div class="row">
						<label class="lblField" for="ativo"><mtw:i18n key="ativo" /></label> 
						<span class="field"> 
							<mtw:radiobuttons name="ativo" list="listaSimNao" defValue="true" />
						</span>
						<label class="validationField" for="ativo">
							<mtw:outError field="ativo"><mtw:out /></mtw:outError>
						</label> 
					</div>
				</fieldset>
				
				<div class="boxMethods">
					<mtw:input name="idCliente" type="hidden"/>
					
					<a href="<mtw:contextPath />/cadastro/cliente.form.mtw"><mtw:i18n key="novo" /></a>
					<input type="submit" value="<mtw:i18n key="salvar" />" />
					<a href="<mtw:contextPath />/cadastro/cliente.list.mtw"><mtw:i18n key="listar" /></a>
				</div>
				
				<c:if test="${param.status != null}">
					<span class="info">
						<mtw:i18n key="salvo.com.sucesso" />
					</span>
				</c:if>
				
				<mtw:hasError>
					<span class="infoError">
						<mtw:outErrors>
							<mtw:loop><h3><mtw:out /></h3></mtw:loop>
						</mtw:outErrors>
					</span>
				</mtw:hasError>
			</fieldset>
		</form>
	</body>
</html>