<%@include file="header.jsp" %>

<fieldset id="asiakasTiedot">
	<legend>Asiakkaan tiedot:</legend>
	<form action="Servlet_UusiAsiakas" method="post" id="uusiLomake">
		<label>Etunimi:</label>
			<input type="text" name="etunimi" id="etunimi" value="" size="40"><br>	
		<label>Sukunimi:</label>
			<input type="text" name="sukunimi" id="sukunimi" value="" size="40"><br>	
		<label>Katuosoite:</label>
			<input type="text" name="katuosoite" id="katuosoite" value="" size="40"><br>	
		<label>Postinumero:</label>
			<input type="text" name="postinumero" id="postinumero" value="" size="5">&nbsp;
			<span id="postitoimipaikka"></span>
			<span id="postitoimivirhe"></span><br>
		<label>Sähköposti:</label>
			<input type="text" name="sahkoposti" id="sahkoposti" value="" size="40"><br>	
		<label>Salasana:</label>
			<input type="password" name="salasana" id="salasana" value=""><br>	
		<label>Toista salasana:</label>
			<input type="password" name="salasana2" id="salasana2" value=""><br>	
		<label>Puhelin:</label>
			<input type="text" name="puhelin" id="puhelin" value=""><br>
		<label>Lisätietoja:</label>	
			<textarea rows="10" cols="30" name="lisatietoja" id="lisatietoja"></textarea><br>
		<label></label>	
			<input type="submit" value="Lisää uusi" id="lisaaBtn">
			<%
			if(request.getParameter("ok")!=null){
				if(request.getParameter("ok").equals("1")){
					out.print("Uusi asiakas on lisätty.");	
				}else if(request.getParameter("ok").equals("0")){
					out.print("Asiakkaan lisäys epäonnistui.");	
				}
			}
			%>
	</form>
</fieldset>
<script>
$(document).ready(function(){
	
	$("#asiakasTiedot").css({
		"width": "500px", 
		"border-radius": "15px"
	});	
	
	$("#postinumero").blur(function(){
	    $.ajax({url: "Servlet_Postitoimi_Ajax?postinumero="+$("#postinumero").val(), success: function(result){
	        $("#postitoimipaikka").html(result);
	    }});
	});
	
	$("#uusiLomake").validate({						
		rules: {
			etunimi:  {
				required: true,
				minlength: 2				
			},	
			sukunimi:  {
				required: true,
				minlength: 2				
			},
			katuosoite:  {
				required: true,
				minlength: 4
			},	
			postinumero:  {
				required: true,
				number: true				
			},			
			sahkoposti:  {
				required: true,
				email: true			
			},
			puhelin:  {				
				minlength: 3				
			},
			salasana:  {
				required: true,
				minlength: 8				
			},
			salasana2:  {
				required: true,
				minlength: 8,
				equalTo: salasana
			}			
		},
		messages: {
			etunimi: {     
				required: "Puuttuu",
				minlength: "Liian lyhyt"			
			},
			sukunimi: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			katuosoite: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			postinumero: {
				required: "Puuttuu",
				number: "Ei kelpaa"				
			},	
			sahkoposti: {
				required: "Puuttuu",
				email: "Ei kelpaa"			
			},
			puhelin:  {				
				minlength: "Liian lyhyt"				
			},
			salasana: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"				
			},
			salasana2: {
				required: "Puuttuu",
				minlength: "Liian lyhyt",
				equalTo: "Ei kelpaa"
			}	
		},			
		submitHandler: function (form) {	
			if ($("#postitoimipaikka").html()!=""){
				document.forms["uusiLomake"].submit();
			}else{
				$("#postitoimipaikka").html("<label class='error'>Puuttuu</label>");
			}			
		}		
	});   
});

</script>
</body>
</html>









