package com.mybatis.commom.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "分页查询条件", description = "分页查询条件")
@Data
public class PageQuery {

	@ApiModelProperty(value = "页大小", example = "10")
	private long size = 10;

	@ApiModelProperty(value = "当前页", example = "1")
	private long current = 1;

	@ApiModelProperty(value = "排序数组")
	private OrderItem[] orderItem;

	@ApiModelProperty(value = "排序 ASC 数组")
	private String[] ascs;

	@ApiModelProperty(value = "排序 DESC 数组")
	private String[] descs;

//	/**
//	 * 获取分页查询条件对象
//	 *
//	 * @return
//	 */
//	public <T> Page<T> toPage() {
//		Page<T> page = new Page<T>(current, size);
//		page.setOptimizeCountSql(false);
//		page.setOrders(getOrders());
//		return page;
//	}
//
//	/**
//	 * 获取排序属性
//	 * @return
//	 */
//	public List<OrderItem> getOrders() {
//		List<OrderItem> orders = new ArrayList<OrderItem>();
//		if (orderItem != null) {
//			for (int i = 0; i < orderItem.length; i++) {
//				String column = orderItem[i].getColumn();
//				if (StrUtil.isNotBlank(column)) {
//					orderItem[i].setColumn(CamelCaseUtils.camelhumpToUnderline(column));
//					orders.add(orderItem[i]);
//				}
//			}
//		}
//		// 兼容历史版本方式
//		if (ascs != null) {
//			orders.addAll(OrderItem.ascs(camelhumpToUnderline(ascs)));
//		}
//		if (descs != null) {
//			orders.addAll(OrderItem.descs(camelhumpToUnderline(descs)));
//
//		}
//		return toPage().getOrders();
//	}
//
//	/**
//	 * 将驼峰风格替换为下划线风格，解决前端字段是驼峰字段，后端排序直接字段使用存在问题
//	 *
//	 * @param arr
//	 * @return
//	 */
//	private String[] camelhumpToUnderline(String[] arr) {
//		if (!ArrayUtil.isEmpty(arr)) {
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = CamelCaseUtils.camelhumpToUnderline(arr[i]);
//			}
//		}
//		return arr;
//	}
}
