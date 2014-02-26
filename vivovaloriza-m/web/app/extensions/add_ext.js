app.ext = function(){
	var extensions = [
            //'geolocation/geolocation.js',
            'theme_switcher/theme_switcher.js',
            'notify/notify.js'];

	return {
		init: function(){
			//add all plugins to the app
			
			var noExtensions = extensions.length;
			
			for (var i = 0; i < noExtensions; i++) {
                            //console.log(extensions[i]);
                          
                            extensions[i] = app.url_path + 'web/app/extensions/' + extensions[i];
                            //console.log(app.url_path);
                               
                                
			}
			
			app.require(extensions,function(){ 
				//app.geo.init();
				app.theme_switcher.default_theme = 'App';
				app.theme_switcher.android_theme = 'Android';
				app.theme_switcher.iOS_theme = 'iOS';
				app.theme_switcher.winmob_theme = 'WindowsMob';
				app.theme_switcher.init();
			});
		}
	};
	
}();