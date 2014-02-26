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
          <a href="home.action" class="logo"><span class="iconVoltar" ></span><h3>Retornar aos <br /> benef&iacute;cios</h3></a>
         </div>
      </div>
      <!-- /header -->
        
      <!-- CONTENT -->
      <div data-role="content">
         <div class="sub-header">
            <h2 class="black">Ingressos Grátis</h2>
         </div>
            
         <div id="confirmadoPop">
            <h2 class="branco"><s:property value='anMensagemAlerta'/></h2>
         </div>

         <ul data-role="listview" data-inset="true">
            <li class="voucher-item" data-theme="">
               <a class="oferta-link-espetaculo"  >
                  <div class="voucher">
					<img src="<s:property value='anFiguraDetNomeArq'/>" />
					<h3 class="branco"><s:property value='anTitulo'/></h3>
					<p class="branco"><s:property value='anGenero'/><br/><s:property value='anClassifEtaria'/></p>
                  </div> 
                  
                  <div class="voucher-descr-confirma">
                     <div id="dadosCliente">
                        <span id="nomeLabel">Nome:</span>
                        <span id="nomeCliente"><s:property value='anNome'/></span>   <br/>
                        <span id="nomeLabel">Reserva:</span>
                        <span id="nomeCliente"><s:property value='cnReserva'/></span>   <br/>

		               <span id="nomeLabel">Data:</span>
		               <span id="nomeCliente"><s:property value='dtEvento'/></span>   <br/>
		               <span id="nomeLabel">Local:</span>
		               <span id="nomeCliente"><s:property value='anLocal'/></span>   <br/>
		               <span id="nomeLabel">Endereço:</span>
		               <span id="nomeCliente"><s:property value='anEndereco'/></span>   <br/>
                     </div>
                     
                     <p id="dadosEvento">
                        <s:property value='anObservacao'/>
                     </p>
                     <img id="img-voucher" src="<s:url value='/web/assets/images/img-bottom-voucher.png'/>" data-position="center" align="center " alt="Vivo Valoriza" />
                     <br/>
                     <!--
                       <img id="bar-code" src="<s:url value='/web/assets/images/bar-code.png'/>" data-position="center" align="center " alt="Vivo Valoriza" />
                      -->
                     <div id="barcodeTarget" class="barcodeTarget"></div>  
                  </div>
               </a>
            </li>
         </ul>
      </div>
      <!-- /content -->
			<input type="hidden" id="barcodeValue" value="<s:property value='cnReserva'/>" /> 
	</div>  
</body>
</html>