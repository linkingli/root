package cn.ssm.entity.channel;

import java.util.List;

public class PageBean<E> {

	private List<E> rows;// 当前页内容 查询
	private Integer currPage;// 当前页码 传递
	private Integer pageSize;// 每页显示的条数 固定
	private Integer total;// 总条数 查询

	private Integer totalPage;// 总页数 计算

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public int getTotalPage() {

		return (int) Math.ceil(total * 1.0 / pageSize);
	}

}
