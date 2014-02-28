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
             <a href="obterFiltrosParceiro.action" class="back"><span class="iconVoltar" ></span><h2>Voltar</h2></a>
           </div>
       </div>
       <!-- /header -->
        
      <!-- CONTENT -->
      <div data-role="content">
         <div class="sub-header">
            <h2 class="black">Parceiros</h2>
         </div>
            
         <div id="confirmadoPop">
            <h2 class="branco">Confirmado</h2>
         </div>

         <ul data-role="listview" data-inset="true">
            <li class="voucher-item" data-theme="">
               <a class="oferta-link-espetaculo"  >
                  <div class="voucher">
                     <img src="<s:property value='anFiguraDetNomeArq'/>" />
                     <h3 class="branco"><s:property value='anParceiro'/></h3>
 	                 <p class="branco"><s:property value='dtIniVoucher'/></p>
                  </div> 
                  
                  <div class="voucher-descr-confirma">
                     <div id="dadosCliente">
                        <span id="nomeLabel">Relacionamento:</span>
                        <span id="nomeCliente"><s:property value='cnRelacionamento'/></span>   <br/>
                        <span id="nomeLabel">Nome:</span>
                        <span id="nomeCliente"><s:property value='anNome'/></span>   <br/>
                        <span id="dataLabel">Emitido em: </span>
                        <span id="dataEmissao"><s:property value='dtEmissao'/></span> 
                     </div>
                     
                     <p id="dadosEvento">
	                   <s:property value='anLegenda'/>
                     </p>
                     <img id="img-voucher" src="<s:url value='/web/assets/images/img-bottom-voucher.png'/>" data-position="center" align="center " alt="Vivo Valoriza" />
                     <br/>
                  </div>
               </a>
            </li>
         </ul>
      </div>
      <!-- /content -->
	</div>  
</body>
</html>