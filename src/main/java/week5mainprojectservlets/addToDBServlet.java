package week5mainprojectservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.week5mainproject.Trucks;
import com.week5mainproject.DAO;

/**
 * Servlet implementation class addToDBServlet
 */
@WebServlet("/addToDBServlet")
public class addToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToDBServlet() {
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
		
		Trucks addToDB = new Trucks();
		
		addToDB.setDriver(request.getParameter("driver"));
		addToDB.setTruckMake(request.getParameter("truck_make"));
		addToDB.setTruckModel(request.getParameter("truck_model"));
		addToDB.setTruckFuel(Double.parseDouble(request.getParameter("truck_fuel")));
		
		DAO.writeToDB(addToDB);
		
		request.getRequestDispatcher("databaseHome.jsp").forward(request, response);
		
	} // doPost End

}
