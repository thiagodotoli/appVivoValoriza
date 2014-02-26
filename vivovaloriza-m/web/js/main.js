var $ = jQuery.noConflict();


var app = function(){
	var geocoder;
	
	var getDevice = function(){
		//Sniff the OS, (naughty but necessary for some functionality)
		if((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i))) {
			app.device.os = 'iOS';
			app.device.type = 'phone';
		}
		
		if((navigator.userAgent.match(/iPad/i))) {
			app.device.os = 'iOS';
			app.device.type = 'tablet';
		}
	
		if((navigator.userAgent.match(/Android/i))) {
			app.device.os = 'Android';
			if((navigator.userAgent.match(/Mobile/i))) {
				app.device.type = 'phone';
			}
			else{
				app.device.type = 'tablet';
			}
		}
		
		if((navigator.userAgent.match(/Windows Phone OS/i))) {
			app.device.os = 'Windows Mobile';
			app.device.type = 'phone'; //Assume is phone as I cant see any Windows Mobile phones on market
		}	
		console.log(app.device.os+" - "+app.device.type);
	};
	
	
	
	var styleFix = function(){
		//There is some functionality in jQuery Mobile which is not App like, we fix this in both the CSS and JS
		$('.ui-footer').removeClass('slideup');
		$('.ui-header').removeClass('slidedown');
		
		$('.ui-page-footer-fullscreen.ui-page-header-fullscreen .ui-content').css('padding-bottom',$('.ui-page-footer-fullscreen .ui-footer').height() + 11);
	};
	
	
	
	var loadStyleSheet = function( path, id, fn, scope ) {
	   var head = document.getElementsByTagName( 'head' )[0], // reference to document.head for appending/ removing link nodes
	       link = document.createElement( 'link' );           // create the link node
		   link.setAttribute( 'href', path );
		   link.setAttribute( 'rel', 'stylesheet' );
		   link.setAttribute( 'type', 'text/css' );
		   link.setAttribute( 'id', id);
	
	   var sheet, cssRules;
	// get the correct properties to check for depending on the browser
	   if ( 'sheet' in link ) {
	      sheet = 'sheet'; cssRules = 'cssRules';
	   }
	   else {
	      sheet = 'styleSheet'; cssRules = 'rules';
	   }
	
	   var interval_id = setInterval( function() {                    // start checking whether the style sheet has successfully loaded
	          try {
	             if ( link[sheet] && link[sheet][cssRules].length ) { // SUCCESS! our style sheet has loaded
	                clearInterval( interval_id );                     // clear the counters
	                clearTimeout( timeout_id );
	                fn.call( scope || window, true, link );           // fire the callback with success == true
	             }
	          } catch( e ) {} finally {}
	       }, 10 ),                                                   // how often to check if the stylesheet is loaded
	       timeout_id = setTimeout( function() {       // start counting down till fail
	          clearInterval( interval_id );            // clear the counters
	          clearTimeout( timeout_id );
	          head.removeChild( link );                // since the style sheet didn't load, remove the link node from the DOM
	          fn.call( scope || window, false, link ); // fire the callback with success == false
	       }, 15000 );                                 // how long to wait before failing
	
	   head.appendChild(link);  // insert the link node into the DOM and start loading the style sheet
	
	   return link; // return the link node;
	};
	
	return {
		'url_path': '', 
		'theme':'',
		'device':{'os':'','type':''},
		init: function(event, eventData){
			    
			$.ytLoad();
			//Initialise the application page
			var module_name = $(eventData.toPage).attr('data-module');
			var javascript_required = module_name +'.js';
			
			if(app.url_path === ''){
				app.url_path = window.location.href.replace(/app\/.*?$/, '').replace('index.html','');
			}
			
			console.log(app.url_path);
			
			getDevice();
			
			
			
			
			//Load the plugins into the app
			app.require([app.url_path + 'web/app/extensions/add_ext.js'],function(){ 
				
				//Execute extentions
				app.ext.init();
				
				//Styling
				app.updateTheme();
				
				//Each module should have a javascript file, we pull this in here
				app.require([javascript_required],function(){ 
					window[module_name].init(eventData);
				});
			
			});
			
		},
		require: function(items, callback){
			require(items, callback);
		},
		updateTheme: function(){
			//load theme
			if(app.theme != ''){
				if($('head #appTheme').length){
					$('head #appTheme').remove();
				}
				
				loadStyleSheet(app.url_path + 'web/themes/' + app.theme + '/style.css','appTheme', function( success, link ) {
				   if ( success ) {
				      styleFix();
				      // code to execute if the style sheet was loaded successfully
				   }
				   else {
				      console.log(link);
				      console.log('error');
				      // code to execute if the style sheet failed to successfully
				   }
				},this);
			
			}
			
			
			
		},
		splash: function(){
			
			//chamando a funçao de geolocalização durante o splash 
			app.initializeGeo();
			
			
			//Get the latitude and the longitude;
			 setTimeout(function(){
				 
				// console.log("--splash");
	                         
	             $("#splash").fadeOut('fast', function() {
	                $("#logonVivoFixo").fadeIn('fast', function() {});
	                
	             });
		    }, 1500);
		},
		home: function(){
			 
			app.deviceSize();
			app.initializeGeo();
			
		},
		deviceSize: function(){
			var height = $(window).innerHeight();
			var width = $(window).innerWidth();
			
			if (isNaN(window.innerHeight)) {
				width = document.documentElement.clientWidth;
				height = document.documentElement.clientHeight;
			}
			
			
			//console.log("height="+height);
			//console.log("width="+width);
			$('#splash').css('height', height);
			
			
			
		/*	$('#body').css('height', height-55);

			if (ua.indexOf('ipad')>=0){
				$('#resultsBox, #body').height('auto');
				
			}else{
				$('#resultsBox').height(height-$('#nav').height()-$('#statusMonitor').height()-resultsOffset);
				$('#searchSplash').height(height-$('#header').height()-$('#status').height()-70);	
				if ($('#resultsBox').hasClass('resultsBoxStatic')) $('#resultsBox').height(height-$('#header').height()-115);
			}
		*/
		},
		

		show:function (element){

			element.css('display', 'block');
			setTimeout(function(){element.removeClass('hidden').addClass('visible')}, 10);
		},
		hide:function (element){
			element.removeClass('visible').addClass('hidden');
			setTimeout(function(){element.css('display', 'none'), 300});
		
		},
		 replaceText: function() {
		    var jthis = $(this);
		    $("p").each(function() { 
		    	console.log("teste"+$(this));
		        if(jthis.children().length==0) { 
		            jthis.text(jthis.text().replace('<br />', 'Name:')); 
		        } 
		    });
		},
		isMobile:function(){

			(function(a){(jQuery.browser=jQuery.browser||{}).mobile=/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(a.substr(0,4))})(navigator.userAgent||navigator.vendor||window.opera);
			
			
			if (!jQuery.browser.mobile){
				window.location.href = "http://www.vivo.com.br/portalweb/appmanager/env/web#";
			}

			
		},
		homeButton: function (){
			var addToHomeConfig = {
					animationIn: 'bubble',
					animationOut: 'drop',
					lifespan:10000,
					expire:2,
					touchIcon:true,
					message:'This is a custom message. Your device is an <strong>%device</strong>. The action icon is `%icon`.',
				};
			console.log(addToHomeConfig);
		},
		
		
		
		
		  
		 successFunction: function (position) {
		    var lat = position.coords.latitude;
		    var lng = position.coords.longitude;
		    app.codeLatLng(lat, lng)
		},
		
		 errorFunction: function (){
		    alert("Geocoder failed");
		},
		
		  initializeGeo: function (){
		    geocoder = new google.maps.Geocoder();
		
		    if (navigator.geolocation) {
			    navigator.geolocation.getCurrentPosition(app.successFunction, app.errorFunction);
			} 
		
		  },
		
		   codeLatLng: function(lat, lng) {
		
		    var latlng = new google.maps.LatLng(lat, lng);
		    geocoder.geocode({'latLng': latlng}, function(results, status) {
		      if (status == google.maps.GeocoderStatus.OK) {
		      //console.log(results)
		        if (results[1]) {
		         //formatted address
		         //alert(results[0].formatted_address)
		        //find country name
		             for (var i=0; i<results[0].address_components.length; i++) {
		            for (var b=0;b<results[0].address_components[i].types.length;b++) {
		
		            //there are different types that might hold a city admin_area_lvl_1 usually does in come cases looking for sublocality type will be more appropriate
		                if (results[0].address_components[i].types[b] == "administrative_area_level_1") {
		                    //this is the object you are looking for
		                    city= results[0].address_components[i];
		                    break;
		                }
		            }
		        }
		        //city data
		        console.log(city.short_name + " " + city.long_name);
		        var uf = city.short_name;
		       
		        	
		        } else {
		          alert("No results found");
		        }
		      } else {
		        alert("Geocoder failed due to: " + status);
		      }
		    });
		  }
		
		
		
	};
	
}();

$(document.body).live('pagechange', app.init);

$(document.body).on('pageshow', '[data-role=page]', app.deviceSize);


 //$(document.body).on('pageshow', '[data-role=page]', app.isMobile);

//$(document.body).on('pageshow', '[data-role=page]', app.replaceText);

 