package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserInfoController;

@WebServlet(urlPatterns = {"/transfer"})
public class Transfer extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		String payeeUsername=req.getParameter("payeeUsername");
		Double amount=Double.parseDouble(req.getParameter("amount"));
		String success=UserInfoController.payUser((String)session.getAttribute("username"), payeeUsername, amount);
		out.print("<h1 style='text-align:center'>"+success+"</h1>");
	}
}
