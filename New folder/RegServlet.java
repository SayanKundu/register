package attendance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attendance.Reg;
import attendance.RegDao;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException 
	{
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			
			String firstname=request.getParameter("fname");
			String lastname=request.getParameter("lname");
			String servgender=request.getParameter("gen");
			String servemail=request.getParameter("email");
			String str1=request.getParameter("mobile");
			long servmobile=Long.parseLong(str1);
			String servpassword=request.getParameter("password");
			
			
			Reg regobj=new Reg();
			regobj.setRfname(firstname);
			regobj.setRlname(lastname);
			regobj.setRgender(servgender);
			regobj.setRemail(servemail);
			regobj.setRmobile(servmobile);
			regobj.setRpassword(servpassword);
			
			
			
			
			int n=RegDao.save(regobj);
			if(n>0)
			{
				out.print("<p>Record saved successfully!</p>");
				request.getRequestDispatcher("Registration.html").include(request, response);
				
			}
			else
			{
				out.println("Sorry! unable to save record");
			}
			
			out.close();
			
		}
		
	}

}
