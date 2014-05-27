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
	private ProductService productService;  //Spring�Զ�ע��
	private List<Product> products;  //����request���ƴ���
	private int totals; //�ܹ�ҳ��
	private int numbers = 2;
	private int pages = 1;
	private File posterImage;  //����ͼƬ ����
	private String posterImageFileName; //�ļ�����
	private String posterImageContentType; //�ļ�����
	
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
	
	//��ת�� product ������   
	public String toMainView() {
		int productNumber = productService.getProducts().size();
		totals = (productNumber % numbers == 0)? productNumber / numbers : productNumber / numbers + 1;
		//��һ��������ʾҳ��  �ڶ���������ʾ��ǰҳ��Ĭ�ϴ�1��ʼ
		products = productService.getProducts(numbers,pages);
		return "mainView";
	}
	//��ת���ļ��ϴ�����
	public String toFileUploading() {
		return "fileUploading";
	}
	
	
	
	//�ļ��ϴ���֤
	public void validateFileUploading() {
		if(getModel().getName() == null) {	
			this.addFieldError("name", "ӰƬ������Ϊ��");
		}
		if(getModel().getPrice() == 0.0) {
			this.addFieldError("price", "���۲���Ϊ��");
		}
	}
	//�ļ��ϴ�
	public String fileUploading() throws Exception{
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		//realpath: E:\apache-tomcat-7.0.53\webapps\vm\images  ���ͼƬ��λ��


        if(posterImage != null) {
	        //��posterImage д�� realpath��
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
