package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.impl.CustomerDaoImpl;
import com.user.dao.CustomerDao;
import com.user.model.Customer;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String DELETE_STR = "DELETE";
	private static final String PUT_STR = "PUT";
	private CustomerDao customerDao = CustomerDaoImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custId = request.getParameter("custId");
		String method = request.getParameter("_method");

		if (method != null) {
			if (method.equals(DELETE_STR))
				doDelete(request, response);
			else if (method.equals(PUT_STR))
				doPut(request, response);

		} else {
			if (custId == "" || custId == null) {
				request.setAttribute("customerList", customerDao.findAllCustomers());
				request.getRequestDispatcher("viewusers.jsp").forward(request, response);
			} else {
				request.setAttribute("customer", customerDao.findCustomerById(Long.parseLong(custId)));
				request.getRequestDispatcher("/edituserform.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custId = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		Customer customer = new Customer(firstName, lastName, email, mobile);

		customerDao.saveCustomer(customer);
		PrintWriter writer = response.getWriter();

		// build HTML code
		String htmlRespone = "<html>";
		htmlRespone += "<h2>Records Inserted successfully.</h2><br/><a href='customer'>View Users</a>";

		// return response
		writer.println(htmlRespone);
		// request.getRequestDispatcher("adduserform.jsp").forward(request, response);
		// response.sendRedirect(request.getContextPath() + "/viewUsers");
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custId = request.getParameter("custId");

		if (custId == "" || custId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(custId);

			customerDao.deleteCustomer(id);

			response.sendRedirect(request.getContextPath() + "/customer");
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custId = request.getParameter("id");

		if (custId == "" || custId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(custId);
			Customer customer = customerDao.findCustomerById(id);
			customer.setId(id);
			customer.setFirstName(request.getParameter("firstName"));
			customer.setLastName(request.getParameter("lastName"));
			customer.setEmail(request.getParameter("email"));
			customer.setMobile(request.getParameter("mobile"));
			request.setAttribute("customer", customer);
			customerDao.updateCustomer(customer);
			response.sendRedirect(request.getContextPath() + "/customer");
		}
	}

}
