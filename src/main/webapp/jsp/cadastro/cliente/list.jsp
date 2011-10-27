<%@ taglib uri="http://www.mentaframework.org/tags-mtw/" prefix="mtw"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<mtw:useI18N />

<html>
	<head>
		<title><mtw:i18n key="title.listar.cliente" /></title>
	</head>
	<body>
	
		<fieldset class="crudBox">
			<legend>
				<mtw:i18n key="title.listar.cliente" />
			</legend>
			
			<fieldset class="filtroBox">
				<legend>
					<mtw:i18n key="filtros" />
				</legend>
		
				<mtw:form id="form" action="cadastro/cliente.list.mtw" method="get">
					
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
					
					</fieldset>
					<div class="boxMethods">
						<a href="<mtw:contextPath />/cadastro/cliente.form.mtw"><mtw:i18n key="novo" /></a>
						<input type="submit" value="<mtw:i18n key="filtrar" />" />
					</div>
		
				</mtw:form>
	
			</fieldset>
	
			<div id="displayTagDiv">
				<jsp:include page="table.jsp"></jsp:include>
			</div>
	
		</fieldset>
		
	</body>
</html>