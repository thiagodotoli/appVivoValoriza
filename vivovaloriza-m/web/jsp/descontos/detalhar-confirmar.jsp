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
</head>

<body>
   <div data-role="page"> 
      <!-- HEADER -->
      <div data-role="header" data-fullscreen="true">
         <div id="headerBox">
           <a class="logo" href="listarEspetaculosDesconto.action"><span class="iconVoltar" ></span><h2>Voltar</h2></a>
         </div>
      </div>
      <!-- /header -->

	   <!-- CONTENT -->
	   <div data-role="content">
	      <div class="sub-header">
	         <h2 class="black">Espet&aacute;culos com Desconto</h2>
	      </div>

	      <div id="confirmaBox">
	         <a class="confirmaBtn branco" data-inset="true"  data-role="button"  href="emitirVoucherEspetaculoDesconto.action?cnSeq=<s:property value='cnSeq'/>">
	            <input type='submit'class="branco submitInout" value="Confirmar"/>
	         </a>
	      </div>
	
	      <ul data-role="listview" data-inset="true">
	         <li class="voucher-item" data-theme="">
	            <a class="oferta-link-voucher"  >
	               <div class="voucher">
	                  <img src="<s:property value='anImagem'/>" />
	                  <h3 class="branco"><s:property value='anTitulo'/></h3>
	                  <p class="branco"><s:property value='anSubTitulo'/></p>
	               </div> 
	            </a> 
	         </li>
	      </ul>
	      
	      <div class="voucher-descr">
	         <p id="dadosEvento">
	            <s:property value='anDesc'/>
	         </p>
	         <img id="imgIntro" src="<s:url value='/web/assets/images/img-bottom-voucher.png'/>" data-position="center" align="center " alt="Vivo Valoriza" />
	      </div>
	              
	   </div>
	   <!-- /content -->
   </div>  
</body>
</html>