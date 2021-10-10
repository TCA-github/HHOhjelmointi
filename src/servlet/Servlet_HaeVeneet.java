package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Vene;
import dao.Dao_Vene;

@WebServlet("/Servlet_HaeVeneet")
public class Servlet_HaeVeneet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Servlet_HaeVeneet() {
        super();
        System.out.println("Servlet_HaeVeneet.Servlet_HaeVeneet()");        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeVeneet.doGet()");
		//request.setCharacterEncoding("UTF-8");
		if(request.getParameter("hakusana")!=null){
			String hakusana = request.getParameter("hakusana");	
			HttpSession session = request.getSession(true);
			session.setAttribute("hakusanaVene", hakusana);	
			System.out.println(hakusana);
			Dao_Vene dao = new Dao_Vene();			
			try {
				ArrayList<Vene> veneet = dao.haeVeneet(hakusana);	
				System.out.println("Veneitä löytyi " + veneet.get(0));
				request.setAttribute("veneet", veneet);		
				String jsp = "/haevene.jsp"; 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request, response);			   
			} catch (Exception e) {				
				e.printStackTrace();
			}					
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeVeneet.doPost()");
	}

}
