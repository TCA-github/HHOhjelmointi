<%@include file="header.jsp" %>
<%@ page import="java.util.*"%>  
<%@ page import="java.text.DecimalFormat"%> 
<%@ page import="model.Vene"%> 
<%@ page import="java.util.ArrayList"%>  
<%! @SuppressWarnings("unchecked") %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset id="veneTiedot">
<form action="Servlet_TarjousVene" method="post" id="tarjoaLomake">
<%
Vene vene = null;
ArrayList<String> kuvat = null;
int id=0;
if(request.getAttribute("vene")!=null){
	vene = (Vene)request.getAttribute("vene");	
	id=vene.getVene_id();	
	kuvat = (ArrayList<String>)request.getAttribute("kuvat");	
}
%>
<div id="otsikko_1">
<%out.print(vene.getMerkki()+" "+vene.getMalli()+" "+vene.getVuosimalli());%>
</div>
<div id="hinta">
<%
DecimalFormat des = new DecimalFormat("0.00");
out.print(des.format(vene.getHintapyynto()));
%>
</div>
<br>
<%
for(int i=0;i<kuvat.size()&&i<3;i++){
	String kuva=kuvat.get(i); //vain 3 tärkeintä kuvaa
	kuva=kuva.replace("vene_"+id, "");
	out.println("<img src='images/uploaded/"+kuva+"' class='kuva' />");
}
%>
<div id="muutTiedot">
<label>Kuvaus:</label>
<div class="kuvaus">
<%out.print(vene.getKuvaus());%>
</div><br>
<label>Lisätietoja:</label>
<div class="kuvaus">
<%out.print(vene.getLisatietoja());%>
</div><br>
<label>Tarjouksen tekijä:</label>
<select name="omistaja" id="omistaja"></select><br>
<label>Tarjous:</label>
<input type="number" name="maara" id="maara" value=""><br>
<label>Voimassa päivään:</label>
<input type="text" name="voimassapaiva" id="voimassapaiva" value=""><br>
<label></label>	
<img src="images/accept.png" class="icon" id="tarjoaImg">
</div>
<input type="hidden" name="vene_id" value="<%out.print(vene.getVene_id());%>">
</form>
</fieldset>


<script>
$(document).ready(function(){
	$("#voimassapaiva").datepicker({ dateFormat: 'dd.mm.yy' });
	$("#otsikko_1").css({
		"display":"inline-block",
		"font-size": "30px", 
		
	});
	$("#hinta").css({
		"display":"inline-block",		
		"font-size": "30px",		
		"text-align":"left",
		"position": "absolute",
    	"left": "600px"
		
	});
	$(".kuva").css({
		"height": "150px", 
		"border-radius": "15px"
	});	
	$(".kuvaus").css({
		"display":"inline-block",	
		"height": "150px", 
		"width": "280px", 
		"border-radius": "15px",
		"padding-left": "10px",
		"border": "1px"
	});	
	$("#veneTiedot").css({
		"width": "700px", 
		"border-radius": "15px"
	});
	$.getJSON("Servlet_OmistajatAjax", function(result){
        $.each(result, function(i, field){
        	$("#omistaja").append("<option value='"+field.Asiakas_id+"'>"+field.Etunimi+" "+field.Sukunimi+ " (As.no "+field.Asiakas_id+")</option>");            
        });
    });
	$("#tarjoaImg").click(function(){		
		if($("#tarjoaLomake").valid()){
			document.forms["tarjoaLomake"].submit();
		}		
	});
	$("#tarjoaLomake").validate({						
		rules: {
			maara:  {
				required: true,
				minlength: 1,
				number: true
			},	
			voimassapaiva:  {
				required: true,
				minlength: 1				
			}
		},
		messages: {
			maara: {     
				required: "Puuttuu",
				minlength: "Liian lyhyt",
				number: "Ei kelpaa"	
			},
			voimassapaiva: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			}
		},			
		submitHandler: function (form) {	
			alert("moi");
			document.forms["tarjoaLomake"].submit();
		}		
	});    
});
</script>
</body>
</html>