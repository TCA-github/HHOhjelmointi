<%@include file="header.jsp" %>
<%@ page import="java.util.*"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//***ALKU TULEE header.jsp tiedostosta******************************************************************************************************
%>
<!-- div venemerkkien lisäämistä varten. Piilotettu.******************************************************* --> 	
<div id="merkinLisays">
	<label>Uusi merkki:</label>
	<input type="text" name="uusiMerkki" id="uusiMerkki"/>	
	<img src="images/accept.png" class="icon_mini" id="lisaaUusiMerkki">	
	<img src="images/delete.png" class="icon_mini" id="peruutaUusiMerkki">	
</div>

<!-- div venemallien lisäämistä varten. Piilotettu.******************************************************* --> 	
<div id="mallinLisays">
	<label>Merkki:</label><span id="mallinMerkki"></span>
	<br>
	<label>Mallin nimi:</label>
	<input type="text" name="uusiMalli" id="uusiMalli"/><br>
	<label>Pituus:</label>
	<input type="range" id="pituus" min="2" max="20" step="0.05">
	<img src="images/back.png" class="icon_mini" id="vahennaPituus">
	<img src="images/next.png" class="icon_mini" id="lisaaPituus">
	<span id="naytaPituus"></span>	
	<br>
	<label>Leveys:</label>
	<input type="range" id="leveys" min="1" max="6" step="0.05">
	<img src="images/back.png" class="icon_mini" id="vahennaLeveys">
	<img src="images/next.png" class="icon_mini" id="lisaaLeveys">
	<span id="naytaLeveys"></span>	
	<br>
	<label>Paino:</label>
	<input type="range" id="paino" min="100" max="30000" step="100">
	<img src="images/back.png" class="icon_mini" id="vahennaPaino">
	<img src="images/next.png" class="icon_mini" id="lisaaPaino">
	<span id="naytaPaino"></span>	
	<br>
	<label>Venetyyppi:</label>
	<select id="venetyypit"></select>
	<br><br>
	<label></label>
	<img src="images/accept.png" class="icon" id="lisaaUusiMalli">	
	<img src="images/delete.png" class="icon" id="peruutaUusiMalli">	
</div>
<!-- Veneen tietojen lisääminen.************************************************************************** --> 	
<fieldset id="veneTiedot">
	<legend>Veneen tiedot:</legend>
	<form action="Servlet_UusiVene" method="post" id="uusiLomake">
		<label>Merkki:</label>
			<select name="merkki" id="merkki"></select><img src="images/add.png" id="lisaaMerkki" class="icon_mini">&nbsp;<span id="merkkiVastaus"></span><br>	
		<label>Malli:</label>
			<select name="malli" id="malli"></select><img src="images/add.png" id="lisaaMalli" class="icon_mini">&nbsp;<span id="malliVastaus"></span><br>	
		<label>Vuosimalli:</label>
		<select name="vuosimalli" id="vuosimalli">
		<%
		//Vuoden täyttämisen olisi aivan yhtä hyvin voinut tehdä JavaScriptillä
		GregorianCalendar gcal = new GregorianCalendar();
		int vuosiMax=gcal.get(Calendar.YEAR)+1;
		for(int i=1901;i<=vuosiMax;i++){
			if(i==vuosiMax-10){ //Oletusvalinta 9 vuotta vanha vene
				out.println("<option selected value='"+i+"'>"+i+"</option>");
			}else{
				out.println("<option value='"+i+"'>"+i+"</option>");
			}			
		}
		%>
		</select><br>
		<label>Ostohinta:</label>	
			<input type="number" name="ostohinta" id="ostohinta" value=""><br>
		<label>Hintapyyntö:</label>	
			<input type="number" name="hintapyynto" id="hintapyynto" value=""><br>
		<label>Tiukka hinta:</label>	
			<input type="number" name="tiukkahinta" id="tiukkahinta" value=""><br>
		<label>Tulopäivä:</label>
			<input type="text" name="tulopaiva" id="tulopaiva" value=""><br>
		<label>Omistaja:</label>
			<select name="omistaja" id="omistaja"></select><br>
		<label></label>
			<input type="checkbox" name="valitysvene" id="valitysvene" value="1">Välitysvene<br>	
		<label>Kuvaus:</label>	
			<textarea rows="10" cols="30" name="kuvaus" id="kuvaus"></textarea><br>
		<label>Lisätietoja:</label>	
			<textarea rows="10" cols="30" name="lisatietoja" id="lisatietoja"></textarea><br>
		<label></label>	
			<img src="images/accept.png" class="icon" id="lisaaImg">
	</form>
