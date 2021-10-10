package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Asiakas;
import dao.Dao_Asiakas;

@WebServlet("/Servlet_Kirjaudu")
public class Servlet_Kirjaudu extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Servlet_Kirjaudu() {
        super();
        System.out.println("Servlet_Kirjaudu.Servlet_Kirjaudu()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_Kirjaudu.doGet()");		
		if(request.getParameter("out")!=null){
			HttpSession session = request.getSession(true);
			session.removeAttribute("Kirjautunut_id");
			session.removeAttribute("Kirjautunut_nimi");
			response.sendRedirect("index.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_Kirjaudu.doPost()");
		String uid = request.getParameter("uid");	
		String pwd = request.getParameter("pwd");
		Dao_Asiakas dao = new Dao_Asiakas();
		try {
			Asiakas asiakas = dao.haeAsiakas(uid, pwd);
			if(asiakas!=null){
				HttpSession session = request.getSession(true);
				session.setAttribute("Kirjautunut_id", asiakas.getAsiakas_id());	
				session.setAttribute("Kirjautunut_nimi", asiakas.getEtunimi() + " " + asiakas.getSukunimi());				
			}
			response.sendRedirect("haevene.jsp");
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

}
