<%@include file="header.jsp" %>
<%
//***ALKU TULEE header.jsp tiedostosta******************************************************************************************************
%>
<fieldset id="kirjautuminen">
	<legend>Kirjautuminen:</legend>	
	<form action="Servlet_Kirjaudu" method="post" id="kirjauduLomake">
	<label>Käyttäjätunnus:</label>	
	<input type="text" name="uid" id="uid"><br>
	<label>Salasana:</label>
	<input type="password" name="pwd" id="pwd"><br>
	<label></label>
	<input type="button" value="Kirjaudu" id="kirjaudu">
	</form>
</fieldset>
<script>
$(document).ready(function(){
	$("#kirjautuminen").css({
		"width": "300px", 
		"border-radius": "15px"
	});
	$("#kirjaudu").click(function(){		
		if($("#uid").val().length>0&&$("#pwd").val().length>0){
			document.forms["kirjauduLomake"].submit();
		}
	});	
});
</script>
</body>
</html>