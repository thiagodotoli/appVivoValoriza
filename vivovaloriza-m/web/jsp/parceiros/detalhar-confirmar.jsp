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
           <a class="logo" href="obterParceirosMural.action?caCategoria=<s:property value='caCategoria'/>"><span class="iconVoltar" ></span><h2>Voltar</h2></a>
         </div>
      </div>
      <!-- /header -->

	   <!-- CONTENT -->
	   <div data-role="content">
	      <div class="sub-header">
	         <h2 class="black">Parceiros</h2>
	      </div>

	      <div id="confirmaBox">
	         <a class="confirmaBtn branco" data-inset="true"  data-role="button"  href="obterParceiroVoucher.action?cnParceiro=<s:property value='cnParceiro'/>">
	            <input type='submit'class="branco submitInout" value="Confirmar"/>
	         </a>
	      </div>
	
	      <ul data-role="listview" data-inset="true">
	         <li class="voucher-item" data-theme="">
	            <a class="oferta-link-voucher"  >
	               <div class="voucher">
	                  <img src="<s:property value='anFiguraDetNomeArq'/>" />
	                  <h3 class="branco"><s:property value='anParceiro'/></h3>
	               </div> 
	            </a> 
	         </li>
	      </ul>
	      
	      <div class="voucher-descr">
            <s:property value='anLegenda'/>
   	      	<br/><br/><br/><br/>
   	      	<p class="vermelho">REGULAMENTO</p>
   	      	<br/><br/>
   	      	<p class="laranja right"><s:property value='anRegulamento'/></p>
	         <img id="imgIntro" src="<s:url value='/web/assets/images/img-bottom-voucher.png'/>" data-position="center" align="center " alt="Vivo Valoriza" />
	      </div>
	              
	   </div>
	   <!-- /content -->
   </div>  
</body>
</html>