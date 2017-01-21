package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.example.other.*;

public class MainServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // same like this.sleep(2000)
        sleep(2000);
        // to get session object:
        HttpSession session = request.getSession();
        // now we create 2 objects with trigerring listener event:
        Person person1 = new Person("Andrius", 29);
        Person person2 = new Person("Tomas", 30);
        // now we try to add these two objects to a session scope:
        session.setAttribute("person1_info", person1);
        session.setAttribute("person2_info", person2);
        // if you check a console you will see when you set attribute this person object 
        // act like a listener class and invoke valueBound() method
        this.sleep(5000);
        // now we end this session:
        session.invalidate(); // this will trigger persons objects method valueUnbound()
        
        out.println("This is example of <b>HttpSessionBindingListener</b>");
        out.close();
	}
	
	 private void sleep(int n) {
	        try {
	            Thread.sleep(n);
	        }
	        catch (InterruptedException exc) {
	            exc.printStackTrace();
	        }
	    }
}
