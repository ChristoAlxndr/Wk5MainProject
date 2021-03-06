package week5mainprojectservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.week5mainproject.DAO;
import com.week5mainproject.Trucks;

/**
 * Servlet implementation class updateDBServelet
 */
@WebServlet("/updateDBServelet")
public class updateDBServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDBServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Trucks updateDB1 = new Trucks();
		
		updateDB1.setTruckID(Integer.parseInt(request.getParameter("truck_id")));
		updateDB1.setDriver(request.getParameter("driver"));
		updateDB1.setTruckMake(request.getParameter("truck_make"));
		updateDB1.setTruckModel(request.getParameter("truck_model"));
		updateDB1.setTruckFuel(Double.parseDouble(request.getParameter("truck_fuel")));
		
		DAO.updateDB(updateDB1);
		
		request.getRequestDispatcher("databaseHome.jsp").forward(request, response);
		
	}

}
