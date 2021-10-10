<%@include file="header.jsp" %>
<%@ page import="java.util.*"%>  
<%@ page import="java.text.*"%> 
<%@ page import="model.Tarjous"%> 
<%@ page import="model.Asiakas"%> 
<%@ page import="model.Vene"%> 
<%@ page import="helper.Formatoija"%> 
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
<img src="images/add.png" title="Uusi tarjous" class="icon" id="uusiTarjous">
Uusi tarjous<br><br>
<%
Vene vene = null;
if(request.getAttribute("vene")!=null){
	vene = (Vene)request.getAttribute("vene");	
}
%>
<div id="otsikko_1">
<%out.print(vene.getMerkki()+" "+vene.getMalli()+" "+vene.getVuosimalli());%>
</div>
<div id="hinta">
<%
DecimalFormat des = new DecimalFormat("0.00");
out.print(des.format(vene.getHintapyynto()) + " ("+des.format(vene.getTiukkahinta())+")");
%>
</div>
<fieldset id="tarjousTiedot">
<table border="0" id="tiedotTaulu">
<thead>
<tr>
<th>No.</th>
<th>Tarjous</th>
<th>Tekopäivä</th>
<th>Voimassapäivä</th>
<th></th>
<th>Asiakas</th>
<th>Hyväksy</th>
<th>Poista</th>
</tr>
</thead>
<tbody>
<%
boolean myyty=false;
Formatoija dForm = new Formatoija();
if(request.getAttribute("tarjoukset")!=null){	
			ArrayList<Tarjous> tarjoukset = (ArrayList<Tarjous>)request.getAttribute("tarjoukset");
			ArrayList<Asiakas> asiakkaat = (ArrayList<Asiakas>)request.getAttribute("asiakkaat");
			for(int i=0;i<tarjoukset.size();i++){				
				if(tarjoukset.get(i).getMyyntipaiva()!=null){					
					myyty=true;
					break;
				}
			}
			String huom;
			for(int i=0;i<tarjoukset.size();i++){	
				huom="";
				if(tarjoukset.get(i).getMyyntipaiva()!=null){
					out.print("<tr class='myyty'>");					
				}else if(tarjoukset.get(i).getVoimassapaiva().compareTo(new Date())<0){//-1=ohitettu,0=sama,1=tulossa. new Date() pitää sisällään myös kellonajan. Kannasta tulee aika 0:00.
					out.print("<tr class='ohiPaiva'>");
					huom="!";
				}else{
					out.print("<tr>");					
				}
				out.print("<td>"+(i+1)+".</td>");
				out.print("<td>"+des.format(tarjoukset.get(i).getTarjous())+"</td>");
				out.print("<td>"+dForm.muutaPaivays(tarjoukset.get(i).getAikaleima())+"</td>");
				out.print("<td>"+dForm.muutaPaivays(tarjoukset.get(i).getVoimassapaiva())+"</td>");
				out.print("<td>"+huom+"</td>");
				out.print("<td title='"+asiakkaat.get(i).getPuhelin()+"'>"+asiakkaat.get(i).getEtunimi()+" "+asiakkaat.get(i).getSukunimi()+"</td>");
				if(!myyty){
					out.print("<td><img src='images/accept.png' class='icon hyvaksy' id='hyvaksy_"+tarjoukset.get(i).getTarjous_id()+"'></td>");	
				}else{
					if(tarjoukset.get(i).getMyyntipaiva()!=null){
						out.print("<td>"+dForm.muutaPaivays(tarjoukset.get(i).getMyyntipaiva())+"</td>");
					}else{
						out.print("<td></td>");
					}					
				}
				out.print("<td><img src='images/delete.png' class='icon poista' id='poista_"+tarjoukset.get(i).getTarjous_id()+"'></td>");
				out.print("</tr>");
			}
}
%>
</tbody>
</table>
</fieldset>
<div id="poistonVahvistus">
<span id="poistettavaNimi"></span>
<img src="images/accept.png" title="Poista" class="icon" id="vahvistaPoisto">
<img src="images/delete.png" title="Peruuta" class="icon" id="peruutaPoisto">
</div>
<div id="hyvaksymisenVahvistus">
<span id="hyvaksyttavaNimi"></span>
<img src="images/accept.png" title="Poista" class="icon" id="vahvistaHyvaksy">
<img src="images/delete.png" title="Peruuta" class="icon" id="peruutaHyvaksy">
</div>
<script>
$(document).ready(function(){
	$("#poistonVahvistus").hide();
	$("#hyvaksymisenVahvistus").hide();
	$("#tarjousTiedot").css({
		"width": "700px", 
		"border-radius": "15px"
	});
	$("#otsikko_1").css({
		"display":"inline-block",
		"font-size": "30px", 
		
	});
	
	$(".ohiPaiva").css({
		"color": "red"
		
	});
	$(".myyty").css({
		"background-color": "green",
		"color": "white"
		
	});
	$("#tiedotTaulu td").css({
		"padding": "15px"		
	});
	$("#hinta").css({
		"display":"inline-block",		
		"font-size": "30px",		
		"text-align":"left",
		"position": "absolute",
    	"left": "450px"		
	});
	$("#uusiTarjous").click(function(){
		document.location="Servlet_TarjousVene?Vene_id=tarjoa_<%=vene.getVene_id()%>";	
	});	
	var poistettava_id;	
	$(".poista").click(function(event){	//event kantaa mukanaan tapahtuman, mm. klikkauksen sijainnin	
		poistettava_id=$(this)[0].id;
		$("#poistettavaNimi").html("Vahvista poisto?<br>");
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
		document.location="Servlet_PoistaTarjous?tarjous_id="+poistettava_id+"&vene_id=<%out.print(vene.getVene_id());%>";
	});
	$("#peruutaPoisto").click(function(){
		$("#poistonVahvistus").hide();
	});
	var hyvaksyttava_id;	
	$(".hyvaksy").click(function(event){	//event kantaa mukanaan tapahtuman, mm. klikkauksen sijainnin	
		hyvaksyttava_id=$(this)[0].id;
		$("#hyvaksyttavaNimi").html("Vahvista hyväsyminen?<br>");
		$("#hyvaksymisenVahvistus").css({ 
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
		$("#hyvaksymisenVahvistus").show();
	});
	$("#vahvistaHyvaksy").click(function(){
		document.location="Servlet_HyvaksyTarjous?tarjous_id="+hyvaksyttava_id+"&vene_id=<%out.print(vene.getVene_id());%>";
	});
	$("#peruutaHyvaksy").click(function(){
		$("#hyvaksymisenVahvistus").hide();
	});
});
</script>
</body>
</html>