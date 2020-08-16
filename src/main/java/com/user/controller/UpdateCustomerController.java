package com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.impl.CustomerDaoImpl;
import com.user.dao1.CustomerDao;
import com.user.model.Customer;



@WebServlet("/customer/update")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCustomerController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custId = request.getParameter("custId");

		if (custId == "" || custId == null)
			request.getRequestDispatcher("/").forward(request, response);
		
		else {
			Long id =Long. parseLong(custId);
			CustomerDao customerDao = CustomerDaoImpl.getInstance();
			Customer customer = customerDao.findCustomerById(id);
/*			customer.setFirstName( request.getParameter("firstName"));
			customer.setLastName(request.getParameter("lastName"));
			customer.setEmail(request.getParameter("email"));
			customer.setMobile(request.getParameter("mobile"));*/
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/edituserform.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custId = request.getParameter("id");

		if (custId == "" || custId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id =Long. parseLong(custId);
			CustomerDao customerDao = CustomerDaoImpl.getInstance();
			Customer customer = customerDao.findCustomerById(id);
			customer.setId(id);
			customer.setFirstName( request.getParameter("firstName"));
			customer.setLastName(request.getParameter("lastName"));
			customer.setEmail(request.getParameter("email"));
			customer.setMobile(request.getParameter("mobile"));
			request.setAttribute("customer", customer);
			customerDao.updateCustomer(customer);
			response.sendRedirect(request.getContextPath() + "/viewUsers");
		}
	}
}
