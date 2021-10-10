<%
if(session.getAttribute("savePath")==null){
	String savePath ="C:/Users/christian.brade/Desktop/Venekauppa/Venekauppa/WebContent/images/uploaded/";
	session.setAttribute("savePath", savePath);		
}
if(!request.getRequestURI().equals("/Venekauppa/index.jsp")){ 	//jos kutsutaan jotakin muuta kuin index.jsp -sivua
	if(session.getAttribute("Kirjautunut_nimi")==null){			//ja kirjautumista ei ole tapahtunut
		response.sendRedirect("index.jsp");
	}
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script><!-- datepickeriä varten -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css"><!-- datepickeriä varten -->
<title>Vantaan Veneliike Oy</title>
<style>
label{
    display:inline-block;
    width:120px;
    text-align:right;
    vertical-align:top;
}
label.error {
	width:80px;	
    color:red; 
    text-align:left;  
}
.lbl_min{
    display:inline-block;
    width:120px;
    text-align:right;
    vertical-align:top;
    background-color:white;	
}
.header_icon{
	height:50px;
}
.icon{
	height:30px;
}
.icon_mini{
	height:20px;
	vertical-align:bottom;
}
#kirjautuneena{
	display:inline-block;
	vertical-align:top;
	width:250px; 
	height:50px;	
}
</style>
</head>
<body>
<img src="images/home.png" class="header_icon" id="kotiinIcon" title="Kotiin" onclick="document.location='index.jsp'">
<img src="images/user.png" class="header_icon" id="asiakasIcon" title="Asiakastiedot" onclick="document.location='asiakashaku.jsp'">
<img src="images/boat.png" class="header_icon" id="veneIcon" title="Veneet" onclick="document.location='haevene.jsp'">
<div id="kirjautuneena">
Käyttäjä: 
<%
out.print(session.getAttribute("Kirjautunut_nimi"));
%>
<br>
<a href="Servlet_Kirjaudu?out=1">Kirjaudu ulos</a>
</div>
<%
if(session.getAttribute("Kirjautunut_nimi")==null){		
	out.println("<script>");
	out.println("$('#kirjautuneena').hide();");
	out.println("$('#asiakasIcon').hide();");
	out.println("$('#veneIcon').hide();");	
	out.println("</script>");	
}
%>
<hr>

