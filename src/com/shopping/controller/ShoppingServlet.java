package com.shopping.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.shopping.model.CartVO;

public class ShoppingServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		Vector<CartVO> buylist = (Vector<CartVO>) session.getAttribute("shoppingcart");
		String action = req.getParameter("action");
		
		if ("ADD".equals(action)) {
			boolean match = false;
		    /*********************************1.接收請求參數***********************************/
			String product_no = req.getParameter("product_no");
			String product_name = req.getParameter("product_name");
			Integer quantity = Integer.valueOf(req.getParameter("quantity"));
			Integer product_price = Integer.valueOf(req.getParameter("product_price"));
			/*********************************2.加入購物車************************************/
			CartVO cartVO = new CartVO();
			cartVO.setProduct_no(product_no);
			cartVO.setProduct_name(product_name);
			cartVO.setQuantity(quantity);
			cartVO.setProduct_price(product_price);
		//待研究!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
//			if (buylist == null) {
//				buylist = new Vector<CartVO>();
//				buylist.add(cartVO);
//			} else {
//				if(buylist.contains(cartVO)){
//					 CartVO innerCarVO = buylist.get(buylist.indexOf(cartVO));
//					 innerCarVO.setQuantity(innerCarVO.getQuantity() + cartVO.getQuantity());
//				}else{
//					buylist.add(cartVO);
//				}
//			}
			
			// 新增第一本書籍至購物車時
			   if (buylist == null) {
			    buylist = new Vector<CartVO>();
			    buylist.add(cartVO);
			   } else {
			    for (int i = 0; i < buylist.size(); i++) {
			     CartVO prod = buylist.get(i);

			     // 假若新增的書籍和購物車的書籍一樣時
			     if (prod.getProduct_name().equals(cartVO.getProduct_name())) {
			      prod.setQuantity(prod.getQuantity() + cartVO.getQuantity());
			      buylist.setElementAt(prod, i);
			      match = true;
			     } // end of if name matches
			    } // end of for

			    // 假若新增的書籍和購物車的書籍不一樣時
			    if (!match) {
			     buylist.add(cartVO);
			    }
			   }
			
			
			
			/*************************3.完成加入,準備轉交(Send the Success view)***************/
			session.setAttribute("shoppingcart", buylist);
			RequestDispatcher successView = req.getRequestDispatcher("/front-end/product/Shop.jsp");
			successView.forward(req, res);
		}
		
		
	    if("DELETE".equals(action)){ // 來自 Cart.jsp 的請求
    	    /*********************************1.接收請求參數***********************************/
	    	String del = req.getParameter("del");
    	    /*********************************2.刪除購物車內某商品*******************************/
	    	int d = Integer.parseInt(del);
	    	buylist.remove(d);
  	        /***********************3.完成刪除,準備轉交(Send the Success view)******************/
	    	session.setAttribute("shoppingcart", buylist);
	    	RequestDispatcher successView = req.getRequestDispatcher("/front-end/product/Cart.jsp");
	    	successView.forward(req, res);
	    }
	    
	    
		if ("CHECKOUT".equals(action)) { // 來自 Cart.jsp 的請求
		    /*****************************1.接收請求參數並計算總價********************************/
			int total = 0 ;
			for(CartVO cartVO :buylist){
				int quantity = Integer.parseInt(req.getParameter("quantity"+cartVO.getProduct_no()));
				 cartVO.setQuantity(quantity);
				 int price = cartVO.getProduct_price();
				 total += (price * quantity);
			}
			/***************************2.總價完成,準備轉交(Send the Success view)**************/
			 session.setAttribute("amount", String.valueOf(total));
			 session.setAttribute("shoppingcart", buylist);
			 RequestDispatcher successView = req.getRequestDispatcher("/front-end/product/Checkout.jsp"); 
			 successView.forward(req, res);
		}
	}

}
