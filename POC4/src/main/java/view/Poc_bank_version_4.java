package view;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserInfoController;
import model.UserInformation;

@WebServlet(urlPatterns = {"/poc4Task" })
public class Poc_bank_version_4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		boolean condition_password, loggedIn = false, condition = false;
		Base64.Encoder password_encoder = Base64.getEncoder();
		Base64.Decoder password_decoder = Base64.getDecoder();
		String name, address, number, username, password, regexNumber, regexPassword, encodedPassword = null,
				decodedPassword, transaction;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String date = sdf.format(new Date());
		RequestDispatcher rd;
		int choice2=0;
		Double deposit;
		rd = req.getRequestDispatcher("UserInput.html");
		rd.include(req, resp);
		int choice = Integer.parseInt(req.getParameter("choice"));
		//out.print(req.getParameter("choice2"));
		switch (choice) {
		case 1:
			rd=req.getRequestDispatcher("Register.html");
			rd.forward(req, resp);
			break;
		case 2:
			RequestDispatcher rd2 = req.getRequestDispatcher("login.html");
			rd2.forward(req, resp);
			break;
		case 3:
			out.print("This is Update");
			//UserInfoController.updateUser(username,new UserInformation(username, address, date))
			rd=req.getRequestDispatcher("Update.html");
			rd.forward(req, resp);
			break;
		case 4:
			RequestDispatcher rd3=req.getRequestDispatcher("index.html");
			rd3.forward(req, resp);
			break;
		}

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		boolean condition_password, loggedIn = false, condition = false;
		Base64.Encoder password_encoder = Base64.getEncoder();
		Base64.Decoder password_decoder = Base64.getDecoder();

		List<String> choice_list1 = new ArrayList<String>(
				Arrays.asList("1. Register Account<br>", "2. Login<br>", "3. Update Accounts<br>", "4. Exit<br>"));
		List<String> choice_list2 = new ArrayList<String>(Arrays.asList("----------------------------<br>",
				"W E L C O M E<br>", "----------------------------<br>", "1. Deposit<br>", "2. Transfer<br>",
				"3. Last 5 Transactions<br>", "4. User Information<br>", "5. Log Out<br>"));
		String name, address, number, username, password, regexNumber, regexPassword, encodedPassword = null,
				decodedPassword, transaction;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String date = sdf.format(new Date());
		RequestDispatcher rd;
		int choice2=0;
		Double deposit;
		out.print("-------------------------------<br>");
		out.print("BANK OF  MYBANK<br>");
		out.print("--------------------------------<br>");
		choice_list1.stream().forEach(out::println);
		rd = req.getRequestDispatcher("UserInput.html");
		rd.include(req, resp);
		int choice = Integer.parseInt(req.getParameter("choice"));
		//out.print(req.getParameter("choice2"));
		switch (choice) {
		case 1:
			rd=req.getRequestDispatcher("Register.html");
			rd.forward(req, resp);
			break;
		case 2:
			RequestDispatcher rd2 = req.getRequestDispatcher("login.html");
			rd2.forward(req, resp);
			break;
		case 3:
			out.print("This is Update");
			break;
		case 4:
			RequestDispatcher rd3=req.getRequestDispatcher("index.html");
			rd3.forward(req, resp);
			break;
		}

	}
	
}
