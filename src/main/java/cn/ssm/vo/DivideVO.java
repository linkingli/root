package cn.ssm.vo;

import cn.ssm.entity.ChannelDown;
import cn.ssm.entity.ChannelTop;
import cn.ssm.entity.DivideType;
import cn.ssm.entity.Product;

public class DivideVO {

	private String id;
	private ChannelTop channelTop;
	private ChannelDown channelDown;
	private Product product;
	private DivideType divideType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ChannelTop getChannelTop() {
		return channelTop;
	}
	public void setChannelTop(ChannelTop channelTop) {
		this.channelTop = channelTop;
	}
	public ChannelDown getChannelDown() {
		return channelDown;
	}
	public void setChannelDown(ChannelDown channelDown) {
		this.channelDown = channelDown;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public DivideType getDivideType() {
		return divideType;
	}
	public void setDivideType(DivideType divideType) {
		this.divideType = divideType;
	}
	
	
	
}
