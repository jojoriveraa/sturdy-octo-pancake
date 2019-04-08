/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;


@WebServlet("/cart")
public class CartServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	
	private ItemRepository repo = new InMemoryItemRepository();	
	
	/* 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/* 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // Read the parameter from the "Add to Cart" link
	      String itemID = request.getParameter("itemID");

	      // Session management - create new or get reference to existing
	      HttpSession session = request.getSession();

	      // Shopping cart management - create new or get reference to existing
	      @SuppressWarnings("unchecked")
	      Collection<MusicItem> cart = (Collection<MusicItem>) session.getAttribute("cart");
	      if (cart == null)  // first visit: session does not have a "cart"
	      {
	         cart = new ArrayList<MusicItem>();  // create new cart
	         session.setAttribute("cart", cart);  // add it to session
	      }

	      // Shopping cart content management (add item if not already in cart)
	      if (itemID != null)
	      {
	         MusicItem item = repo.findOne(Long.valueOf(itemID));
	         if (!cart.contains(item))  // based on equals() method of ItemValue
	         {
	        	 System.out.println("Adding item: " + item);
	            cart.add(item);
	         }
	      }

	      // forward to /jsp/cartDisplay.jsp
	      this.getServletContext().getRequestDispatcher("/views/cart.jsp").
	         forward(request, response);
	}

}