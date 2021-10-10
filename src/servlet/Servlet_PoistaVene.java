package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_Vene;

@WebServlet("/Servlet_PoistaVene")
public class Servlet_PoistaVene extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Servlet_PoistaVene() {
        super();
        System.out.println("Servlet_PoistaVene.Servlet_PoistaVene()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaVene.doGet()");
		String id = request.getParameter("Vene_id");
		id=id.replace("poista_", "");
		Dao_Vene dao = new Dao_Vene();
		try {
			dao.poistaVene(Integer.parseInt(id));			
			response.sendRedirect("Servlet_HaeVeneet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaVene.doPost()");
	}

}
