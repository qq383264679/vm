package com.feng.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.feng.model.Order;
import com.feng.model.OrderLine;
import com.feng.model.Product;
import com.feng.model.User;
import com.feng.service.OrderLineService;
import com.feng.service.OrderService;
import com.feng.service.ProductService;

public class OrderAction extends BaseAction<Order> implements SessionAware {
	private Map<String, Object> session;// sessionMAP
	private ProductService productService;
	private OrderService orderService;
	private OrderLineService orderLineService;
	List<OrderLine> orderLines; //订单详情
	private int productId;
	private int quality;

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setOrderLineService(OrderLineService orderLineService) {
		this.orderLineService = orderLineService;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	private Product product;   //产品id
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return super.getModel();
	}
	public Product getProduct() {
		return product;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//跳转到订单界面
	public String toOrderView() {
		product = productService.getProduct(productId);
		return "orderView";
	}
	//跳转到购物车界面
	public String toShopcartView() {
		User user = (User) session.get("user"); //
		orderLines = orderLineService.getOrderLines(user.getUserName());
		return "shopcartView";
	}
	//完成结账后跳转到结账界面
	public String toFinishAccount() {		
		System.out.println(this.getModel().getOrderId() + "--->");

		orderLineService.deleteOrderLine(this.getModel().getOrderId());
		return "finishAccount";
	}
	
	//完成订单操作
	public void finishOrder() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Charset","UTF-8"); 
		User user = (User) session.get("user"); //


		//order
		this.getModel().setUser(user);
		orderService.saveEntity(this.getModel());
		
		//orderLine
		OrderLine orderLinde = new OrderLine();
		orderLinde.setOrder(this.getModel());
		orderLinde.setProduct(productService.getProduct(productId));
		orderLinde.setQuantity(quality);
		orderLineService.saveEntity(orderLinde);	
		try {
			PrintWriter pw = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "succeed");
			pw.write(jsonObject.toString());
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
