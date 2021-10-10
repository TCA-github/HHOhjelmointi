package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Tarjous;

@WebServlet("/Servlet_HyvaksyTarjous")
public class Servlet_HyvaksyTarjous extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Servlet_HyvaksyTarjous() {
        super();
        System.out.println("Servlet_HyvaksyTarjous.Servlet_HyvaksyTarjous()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HyvaksyTarjous.doGet()");
		String id = request.getParameter("tarjous_id");
		id=id.replace("hyvaksy_", "");
		String vene_id = request.getParameter("vene_id");
		Dao_Tarjous dao = new Dao_Tarjous();
		try {
			dao.hyvaksyTarjous(Integer.parseInt(id));			
			response.sendRedirect("Servlet_HaeTarjoukset?Vene_id=tarjoa_" + vene_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HyvaksyTarjous.doPost()");
	}

}
