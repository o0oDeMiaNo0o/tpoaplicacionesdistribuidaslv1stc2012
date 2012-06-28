function getRequestObject()
{
    if (window.XMLHttpRequest) { // Mozilla, Safari,...
        http_request = new XMLHttpRequest();
        if (http_request.overrideMimeType) {
           http_request.overrideMimeType('text/xml');
        }
     } else if (window.ActiveXObject) { // IE
        try {
           http_request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
           try {
              http_request = new ActiveXObject("Microsoft.XMLHTTP");
           } catch (e) {}
        }
     }
     return http_request;
}

/**
 * @function sendAjaxReq Realiza una peticion AJAX
 * @param type Tipo de Request. Debe ser GET o POST.
 * @param url Destino del request.
 * @param params Parametros. Array Asociativo clave->valor.
 * @param succed Funcion
 * @param failed Funcion
 */
function sendAjaxReq(type,url,params,succed,failed) {
	var req = getRequestObject();
	req.onreadystatechange = processRequest;
	
	var procParamas;
        var prop;
	if(type == "GET")
	{
		procParamas = "?";
		for(prop in params)
		{
			procParamas += prop+"="+params[prop]+"&";
		}
		procParamas = procParamas.substr(0,procParamas.length-1);
		
		req.open(type, url+procParamas, true);
		req.send(null);
	}
	else if(type == "POST")
	{
		procParamas = "";
		for(prop in params)
		{
			procParamas += prop+"="+params[prop]+"&";
		}
		procParamas = procParamas.substr(0,procParamas.length-1);
		
		req.open(type, url, true);
		//Cambio el Header para especificar que mando parametros por POST
		req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		req.setRequestHeader("Content-length", procParamas.length);
		req.setRequestHeader("Connection", "close");
		
		req.send(procParamas);
	}
	
	function processRequest(){
		if (req.readyState == 4){
			if(req.status == 200){
				succed(req.responseText,req);
			}else if(req.status > 400) {
				var msg = "Error:"+req.status+" - "+req.statusText;
				if(failed != null)
				{
					failed(msg,req);
				}else{
					alert(msg);
				}
			}
		}
	}
}

