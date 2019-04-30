package attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import attendance.RegDao;

public class RegDao 

{
	public static Connection getConnection()
	{ 
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/attendance","root","root");
		}catch(Exception e){System.out.println(e);}
		
		return con;
	}

	public static int save(Reg robj) 
	{
		int status=0;
		try
		{
			Connection con=RegDao.getConnection();
			PreparedStatement ps=
					con.prepareStatement("insert into register"
			+"(FirstName,LastName,Gender,Email,Mobile,Password) values (?,?,?,?,?,?)");
			ps.setString(1,robj.getRfname());
			ps.setString(2,robj.getRlname());
			ps.setString(3,robj.getRgender());
			ps.setString(4,robj.getRemail());
			ps.setLong(5,robj.getRmobile());
			ps.setString(6,robj.getRpassword());
			
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex) {ex.printStackTrace();}
	
		
		return status;
	}
}
	
