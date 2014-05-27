package com.feng.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Validatable;

import com.feng.model.Product;
import com.feng.service.ProductService;

public class ProductAction extends BaseAction<Product> implements Validatable{
	private ProductService productService;  //Spring自动注入
	private List<Product> products;  //进行request郁闷传递
	private int totals; //总共页数
	private int numbers = 2;
	private int pages = 1;
	private File posterImage;  //海报图片 内容
	private String posterImageFileName; //文件名称
	private String posterImageContentType; //文件类型
	
	public void setPosterImageFileName(String posterImageFileName) {
		this.posterImageFileName = posterImageFileName;
	}
	public void setPosterImageContentType(String posterImageContentType) {
		this.posterImageContentType = posterImageContentType;
	}
	public void setPosterImage(File posterImage) {
		this.posterImage = posterImage;
	}
	public int getTotals() {
		return totals;
	}
	public List<Product> getProducts() {
		return products;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//跳转到 product 主界面   
	public String toMainView() {
		int productNumber = productService.getProducts().size();
		totals = (productNumber % numbers == 0)? productNumber / numbers : productNumber / numbers + 1;
		//第一个参数显示页数  第二个参数显示当前页数默认从1开始
		products = productService.getProducts(numbers,pages);
		return "mainView";
	}
	//跳转到文件上传界面
	public String toFileUploading() {
		return "fileUploading";
	}
	
	
	
	//文件上传验证
	public void validateFileUploading() {
		if(getModel().getName() == null) {	
			this.addFieldError("name", "影片名不能为空");
		}
		if(getModel().getPrice() == 0.0) {
			this.addFieldError("price", "单价不能为空");
		}
	}
	//文件上传
	public String fileUploading() throws Exception{
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		//realpath: E:\apache-tomcat-7.0.53\webapps\vm\images  存放图片的位置


        if(posterImage != null) {
	        //将posterImage 写到 realpath中
	    	InputStream in = null;
	    	OutputStream out = null;
	    	
	    	try {
				in = new BufferedInputStream(new FileInputStream(posterImage), 1024);
				out = new BufferedOutputStream(new FileOutputStream(new File(realpath, posterImageFileName)), 1024);
				System.out.println(realpath);
				
				byte[] b = new byte[1024];
				while(in.read(b) != -1) {
					out.write(b);
				}
				in.close();
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	this.getModel().setPoster(posterImageFileName);
        }
        productService.saveProduct(this.getModel());
        return "fileUploading";
	}

}
