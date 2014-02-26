<%@taglib uri="/struts-tags" prefix="s" %>

<html> 
	<head> 
		<title>App Name</title> 
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		
		<link rel="stylesheet" href="<s:url value='/web/assets/css/jquery.mobile-1.1.0-rc.1.min.css'/>" />
		<link rel="stylesheet" href="<s:url value='/web/assets/css/AppStyles.css'/>" />
		<link rel="stylesheet" href="<s:url value='/web/assets/css/ytLoad.jquery.css'/>" />
	</head> 
<body> 
	
	<div data-role="page" data-module="sample">
	
		<div data-role="header" data-position="fixed" data-fullscreen="true">
			<h1>Vivo Valoriza</h1>
		</div><!-- /header -->
	
		 <div data-role="content">
			<ul data-role="listview" data-divider-theme="b" data-inset="true">
		    <li data-role="list-divider" role="heading">
		        Espetáculos com Desconto
		    </li>

				<s:iterator value="especatuloDesconto">
					<li data-theme="c">
						<a href='exibirDetalhePecaTeatro.action?cnSeq=<s:property value="cnSeq"/>' >
							<s:property value="anTitulo"/>
	          </a>    
	        </li>

				</s:iterator>

	    </ul>
    </div><!-- /content -->
		<!--</div>-->
	
	</div><!-- /page -->

	<script src="<s:url value='/web/assets/js/libs/jquery-1.7.1.min.js'/>"></script>
	<script src="<s:url value='/web/assets/js/libs/jquery.mobile-1.1.0-rc.1.js'/>"></script>
	<script type="text/javascript" src="<s:url value='/web/assets/js/libs/ytLoad.jquery.js'/>"></script>
	<script type="text/javascript" src="<s:url value='/web/assets/js/libs/jquery.transit.js'/>"></script>

	<script src="<s:url value='/web/assets/js/libs/require.js'/>"></script>
	<script src="<s:url value='/web/assets/js/VivoValoriza.js'/>"></script>
</body>
</html>