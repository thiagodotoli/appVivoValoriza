app.geo = function(){
	var privateProperties = {
		
	};

	return {
		init: function(){
			initiate_geolocation();  
			 function initiate_geolocation() {
		        if (navigator.geolocation)
		        {
		            navigator.geolocation.getCurrentPosition(handle_geolocation_query, handle_errors);
		        }
		        else
		        {
		            yqlgeo.get('visitor', normalize_yql_response);
		        }
		    }
		    function handle_errors(error)
		    {
		        switch(error.code)
		        {
		            case error.PERMISSION_DENIED: alert("user did not share geolocation data");yqlgeo.get('visitor', normalize_yql_response);
		            break;
		            case error.POSITION_UNAVAILABLE: alert("could not detect current position");yqlgeo.get('visitor', normalize_yql_response);
		            break;
		            case error.TIMEOUT: alert("retrieving position timedout");yqlgeo.get('visitor', normalize_yql_response);
		            break;
		            default: alert("unknown error");yqlgeo.get('visitor', normalize_yql_response);
		            break;
		        }
		    }
		    function normalize_yql_response(response)
		    {
		        if (response.error)
		        {
		            var error = { code : 0 };
		            handle_error(error);
		            return;
		        }
		        var position = {
		            coords :
		            {
		                latitude: response.place.centroid.latitude,
		                longitude: response.place.centroid.longitude
		            },
		            address :
		            {
		                city: response.place.locality2.content,
		                region: response.place.admin1.content,
		                country: response.place.country.content
		            }
		        };
		        handle_geolocation_query(position);
		    }
		    function handle_geolocation_query(position){
		       // console.log('Lat: ' + position.coords.latitude + ' ' +'Lon: ' + position.coords.longitude );
		        }       

              
		}
	};
	
}();