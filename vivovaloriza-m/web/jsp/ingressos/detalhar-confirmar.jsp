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
           <a class="logo" href="obterEventosDisponiveis.action?caTpEvento=<s:property value='caTpEvento'/>"><span class="iconVoltar" ></span><h2>Voltar</h2></a>
         </div>
      </div>
      <!-- /header -->

	   <!-- CONTENT -->
	   <div data-role="content">
	      <div class="sub-header">
	         <h2 class="black">Ingressos Grátis</h2>
	      </div>

	      <div id="confirmaBox">
	         <a class="confirmaBtn branco uppercase" data-inset="true"  data-role="button"  href="<s:property value='caChave'/>">
	            <input type='submit'class="branco uppercase submitInout" value="<s:property value='caAcaoPermitida'/>"/>
	         </a>
	      </div>
	
	      <ul data-role="listview" class="ingressoList" data-inset="true">
	         <li class="voucher-item" data-theme="">
	            <a class="oferta-link-voucher"  >
	               <div class="voucher">
	                  <img src="<s:property value='anFiguraDetNomeArq'/>" />
	                  <h3 class="branco"><s:property value='anTitulo'/></h3>
	                  <p class="branco"><s:property value='anGenero'/><br/><s:property value='anClassifEtaria'/></p>
	               </div> 
	               
	                <div class="voucher-descr-confirma">
            <div id="dadosCliente">
               <span id="dataLabel">Data:</span>
               <span id="dataEmissao"><s:property value='dtEvento'/></span>   <br/>
               <span id="localLabel">Local:</span>
               <span id="nomeLocal"><s:property value='anLocal'/></span>   <br/>
               <span id="enderecoLabel">Endereço:</span>
               <span id="nomeEndereco"><s:property value='anEndereco'/></span>   <br/>
            </div>
         </div>
	      
	      <div class="voucher-descr">
	         <p id="dadosEvento">
    	      	<strong>Sinopse:</strong>
        	  	<s:property value='anSinopse'/>
	         </p>
	         <img id="imgIntro" src="<s:url value='/web/assets/images/img-bottom-voucher.png'/>" data-position="center" align="center " alt="Vivo Valoriza" />
	      </div>
	   </div>
	            </a> 
	         </li>
	      </ul>

        
	   <!-- /content -->
   </div>  
</body>
</html>