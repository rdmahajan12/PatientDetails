package patient.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospitalmodel.Patient;
import hospitalmodel.PatientDAO;

/**
 * Servlet implementation class UpdatePatientServlet
 */
@WebServlet("/UpdatePatient")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatientServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		int count=0;
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		
		
		PatientDAO pdao=new PatientDAO();
		try 
		{
			count=pdao.updatePatient(pid, pname);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0)
		{
			request.setAttribute("result", "Update patient data");
		}
		else
		{
			request.setAttribute("result", "Data not update");
		}
		
		RequestDispatcher rs=request.getRequestDispatcher("UpdatePatient.jsp");
		rs.forward(request, response);
	}

}
