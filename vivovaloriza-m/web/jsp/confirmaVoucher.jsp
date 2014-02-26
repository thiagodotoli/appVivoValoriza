<%
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Cache-Control","no-cache,must-revalidate,no-store,proxy-revalidate,max-age=0"); //HTTP 1.1
	response.setDateHeader ("Expires", -1); //evita o caching no servidor proxy
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page
contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html class="ui-mobile-rendering">

<head>
	<s:include value="/web/jsp/head.jsp"></s:include>
	<script type="text/javascript" src="<s:url value='/web/js/jquery-barcode.js'/>" ></script>

   <script type="text/javascript">

 	  function generateBarcode(){
       var value = $("#barcodeValue").val();
       var btype = 'code39';
       var renderer = 'css';
       var quietZone = false;

       var settings = {
        output:renderer,
        bgColor: '#FFFFFF',
        color: '#000000',
        barWidth: 1,
        barHeight: 50,
        moduleSize: 5,
        posX: 10,
        posY: 20,
        addQuietZone: 1
			};

       $("#barcodeTarget").html("").show().barcode(value, btype, settings);
    }
        
    function showConfig1D(){
      $('.config .barcode1D').show();
      $('.config .barcode2D').hide();
    }
    
    function showConfig2D(){
      $('.config .barcode1D').hide();
      $('.config .barcode2D').show();
    }
    
    
    $(function(){
      $('input[name=btype]').click(function(){
        if ($(this).attr('id') == 'datamatrix') showConfig2D(); else showConfig1D();
      });
      generateBarcode();
    });
  
    </script>	
	
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
            <h2 class="black">Espet&aacute;culos com Desconto</h2>
         </div>
            
         <div id="confirmadoPop">
            <h2 class="branco">Confirmado</h2>
         </div>

         <ul data-role="listview" data-inset="true">
            <li class="voucher-item" data-theme="">
               <a class="oferta-link-espetaculo"  >
                  <div class="voucher">
                     <img src="<s:property value='anImagem'/>" />
                     <h3 class="branco"><s:property value='anTitulo'/></h3>
                     <p class="branco"><s:property value='anSubTitulo'/></p>
                  </div> 
                  
                  <div class="voucher-descr-confirma">
                     <div id="dadosCliente">
                        <span id="nomeLabel">Nome:</span>
                        <span id="nomeCliente"><s:property value='anNome'/></span>   <br/>
                        <span id="dataLabel">Emiss&atilde;o em: </span>
                        <span id="dataEmissao"><s:property value='dtVoucher'/></span> 
                     </div>
                     
                     <p id="dadosEvento">
                        <s:property value='anDesc'/>
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
			<input type="hidden" id="barcodeValue" value="<s:property value='anCodigoBarra'/>" /> 
	</div>  
</body>
</html>