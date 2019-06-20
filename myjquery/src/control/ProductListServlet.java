package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;


@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       private ProductService service;
       public ProductListServlet() {	//service객체가 미리한번생성후 계속쓰이게 해줌
    	   service = new ProductService();
       }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Product> list = service.findAll();
		request.setAttribute("productlist", list);	//응답할떄까지만 가지고있으면 되서 request에 담음
		String path = "productlistresult.jsp";		//경로앞에 / 가 붙을경우 webcontent안으로 .
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}



}
