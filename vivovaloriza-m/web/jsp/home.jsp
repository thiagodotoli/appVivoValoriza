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
			 app.home();
			
		
		 });  
	 </script>  
</head>

<body>
    <div data-role="page"> 
    <!-- HEADER -->
        <div data-role="header" data-fullscreen="true">
            <div id="headerBox">
                <h1 >Vivo Valoriza</h1>
            </div>
        </div>
        <!-- /header -->
        
        <!-- CONTENT -->
        <div data-role="content">
        <div class="sub-header">
            <h2 class="black">Benef&iacute;cios Exclusivos</h2>
            <img id="imgIntro" src="<s:url value='/web/assets/images/homeImgVivoValorizaApp.png'/>" data-position="center" align="center" alt="Vivo Valoriza" />
         </div>
            <div class="homeNav" data-role="navbar" data-iconpos="top">
               <ul>
                   <li>
                       <a href="exibirCinemark.action" data-transition="fade" data-theme=""  data-icon="plus">
                           <br />
                           Cinemark
                       </a>
                   </li>
                   <li>
                       <a href="listarEspetaculosDesconto.action" data-transition="fade" data-theme=""  data-icon="minus">
                           <br />
                           Espet&aacute;culos com Desconto
                       </a>
                   </li>
               </ul>
           </div>
           <div  class="homeNav" data-role="navbar" data-iconpos="top">
               <ul>
                   <li>
                       <a href="obterFiltroIngressosGratis.action" data-transition="fade" data-theme=""  data-icon="delete">
                           <br />
                           Ingressos Gr&aacute;tis
                       </a>
                   </li>
                   <li>
                       <a href="obterFiltrosParceiro.action" data-transition="fade" data-theme=""  data-icon="arrow-r">
                           <br />
                           Parceiros 
                       </a>
                   </li>
               </ul>
               
            </div>
            <div id="solicitadosBox">
            
              <!--  <a href="pageNotFound.action" class="right" >Benef&iacute;cios j&aacute; solicitados.</a> -->
                <br /> 
                
            </div>
            
        </div>
        <!-- /content -->
	</div>
</body>
</html>