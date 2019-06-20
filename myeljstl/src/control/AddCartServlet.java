package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.Product;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCartServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String no = request.getParameter("no");
		String quantitiy = request.getParameter("quantity");

		HttpSession session = request.getSession();

		Map<Product, Integer> c = (Map) session.getAttribute("cart");

		if (c == null) {
			c = new HashMap<>();
			session.setAttribute("cart", c);
		}

		Product p = new Product();
		p.setProd_no(no);
		int intQuantity = Integer.parseInt(quantitiy);

		// 장바구니에 해당상품이 존재하는가 확인
		Integer inte = c.get(p);
		if (inte != null) { // 존재하면 수량을 합산한다.
			intQuantity += inte.intValue();
		}
		c.put(p, intQuantity); // 장바구니 상품, 수량추가
		
		String path = "/addcartresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		System.out.println("------장바구니내용------");
		Set<Product> keys = c.keySet();
		for (Product key : keys) {
			int q = c.get(key);
			System.out.println("상품번호: " + key.getProd_no() + ", 수량 : " + q);
		}
	}
}
