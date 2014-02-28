<%
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Cache-Control","no-cache,must-revalidate,no-store,proxy-revalidate,max-age=0"); //HTTP 1.1
	response.setDateHeader ("Expires", -1); //evita o caching no servidor proxy
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="ui-mobile-rendering">

<head>
<s:include value="/web/jsp/head.jsp"></s:include>

<script type="text/javascript">  
	$(document).ready(function(){
		app.initializeGeo();			
	});
</script>
</head>

<body>
    <div data-role="page"> 
		<!-- HEADER -->
		<div data-role="header" data-fullscreen="true">
		   <div id="headerBox">
		    <a href="obterFiltroIngressosGratis.action" class="logo"><span class="iconVoltar" ></span><h2>Voltar</h2></a>
		   </div>
		</div>
		<!-- /header -->
        
        <!-- CONTENT -->
        <div data-role="content">
          <div class="sub-header">
            <h2 class="black">Ingressos Grátis</h2>
	        </div>

			    <ul data-role="listview" data-inset="true">
  
  				<s:iterator value="ingressosGratis">
          <li class="oferta-item" data-theme="">
	          <a class="oferta-link" href="<s:property value='caChave'/>">
	           	<div class="oferta-data">
	            <!-- <img src="<s:property value='anFiguraDetNomeArq'/>" />  -->
	            <h3 class="cinzaText"><s:property value='anTitulo'/></h3>
            	<p class="roxo"><s:property value='dtEvento'/></p>
	            <span class="laranja right"><s:property value='caAcaoPermitida'/></span>
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