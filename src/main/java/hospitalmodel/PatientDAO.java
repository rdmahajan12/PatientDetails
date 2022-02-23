package hospitalmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class PatientDAO 
{
	public int addPatient(Patient patient) throws SQLException,ClassNotFoundException
	{
		String str="insert into patient values(?,?,?,?)";
		Connection con=createConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(str);
		
		ps.setInt(1, patient.getPid());
		ps.setString(2, patient.getPname());
		ps.setString(3, patient.getPaddress());
		ps.setLong(4, patient.getPhone());
		
		int count =ps.executeUpdate();
		return count;
	}
	
	
	
	public int updatePatient(int pid,String pname) throws SQLException,ClassNotFoundException
	{
		String str="update patient set pname=? where pid=?";
		Connection con=createConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(str);
		ps.setString(1, pname);
		ps.setInt(2, pid);
		
		int count =ps.executeUpdate();
		return count;
	}
	
	public int deletePatient(int pid) throws SQLException,ClassNotFoundException
	{
		String str="delete from patient where pid=?";
		Connection con=createConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(str);
		ps.setInt(1, pid);
		
		int count =ps.executeUpdate();
		return count;
	}
}
