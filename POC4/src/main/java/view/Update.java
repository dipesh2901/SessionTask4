package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserInfoController;
import model.UserInformation;

@WebServlet(urlPatterns = {"/Update"})
public class Update extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String username=req.getParameter("username");
		String address=req.getParameter("address");
		String contact=req.getParameter("contact");
		try {
			String success=UserInfoController.updateUser(username,new UserInformation(username, address, contact));
			out.print(success);
			req.getRequestDispatcher("poc4Task").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
