package patient.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospitalmodel.PatientDAO;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet("/DeletePatient")
public class DeletePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatientServlet() {
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
		// TODO Auto-generated method stub
		
		int count=0;
		int pid=Integer.parseInt(request.getParameter("pid"));
		
		PatientDAO pdao=new PatientDAO();
		try 
		{
			count=pdao.deletePatient(pid);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0)
		{
			request.setAttribute("result", "Delete patient data");
		}
		else
		{
			request.setAttribute("result", "Data not delete");
		}
		
		RequestDispatcher rs=request.getRequestDispatcher("DeletePatient.jsp");
		rs.forward(request, response);
	}

}
