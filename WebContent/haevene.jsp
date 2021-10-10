<%@include file="header.jsp" %>
<%@ page import="model.Vene"%>  
<%@ page import="java.util.ArrayList"%>  
<%! @SuppressWarnings("unchecked") %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String hakusana;
if(session.getAttribute("hakusanavene")!=null){
	hakusana=session.getAttribute("hakusanavene").toString();
}else{
	hakusana="";
}
//***ALKU TULEE header.jsp tiedostosta******************************************************************************************************
%>
<img src="images/add.png" title="Uusi vene" class="icon" id="uusiVene">
<span class='otsikkoTeksti'>Veneet</span>
<br><br>
<fieldset id="hakuAlue">
	<legend>Haku:</legend>	
	<input type="text" name="hakuSana" id="hakuSana" value="<%out.println(hakusana);%>">
	<img src="images/search.png" title="Etsi" class="icon" id="haeVene">
</fieldset>
<fieldset id="tulosAlue">
	<legend>Tulos:</legend>
	<div id="poistonVahvistus">
	<span id="poistettavaNimi"></span>
	<img src="images/accept.png" title="Poista" class="icon" id="vahvistaPoisto">
	<img src="images/delete.png" title="Peruuta" class="icon" id="peruutaPoisto">
	</div>
	<table id="tiedotTaulu">
		<thead>
			<tr>
				<th>Vene.No</th>
				<th>Vene</th>
				<th>Hinta</th>	
				<th></th>			
			</tr>
		</thead>
		<tbody>
		<%
		if(request.getAttribute("veneet")!=null){	
			ArrayList<Vene> veneet = (ArrayList<Vene>)request.getAttribute("veneet");
			for(int i=0;i<veneet.size();i++){
				out.print("\n<tr>");
				out.print("<td class='vene_id' id='tarjoa_"+veneet.get(i).getVene_id()+"'><u>" + veneet.get(i).getVene_id() + "</u></td>");
				out.print("<td>" + veneet.get(i).getMerkki() +" "+ veneet.get(i).getMalli() + "</td>");
				out.print("<td>" + veneet.get(i).getHintapyynto()+ "</td>");	
				out.print("<td>");
				out.print("\n<img src='images/modify.png' class='icon muokkaa' id='muokkaa_"+veneet.get(i).getVene_id()+"' name='"+veneet.get(i).getMerkki()+" "+veneet.get(i).getMalli()+"' title='Muokkaa'>");
				out.print("\n<img src='images/delete.png' class='icon poista' id='poista_"+veneet.get(i).getVene_id()+"' name='"+veneet.get(i).getMerkki()+" "+veneet.get(i).getMalli()+"' title='Poista'>");
				out.print("\n<img src='images/euro.png' class='icon tarjoa' id='tarjoa_"+veneet.get(i).getVene_id()+"' name='"+veneet.get(i).getMerkki()+" "+veneet.get(i).getMalli()+"' title='Tarjoa'>");
				out.print("</td>");
				out.print("</tr>");
			}	
		}
		%>
		</tbody>
	</table>
</fieldset>
<script>
$(document).ready(function(){
	$("#poistonVahvistus").hide();
		
	$("#hakuAlue").css({
		"width": "210px", 
		"border-radius": "15px"
	});
	
	$("#tulosAlue").css({
		"width": "400px", 
		"border-radius": "15px"
	});	
	
	$(".vene_id").click(function(){		
		document.location="Servlet_TarjousVene?Vene_id=" + $(this)[0].id;	
	});
	
	$("#uusiVene").click(function(){
		document.location="uusivene.jsp";	
	});	
	
	$("#haeVene").click(function(){
		document.location=encodeURI("Servlet_HaeVeneet?hakusana=" + $("#hakuSana").val());	
	});
	
	$(".muokkaa").click(function(){
		//Objektin ominaisuuksien ja arvojen läpikäynti (ei tarvita tässä tapauksessa, vain esimerkkinä)
		/*
		var obj = $(this); 	
		for(var key in obj) {
			console.log('key: ' + key + '\n' + 'value: ' + obj[key]);
		}
		*/		
		document.location="Servlet_MuokkaaVene?Vene_id=" + $(this)[0].id;	
	});
	var poistettava_id;	
	$(".poista").click(function(event){	//event kantaa mukanaan tapahtuman, mm. klikkauksen sijainnin	
		poistettava_id=$(this)[0].id;
		$("#poistettavaNimi").html("Poista " + $(this)[0].name + "?<br>");
		$("#poistonVahvistus").css({ 
			"width": "170px", 
			"height": "50px",
			"background-color": "#4CAF50",
			"border-radius": "15px",
			"color": "white",
			"text-align": "center",
			"padding": "10px",
			"border": "1px solid black",
			"position": "absolute",
			"left": event.pageX +"px",
			"top": event.pageY +"px"
		});			
		$("#poistonVahvistus").show();
	});
	
	$("#vahvistaPoisto").click(function(){
		document.location="Servlet_PoistaVene?Vene_id="+poistettava_id;
	});
	$(".tarjoa").click(function(){		
		document.location="Servlet_HaeTarjoukset?Vene_id=" + $(this)[0].id;	
	});
	
	$("#peruutaPoisto").click(function(){
		$("#poistonVahvistus").hide();
	});
	
	
});
</script>
</body>
</html>