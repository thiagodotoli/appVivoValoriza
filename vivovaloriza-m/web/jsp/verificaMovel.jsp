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
			 $("input:checkbox:not(:checked)").bind ("change", function (event)
					 {
						 if($('#checkbox-termos').is(":not(:checked)"))

							 {
							 alert("Para aproveitar seus benefícios é necessário concordar com os termos e condições do programa de relacionamento Vivo Valoriza");
							 //window.location.href = "http://www.vivo.com.br/portalweb/appmanager/env/web#";
							 }
							
						
			 		 });
		 		 
				 $('#checkbox-termos').prop('checked', true).checkboxradio('refresh');
				 
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
                <h1 >Vivo Valoriza</h1>
            </div>
        </div>
        <!-- /header -->
        
        <!-- CONTENT -->
        <div data-role="content">
        <div id="logonVivoMovel" >
        	<a class="branco linkMovel"  data-role="button"  data-transition="slide"  href="goAutenticarParticipanteFixo.action">Acessar com meu CPF <br /> Clientes Vivo Fixo</a>
        
        <img id="imgIntro" src="<s:url value='/web/assets/images/mainImage.png'/>" data-position="center" align="center" alt="Vivo Valoriza" />
		       
		       
			
		       		<div id="inputBox">
		        <p align="left">Por favor, confirme seus dados e digite sua senha.</p>
		            <form id="formcaDoc" action="autenticarParticipanteM.action" focus="caDoc">
		                <div data-role="fieldcontain">
		               		<input name="nome" class="loginInputMovel" id="nomeDoc" placeholder="Seu nome" value="" type="text">
		                    <br />
		                    <input name="sobrenome" class="loginInputMovel" id="sobrenomeDoc" placeholder="Sobrenome" value="" type="text">
		                    <br />
		                    <input name="telefone" class="loginInputMovel" id="telefoneDoc" placeholder="Seu telefone" value="" type="text">
		                    <br />
		                    <input name="email" class="loginInputMovel" id="emailDoc" placeholder="Seu e-mail" value="" type="text">
		                    <br />
		                    <input name="anSenha" id="anSenha" class="loginInputMovel" placeholder="Senha" value="" type="password">
		                     
		                      <a href="pageNotFound.action" class="left normalText" >Cadastro</a>   
		                      <a href="pageNotFound.action" class="right normalText" >Esqueceu a sua senha?</a>  
		                </div>
		
		                    <a class="enterBtn black"  data-role="button"  data-transition="slide"  href="autenticarParticipante.action">
		                    	<input type="submit" id="loginInput" value="Entrar" data-transition="slide" />
		                    </a>
							<input type="checkbox" name="checkbox-termos" id="checkbox-termos" >
    						<label for="checkbox-termos"  class="right normalText termosLabel" >Li  e concordo com os termos de uso.</label>
						    
		                   	<a href="pageNotFound.action" class="right smallText" >Termos de uso</a>
		                    <br />
		                   
		            </form>
		        </div>
										
		            </div>           
            
        </div>
        <!-- /content -->
	</div>
</body>
</html>