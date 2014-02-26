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
   <script type="text/javascript">  
	   $(document).ready(function(){  
			 app.home();
			//alert(sessionStorage.validation);
			
		 });  
   </script>  
</head>

<body>
	<div data-role="page"> 
    
	<!-- HEADER -->
	<div data-role="header" data-fullscreen="true">
	   <div id="headerBox">
	    <a href="home.action" class="logo"><span class="iconVoltar" ></span><h3>Retornar aos <br /> benefícios</h3></a>
	   </div>
	</div>
	<!-- /header -->
        
	<!-- CONTENT -->
	<div data-role="content">
		<div class="sub-header">
		    <h2 class="black">Cinemark</h2>
		    <img id="imgIntro" src="<s:url value='/web/assets/images/cinemarkImgVivoValorizaApp.png'/>" data-position="center" align="center" alt="Vivo Valoriza" />
		 </div>
		 <div id="infoBox">
			<div class="txtRegulamento cinzaText">
				<p>Cliente Vivo Valoriza tem 50% de desconto na rede Cinemark! Agora voc&ecirc; pode adquirir seus ingressos via <a href="http://www.ingresso.com.br" target="_blank">Ingresso.com</a>.</p>
				<p>Se voc&ecirc; &eacute; da categoria V1, tem direito a 10 meia-entradas no m&ecirc;s, podendo utilizar ate 2 por sess&atilde;o.</p>
				<p>Se voc&ecirc; &eacute; da categoria V2, tem direito a 4 meia-entradas no m&ecirc;s, podendo utilizar ate 2 por sess&atilde;o.</p>
				<p>E, se voc&ecirc; &eacute; da categoria V3, tem direito a 2 meia-entrada no m&ecirc;s.</p>
				<p>Os descontos s&atilde;o v&aacute;lidos para todas as salas da rede Cinemark, sess&otilde;es 2D, 3D e XD! </p>
				<p>(Exceto salas do Shopping Iguatemi SP, sala Prime do Shopping Cidade Jardim SP e salas Premier). </p>
				<p>Cliente Vivo Pr&eacute; m&oacute;vel tamb&eacute;m tem desconto! Basta realizar uma recarga de R$18,00 (valor promocional) ou mais para utilizar o benef&iacute;cio, da sua categoria, por 30 dias. </p>
				
							                        
	                     <p>&nbsp;</p>
				<p>Consulte todas as informa&ccedil;&otilde;es no <a href="exibirParcDestqCinemarkRegulamento.action" class="roxo">regulamento da parceria</a>.</p>
			</div>
        </div>
	</div>
	<!-- /content -->
</div>  
</body>
</html>