</fieldset>

<script>
$(document).ready(function(){
	//$("#lisaaImg").hide();
	$("#merkinLisays").hide();
	$("#mallinLisays").hide();
	$("#lisaaMalli").hide();
	$("#pituus").val(7);
	$("#naytaPituus").html(7);
	$("#leveys").val(3);
	$("#naytaLeveys").html(3);
	$("#paino").val(3000);
	$("#naytaPaino").html(3000);
	$("#tulopaiva").datepicker({ dateFormat: 'dd.mm.yy' });
	
	$("#naytaPituus, #naytaLeveys, #naytaPaino").css({
		"display": "inline-block",
		"width": "50px"					
	});	
	$("#veneTiedot").css({
		"width": "500px", 
		"border-radius": "15px"	
	});	
	$("#pituus, #leveys, #paino").css({
		"width": "90px",
	});
	$("#ostohinta, #hintapyynto, #tiukkahinta, #tulopaiva").css({
		"width": "90px",
	});
	$("#merkki, #malli").css({
		"width": "150px",
	});
	$("#merkki").append("<option value='-1'>Valitse merkki</option>");  
	$.getJSON("Servlet_VenemerkitAjax", function(result){
        $.each(result, function(i, field){
        	$("#merkki").append("<option value='"+field.VMerkki_id+"'>"+field.VMerkki+"</option>");            
        });
    });
	$.getJSON("Servlet_VenetyypitAjax", function(result){
        $.each(result, function(i, field){
        	$("#venetyypit").append("<option value='"+field.Tyyppi_id+"'>"+field.Tyyppi+"</option>");            
        });
    });
	$.getJSON("Servlet_OmistajatAjax", function(result){
        $.each(result, function(i, field){
        	$("#omistaja").append("<option value='"+field.Asiakas_id+"'>"+field.Etunimi+" "+field.Sukunimi+ " (As.no "+field.Asiakas_id+")</option>");            
        });
    });
	$("#merkki").change(function(){			
		var merkki_id = $(this).val(); 
		$.getJSON("Servlet_VenemallitAjax?merkki_id=" + merkki_id, function(result){
			$("#malli").html("");
			$.each(result, function(i, field){
	        	$("#malli").append("<option value='"+field.Malli_id+"'>"+field.Malli+"</option>");            
	        });			
	    });
		$("#mallinMerkki").html($("#merkki option:selected").text());
		$("#merkki option[value='-1']").remove(); //poistetaan "Valitse merkki" vaihtoehto
		$("#lisaaMalli").show();
	});
	$("#pituus").change(function(){	
		$("#naytaPituus").html($("#pituus").val());
	});
	$("#leveys").change(function(){	
		$("#naytaLeveys").html($("#leveys").val());
	});
	$("#paino").change(function(){	
		$("#naytaPaino").html($("#paino").val());
	});
	$("#lisaaImg").click(function(){		
		if($("#uusiLomake").valid()){
			document.forms["uusiLomake"].submit();
		}		
	});
	$("#vahennaPituus").click(function(){
		document.getElementById("pituus").stepDown(1);
		$("#naytaPituus").html($("#pituus").val());
	});
	$("#lisaaPituus").click(function(){
		document.getElementById("pituus").stepUp(1);
		$("#naytaPituus").html($("#pituus").val());
	});
	$("#vahennaLeveys").click(function(){
		document.getElementById("leveys").stepDown(1);
		$("#naytaLeveys").html($("#leveys").val());
	});
	$("#lisaaLeveys").click(function(){
		document.getElementById("leveys").stepUp(1);
		$("#naytaLeveys").html($("#leveys").val());
	});
	$("#vahennaPaino").click(function(){
		document.getElementById("paino").stepDown(1);
		$("#naytaPaino").html($("#paino").val());
	});
	$("#lisaaPaino").click(function(){
		document.getElementById("paino").stepUp(1);
		$("#naytaPaino").html($("#paino").val());
	});
	$("#lisaaMerkki").click(function(event){
		$("#merkinLisays").css({
			"width": "320px", 
			"border-radius": "15px",
			"background-color": "#4CAF50",		
			"color": "white",
			"text-align": "center",
			"padding": "10px",
			"border": "1px solid black",
			"position": "absolute",
			"left": event.pageX+30 +"px",
			"top": event.pageY-10 +"px"
		});	
		$("#merkinLisays").show();	
		$("#uusiMerkki").focus();	
	});
	$("#lisaaUusiMerkki").click(function(event){	
		if($("#uusiMerkki").val().length>1){			
			$.ajax({url: "Servlet_LisaaMerkki?merkki="+$("#uusiMerkki").val(), success: function(result){	        
				if(result==1){				
		        	$("#merkkiVastaus").html("Merkki lisätty.");	        	
		        }else{	        	
		        	$("#merkkiVastaus").html("Merkki on jo kannassa.");		        	
		        }	
				setTimeout(function(){$("#merkkiVastaus").html("");}, 5000);
				$("#malli option").remove();
				$("#merkki option").remove();
				$("#merkki").append("<option value='-1'>Valitse merkki</option>");  
				$.getJSON("Servlet_VenemerkitAjax", function(result){
			        $.each(result, function(i, field){
			        	$("#merkki").append("<option value='"+field.VMerkki_id+"'>"+field.VMerkki+"</option>");            
			        });
			    });
		    }});		
		}
		$("#merkinLisays").hide();		
	});	
	$("#peruutaUusiMerkki").click(function(event){
		$("#merkinLisays").hide();	
	});	
	$("#lisaaMalli").click(function(event){
		$("#mallinLisays").css({
			"width": "400px", 
			"border-radius": "15px",
			"background-color": "#4CAF50",		
			"color": "white",
			"padding": "10px",
			"border": "1px solid black",
			"position": "absolute",
			"left": event.pageX+30 +"px",
			"top": event.pageY-10 +"px"
		});	
		$("#mallinLisays").show();	
		$("#uusiMalli").focus();	
	});
	$("#lisaaUusiMalli").click(function(event){	
		if($("#uusiMalli").val().length>=1){
			var urli ="Servlet_LisaaMalli?malli="+$("#uusiMalli").val() +"&merkki_id=" + $("#merkki option:selected").val() + "&pituus="+$("#pituus").val()+"&leveys="+$("#leveys").val()+"&paino="+$("#paino").val() + "&tyyppi_id=" +$("#venetyypit option:selected").val();
			//alert(urli);
			$.ajax({url:urli , success: function(result){	        
				if(result==1){				
		        	$("#malliVastaus").html("Malli lisätty.");	        	
		        }else{	        	
		        	$("#malliVastaus").html("Malli on jo kannassa.");		        	
		        }	
				setTimeout(function(){$("#malliVastaus").html("");}, 5000);
				$("#malli option").remove();
				$.getJSON("Servlet_VenemallitAjax?merkki_id=" + $("#merkki option:selected").val(), function(result){
					$.each(result, function(i, field){
			        	$("#malli").append("<option value='"+field.Malli_id+"'>"+field.Malli+"</option>");            
			        });			
			    });
		    }});	
			
		}		
		$("#mallinLisays").hide();	
	});	
	$("#peruutaUusiMalli").click(function(event){
		$("#mallinLisays").hide();	
	});	
	 $("#uusiLomake").validate({						
		rules: {
			merkki:  {
				required: true,
				minlength: 1				
			},	
			malli:  {
				required: true,
				minlength: 1				
			},
			ostohinta:  {
				required: true,
				number: true				
			},	
			hintapyynto:  {
				required: true,
				number: true				
			},
			tiukkahinta:  {
				required: true,
				number: true				
			}	
		},
		messages: {
			merkki: {     
				required: "Puuttuu",
				minlength: "Liian lyhyt"			
			},
			malli: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			ostohinta: {
				required: "Puuttuu",
				number: "Ei kelpaa"				
			},
			hintapyynto: {
				required: "Puuttuu",
				number: "Ei kelpaa"				
			},	
			tiukkahinta: {
				required: "Puuttuu",
				number: "Ei kelpaa"				
			}
		},			
		submitHandler: function (form) {	
			alert("moi");
			document.forms["uusiLomake"].submit();
		}		
	});    
});
</script>
</body>
</html>