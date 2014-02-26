<%
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Cache-Control","no-cache,must-revalidate,no-store,proxy-revalidate,max-age=0"); //HTTP 1.1
	response.setDateHeader ("Expires", -1); //evita o caching no servidor proxy
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html; charset=windows-1252" %>

<!DOCTYPE html>
<html class="ui-mobile-rendering">

<head>
<s:include value="/web/jsp/head.jsp"></s:include>
</head>

<body>
    <div data-role="page"> 
    <!-- HEADER -->
        <div data-role="header" data-fullscreen="true">
            <div id="headerBox">
              <a href="home.action" class="back"><span class="iconVoltar" ></span><h2>Voltar</h2></a>
            </div>
        </div>
        <!-- /header -->
        
        <!-- CONTENT -->
        <div data-role="content">
          <div class="sub-header">
            <h2 class="black">Parceiros</h2>
	        </div>

			    <ul data-role="listview" data-inset="true">
  
  				<s:iterator value="categorias">
          <li class="oferta-item" data-theme="">
	          <a class="oferta-link" href="obterParceirosMural.action?caCategoria=<s:property value='caDom'/>">
	           	<div class="oferta-data">
	            <h3 class="cinzaText"><s:property value='anDescr'/></h3>
           		</div>
            </a>
	        </li>
					</s:iterator>

	    </ul>
        
    </div>
    <!-- /content -->
	</div>
</body>
</html>