package com.user.tickrtbooking.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.ticketbooking.bean.User;
import com.user.ticketbooking.dao.UserDao;

@WebServlet("/")
public class UserServlet extends HttpServlet {          
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() throws ServletException {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	//encapsulation
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {         
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;

			case "/insert":
				insertUser(request, response);
				break;

			case "/delete":
				deleteUser(request, response);
				break;

			case "/edit":
				showEditForm(request, response);
				break;

			case "/update":
				updateUser(request, response);
				break;

			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String email = request.getParameter("email");
		String eventName = request.getParameter("eventName");
		int ticketCount = Integer.parseInt(request.getParameter("ticketCount"));
		String ticketType = request.getParameter("ticketType");
		User newUser = new User(email, eventName, ticketCount, ticketType);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		User existingUser = userDao.selectUser(id);
//		System.out.println(existingUser);
		request.setAttribute("user", existingUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String eventName = request.getParameter("eventName");
		int ticketCount = Integer.parseInt(request.getParameter("ticketCount"));
		String ticketType = request.getParameter("ticketType");
		User user = new User(id, email, eventName, ticketCount, ticketType);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
}
