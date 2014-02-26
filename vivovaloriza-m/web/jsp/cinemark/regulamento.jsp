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
          <a href="exibirCinemark" class="logo"><span class="iconVoltar" ></span><h3>Retornar ao Cinemark</h3></a>
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
				<p><strong>REGULAMENTO DA UTILIZA&Ccedil;&Atilde;O DO BENEF&Iacute;CIO &ldquo;VIVO CINEMARK&rdquo;</strong></p>
				 
				<p>A VIVO S.A., inscrita no CNPJ/MF sob o n.&ordm; 02.449.992/0001-64, sediada na Av. Higien&oacute;polis, 1365 &ndash; Londrina/PR, Autorizat&aacute;ria da Uni&atilde;o Federal para presta&ccedil;&atilde;o do Servi&ccedil;o M&oacute;vel Pessoal na &Aacute;rea de Autoriza&ccedil;&atilde;o correspondente aos Estados do Rio de Janeiro (Regi&atilde;o n.&ordm; I do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 13/2002 &ndash; ANATEL), Esp&iacute;rito Santo (Regi&atilde;o n.&ordm; I do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 14/2002 &ndash; ANATEL), Bahia (Regi&atilde;o n.&ordm; I do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 15/2002 &ndash; ANATEL), Sergipe (Regi&atilde;o n.&ordm; I do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 16/2002 &ndash; ANATEL), Roraima, Amap&aacute;, Amazonas, Maranh&atilde;o, Par&aacute; (Regi&atilde;o n.&ordm; I do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 12/2003 &ndash; ANATEL), Alagoas, Cear&aacute;, Para&iacute;ba, Piau&iacute;, Pernambuco e Rio Grande do Norte (Regi&atilde;o n.&ordm; I do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 18/2007 &ndash; ANATEL), Acre, Rond&ocirc;nia, Tocantins, Distrito Federal, Goi&aacute;s, Mato Grosso, Mato Grosso do Sul, Paran&aacute;, Santa Catarina e Rio Grande do Sul (Regi&atilde;o n.&ordm; II do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 05/2010 &ndash; ANATEL), S&atilde;o Paulo (Regi&atilde;o n.&ordm; III do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 06/2010 &ndash; ANATEL) e Minas Gerais (Regi&atilde;o n.&ordm; I do PGA-SMP, conforme Termo de Autoriza&ccedil;&atilde;o n.&ordm; 004/2010/PVCP/SPV); a A. Telecom S/A, empresa com sede na cidade de S&atilde;o Paulo, Estado de S&atilde;o Paulo, na Alameda Campinas, 1070 &ndash; 1&ordm; andar, inscrita no CNPJ/MF sob n&ordm; 03.498.897/0001-13, doravante denominada A.Telecom, a Telef&ocirc;nica Brasil S/A, empresa com sede na cidade de S&atilde;o Paulo, Estado de S&atilde;o Paulo, na Rua Martiniano de Carvalho, 851, inscrita no CNPJ/MF 02.558.157/0001-62; e as empresas Comercial Cabo TV S&atilde;o Paulo S/A, empresa com sede na cidade de S&atilde;o Paulo, Estado de S&atilde;o Paulo, na Rua Dr. Rafael de Barros, 209, 6&ordm; andar, S&atilde;o Paulo/SP, inscrita no CNPJ/MF sob o n&ordm; 65.791.444/0001-38, Telefonica Sistema de Televis&atilde;o S/A, empresa com sede na cidade de S&atilde;o Paulo, Estado de S&atilde;o Paulo, na Rua Dr. Rafael de Barros, 209, 9&ordm; andar, S&atilde;o Paulo/SP, inscrita no CNPJ/MF sob o no. 05.069.728/0001-93, empresa com sede na cidade de Curitiba, Estado do Paran&aacute;, na Rua Marta Kateiva Oliveira, 319, inscrita no CNPJ/MF sob o n&ordm; 84.938.786/0001-82, doravante denominada individualmente como TVA Sul, e AJATO TELECOMUNICA&Ccedil;&Atilde;O LTDA., empresa com sede na Av. Mofarrej, n.&ordm; 1.270, Vila Leopoldina, na cidade de S&atilde;o Paulo, Estado de S&atilde;o Paulo, inscrita no CNPJ/MF sob o n&ordm; 07.694.195/0001-66, doravante denominadas empresas integrantes do Programa de Relacionamento &ldquo;Vivo Valoriza&rdquo;,</p>
				<p>V&ecirc;m apresentar com base no presente Regulamento o benef&iacute;cio de descontos na Rede de Cinemas Cinemark, decorrente de uma parceria firmada entre a Rede de Cinemas Cinemark e Vivo, mediante as condi&ccedil;&otilde;es a seguir estipuladas.</p>
				
				<p><strong>DOS PARTICIPANTES</strong></p>
				
				<p>1.1. A parceria destina-se aos clientes Vivo, habilitados em planos de servi&ccedil;os Pessoa F&iacute;sica na modalidade m&oacute;vel (Pr&eacute; Pago, P&oacute;s Pago, Controle, Residencial e/ou Internet), e clientes Pessoa F&iacute;sica das empresas A.Telecom, Telef&ocirc;nica, CATV, TST, TVA Sul e AJATO, participantes do programa de relacionamento, doravante denominado &ldquo;Vivo Valoriza&rdquo;.</p>
				<p>1.2. Clientes habilitados em planos de servi&ccedil;os Pessoa F&iacute;sica na modalidade m&oacute;vel Pr&eacute; Pago, participantes do Vivo Valoriza, para usufru&iacute;rem desta promo&ccedil;&atilde;o, dever&atilde;o adquirir uma recarga m&iacute;nima de R$25 (vinte e cinco reais), por m&ecirc;s, por cliente (CPF).</p>
				
				<p><strong>DOS BENEF&Iacute;CIOS</strong></p>
				
				<p>2.1. O presente benef&iacute;cio concede 50% (cinquenta por cento) de desconto do valor do ingresso inteiro (&ldquo;Meia Vivo Valoriza&rdquo;), na compra de ingresso na Rede de Cinemas Cinemark, exceto Cinemark Shopping Iguatemi (S&atilde;o Paulo -SP), Salas Prime do Shopping Cidade Jardim (S&atilde;o Paulo- SP) e demais &ldquo;salas premier&rdquo; a serem inauguradas.</p>
				<p>2.2. Os descontos acima descritos ter&atilde;o sua utiliza&ccedil;&atilde;o limitada de acordo com a seguinte categoriza&ccedil;&atilde;o do Programa de Relacionamento Vivo Valoriza:</p>
				
				<p>a) Clientes Vivo participantes do Vivo Valoriza, na categoria V1: concess&atilde;o de 10 (dez) Meia Vivo Valoriza, por cliente (CPF), por m&ecirc;s, limitado por 2 (duas) Meia Vivo Valoriza, por sess&atilde;o.<br />
				b) Clientes Vivo participantes do Vivo Valoriza, na categoria V2: concess&atilde;o de 4 (quatro) Meia Vivo Valoriza, por cliente (CPF), por m&ecirc;s, limitado por 2 (duas) Meia Vivo Valoriza, por sess&atilde;o.<br />
				c) Clientes Vivo participantes do Vivo Valoriza, na categoria V3: concess&atilde;o de 2 (duas) Meia Vivo Valoriza, por cliente (CPF), por m&ecirc;s, limitado por 2 (duas) Meia Vivo Valoriza, por sess&atilde;o.</p>
				<p>2.3. Os descontos acima descritos n&atilde;o s&atilde;o cumulativos, bem como as quantidades de ingressos n&atilde;o s&atilde;o cumulativas, ou seja, se o cliente n&atilde;o utilizar a quantidade de ingressos em um m&ecirc;s, n&atilde;o ser&aacute; transferido o residual para o pr&oacute;ximo m&ecirc;s.</p>
				<p>2.4. Os descontos da &ldquo;Meia Vivo Valoriza&rdquo;, s&atilde;o pessoais e intransfer&iacute;veis.</p>
				<p>2.5. Os referidos descontos n&atilde;o s&atilde;o cumulativos com outras promo&ccedil;&otilde;es, benef&iacute;cios e/ou descontos de qualquer natureza, inclusive para o participantes que j&aacute; tem direito &agrave; meia entrada garantida por lei (estudantes, menores de 12 anos, maiores de 60 anos).</p>
				<p>2.6. Os descontos n&atilde;o poder&atilde;o ser convertidos em dinheiro, s&atilde;o inegoci&aacute;veis e intransfer&iacute;veis a terceiros, sucessores ou herdeiros, sendo de uso exclusivo pelo cliente Vivo participante do programa de relacionamento Vivo Valoriza.</p>
				<p>2.7. Os descontos ser&atilde;o concedidos at&eacute; o termino do estoque de ingressos previstos no contrato da parceria Vivo e Rede de Cinemas Cinemark, sendo os participantes devidamente informados desta ocorr&ecirc;ncia.</p>
				<p>2.8. Clientes habilitados em planos de servi&ccedil;os Pessoa F&iacute;sica na modalidade m&oacute;vel Pr&eacute; Pago, ao realizar a recarga de R$25 (vinte e cinco) ou mais (disposta no item 1.2), ativam o direito de utilizar a quantidade de ingresso referente &agrave; sua categoria no Vivo Valoriza.</p>
				<p>2.9. Se o cliente realizar mais de uma recarga no valor de R$25 (vinte e cinco) ou mais, no m&ecirc;s, mant&eacute;m o direito a mesma quantidade de ingressos referente &agrave; sua categoria do Vivo Valoriza. O benef&iacute;cio que ter&aacute; pela realiza&ccedil;&atilde;o de recargas adicionais (R$25 ou mais), ser&aacute; o de estender o prazo da utiliza&ccedil;&atilde;o da quantidade de ingressos da sua categoria, pelo per&iacute;odo de 30 dias ap&oacute;s a &uacute;ltima recarga realizada.</p>
				<p>Exemplo: cliente Vivo Pr&eacute;, participante da categoria V2, que realiza recarga de R$25 no 5&ordm; dia do m&ecirc;s, tem direito a utilizar o benef&iacute;cio de desconto na parceria, at&eacute; o pr&oacute;ximo dia 5, limitado a 4 ingressos por m&ecirc;s. Caso realize uma nova recarga no valor de R$25 ou mais, ap&oacute;s a data da primeira recarga nesse valor, e ainda dentro do mesmo m&ecirc;s da primeira recarga, estende por mais 30 dias, a contar da segunda recarga, o prazo para utiliza&ccedil;&atilde;o do benef&iacute;cio, por&eacute;m, n&atilde;o recebe no mesmo m&ecirc;s mais 4 ingressos. T&atilde;o somente receber&aacute; o direito a mais quatro ingressos se realizar a recarga no valor de R$ 25,00 ou mais, no m&ecirc;s subsequente.</p>
				
				<p><strong>DA AQUISI&Ccedil;&Atilde;O DOS INGRESSOS MEIA VIVO VALORIZA</strong></p>
				
				<p>3.1. As promo&ccedil;&otilde;es &ldquo;Meia Vivo Valoriza&rdquo; somente poder&atilde;o ser adquiridas pelos participantes eleg&iacute;veis ao benef&iacute;cio nas bilheterias da Rede de Cinemas Cinemark participantes ou atrav&eacute;s dos demais canais de vendas, quando dispon&iacute;veis.</p>
				<p>3.2. Os clientes Vivo participantes do Vivo Valoriza, dever&atilde;o informar o n&uacute;mero de seu CPF (cadastrado no programa), para confirma&ccedil;&atilde;o e validade do direito a &ldquo;Meia Vivo Valoriza&rdquo;, limitado por categoria, por m&ecirc;s.</p>
				
				<p><strong>DAS DISPOSI&Ccedil;&Otilde;ES GERAIS</strong></p>
				
				<p>4.1. A Vivo reserva-se o direito de alterar, suspender ou mesmo encerrar o presente benef&iacute;cio mediante aviso pr&eacute;vio aos associados, com anteced&ecirc;ncia de 15 (quinze) dias, por meio de, comunicado no site, e-mail, envio de SMS, ou outro canal f&iacute;sico ou eletr&ocirc;nico disponibilizado para tal finalidade.</p>
				<p>4.2. A toler&acirc;ncia, omiss&atilde;o ou transig&ecirc;ncia da Vivo, n&atilde;o implicar&aacute; ren&uacute;ncia, ou modifica&ccedil;&atilde;o das condi&ccedil;&otilde;es expressas neste regulamento.</p>
				<p>4.3. A Vivo e/ou o programa Vivo Valoriza, poder&atilde;o estender os benef&iacute;cios no todo ou em parte, a seu exclusivo crit&eacute;rio, aos seus demais clientes, inclusive pessoas jur&iacute;dica ou quaisquer clientes, podendo ter ou n&atilde;o regras espec&iacute;ficas para tais clientes.</p>
				<p>4.4. A utiliza&ccedil;&atilde;o do desconto/benef&iacute;cio implica na aceita&ccedil;&atilde;o total e irrestrita pelo participante Vivo Valoriza das condi&ccedil;&otilde;es descritas neste regulamento, que &eacute; disponibilizado para consulta no site vivo.com.br/meuvivo.</p>
				<p>4.5. Eventuais d&uacute;vidas relacionadas ao benef&iacute;cio Meia Vivo Valoriza poder&atilde;o ser esclarecidas atrav&eacute;s do site vivo.com.br/meuvivo, mediante login do cliente e participa&ccedil;&atilde;o no programa e, d&uacute;vidas relacionadas ao programa de relacionamento Vivo Valoriza, poder&atilde;o ser esclarecidas atrav&eacute;s do site vivo.com.br/vivovaloriza.</p>
				<p>4.6. Vivo e Cinemark comprometem-se a utilizar as informa&ccedil;&otilde;es fornecidas pelos participantes apenas para garantir a efetiva valida&ccedil;&atilde;o e controle do uso do benef&iacute;cio.</p>
				<p>4.7. A responsabilidade pela venda de ingressos, pelas sess&otilde;es e pela exibi&ccedil;&atilde;o dos filmes &eacute; exclusiva da Rede de Cinemas Cinemark.</p>
				<p>4.8. Caso persistam d&uacute;vidas e questionamentos os participantes poder&atilde;o consultar os &oacute;rg&atilde;os de defesa do consumidor de sua regi&atilde;o.</p>
				<p>S&atilde;o Paulo, 20 de novembro de 2012.</p>
				<p>VIVO S.A</p>
				<p>&nbsp;</p>

			</div>
        </div>
      </div>
      <!-- /content -->
	</div>  
</body>
</html>