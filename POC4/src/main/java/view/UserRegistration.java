package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserInfoController;
import model.UserInformation;

@WebServlet(urlPatterns = {"/RegisterUser"})
public class UserRegistration extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String contact=req.getParameter("contact");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String confirmPassword=req.getParameter("confirmPassword");
		Double deposit=Double.parseDouble(req.getParameter("deposit"));
		try {
			UserInfoController.insertUser(new UserInformation(name, address, contact, username, password,deposit,"Initial Deposit- Rs."+deposit));
			RequestDispatcher rd=req.getRequestDispatcher("/poc4Task");
			rd.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
