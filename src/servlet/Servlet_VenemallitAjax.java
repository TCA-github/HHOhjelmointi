package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;

@WebServlet("/Servlet_VenemallitAjax")
public class Servlet_VenemallitAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_VenemallitAjax() {
        super();
        System.out.println("Servlet_VenemallitAjax.Servlet_VenemallitAjax()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VenemallitAjax.doGet()");
		String merkki_id=request.getParameter("merkki_id");
		Dao dao = new Dao();
		try {
			String[] sarakkeet={"Malli_id", "Malli"};
			String strJSON = dao.haeTiedotJSON(sarakkeet,"VV_Mallit","Merkki_id",merkki_id,2);
			PrintWriter out = response.getWriter(  );
		    response.setContentType("text/html"); 
		    out.println(strJSON);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VenemallitAjax.doPost()");
	}

}
