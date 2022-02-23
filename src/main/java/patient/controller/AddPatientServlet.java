package patient.controller;

import java.io.IOException;
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
 * Servlet implementation class AddPatientServlet
 */
@WebServlet("/AddPatient")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientServlet() {
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
		String paddress=request.getParameter("paddress");
		long phone=Long.parseLong(request.getParameter("phone"));
		
		Patient p=new Patient();
		p.setPid(pid);
		p.setPname(pname);
		p.setPaddress(paddress);
		p.setPhone(phone);
		
		PatientDAO pdao=new PatientDAO();
		try 
		{
			count=pdao.addPatient(p);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0)
		{
			request.setAttribute("result", "Patient data saved");
		}
		else
		{
			request.setAttribute("result", "Data not saved");
		}
		
		RequestDispatcher rs=request.getRequestDispatcher("AddPatient.jsp");
		rs.forward(request, response);
	}

}
