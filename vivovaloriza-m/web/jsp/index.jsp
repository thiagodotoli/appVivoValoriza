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
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script> 
<s:include value="/web/jsp/head.jsp"></s:include>
	<script type="text/javascript">  
		 $(document).ready(function(){  
			 $(".enterBtn").click(function(event){
				 if($('#checkbox-termos').is(":checked")){
					 //console.log("true")
				  	return true;
				 }else{
					 event.preventDefault();
					 alert("Para aproveitar seus benefícios é necessário concordar com os termos e condições do programa de relacionamento Vivo Valoriza");
					//console.log("false")
				}
				});
		
	 		 
			 //$('#checkbox-termos').prop('checked', true).checkboxradio('refresh');
			 
			 var splash = $(document).find("#splash");
			 var confirmation = "<s:property value='message'/>";
			 var validation = false;
			 
			 if(confirmation == "Login ou Senha inv&aacute;lidos!"){
			 	app.hide(splash);
			 	
			 	setTimeout(function(){alert("Login ou Senha inválidos!")}, 1000);
			 	sessionStorage.validation = false;
			 }
			 if(confirmation == "Falha no Login"){
			 	app.hide(splash);
			 	
			 	setTimeout(function(){alert("Falha no Login")}, 1000);
			 	//alert("Falha no Login");
				 
			 	sessionStorage.validation = false;
			 }
			 if(confirmation == "Login já realizado!"){
			 	
			 	
			 	sessionStorage.validation = true;
			 	
			 	
			 }
			 if(confirmation == ""){
			 
			 	 sessionStorage.validation = true;
			 }
			 
			 
			 app.splash();
			// console.log("<s:property value='message'/>"); 
			 $(function(){
			 
			  
			     $("#formcaDoc").validate({  
                    //debug:true, retira essa linha, para o form voltar a funcionar  
                    rules: {  
                        "caDoc" : {  
                            cpf: 'valid' //valida tanto Formatação como os Digitos  
                            //caso não queira validar a formatação use => cpf: 'valid'  
                            //caso só queira validar a formatação use => cpf: 'format'  
                        },  
                        "caTel" : {  
                            telefone: 'both' //AINDA FALTA AJUSTAR ALGORITIMO valida tanto Formatação como os Digitos  
                        }  
                    }  
                });  
				   
				 //$("#caDoc").mask("999.999.999-99");  
				 
			  	
			 });  
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
            <!-- SPLASH -->
            <div id="splash" class="fadeOut">
                <p id="splashTitle">
                    <img id="logoIntro" src="<s:url value='/web/assets/images/logoVivoValorizaApp.png'/>" data-position="center" align="center" alt="Vivo Valoriza" /> 
                </p>
                <h1 class="black">Vivo Valoriza</h1>
                <p class="fixed-bottom">
                    <img id="imgIntro" src="<s:url value='/web/assets/images/bonecoBgVivoValorizaApp.png'/>" data-position="center" align="center " alt="Vivo Valoriza" /> 
                </p>
            </div>    
            <!-- /splash -->
         	
         	
         	
            <div id="logonVivoFixo" >
		    <!-- setMessage-->
         	
         	
			<a class="branco linkMovel"  data-role="button"  data-transition="slide"  href="goAutenticarParticipanteMovel.action">Acessar com meu e-mail <br /> Clientes Vivo M&oacute;vel</a>
			
			
         	<!-- /setMessage-->
                <img id="imgIntro" src="<s:url value='/web/assets/images/mainImage.png'/>" data-position="center" align="center" alt="Vivo Valoriza" />
		        <div id="inputBox">
		        <p align="left">Por favor, digite o CPF e sua senha.</p>
		            <form id="formcaDoc" action="autenticarParticipante.action" focus="caDoc">
		                <div data-role="fieldcontain">
		                    <input name="caDoc" class="loginInput" id="caDoc" placeholder="Seu CPF" value="" type="text">
		                    <br />
		                    <input name="anSenha" id="anSenha" class="loginInput" placeholder="Senha" value="" type="password">
		                     
		                      <a href="pageNotFound.action" class="left normalText" >Cadastro</a>   
		                      <a href="pageNotFound.action" class="right normalText" >Esqueceu a sua senha?</a>  
		                </div>
		
		                    <a class="enterBtn black"  data-role="button"  data-transition="slide"  href="autenticarParticipante.action">
		                    	<input type="submit" id="loginInput" value="Entrar" name="loginInput" data-transition="slide" />
		                    </a>
							<input type="checkbox" name="checkbox-termos" id="checkbox-termos" >
    						<label for="checkbox-termos"  class="right normalText termosLabel" >Li  e concordo com os termos de uso.</label>
						    
						    <a href="pageNotFound.action" class="right smallText" >Termos de uso</a>
		                    <br />
		                    
		            </form>
		           
 
		        </div>
		    </div>	
		</div>
    <script src="<s:url value='/web/js/main.js'/>"></script>

		<!-- /content -->
	</div>
</body>
</html>