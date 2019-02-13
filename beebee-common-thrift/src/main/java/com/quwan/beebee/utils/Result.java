package com.quwan.beebee.utils;


import com.quwan.beebee.exception.ErrorCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回数据模型
 * 
 * @author anson
 */
public class Result extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public Result() {
		put("error", 0);
	}

	/**
	 * 自定义
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result response(int code, String msg) {
		Result result = new Result();
		result.put("error", code);
		result.put("message", msg);
		return result;
	}

	/**
	 * ErrorCode 标准输出
	 * @return
	 */
	public static Result response(ErrorCode errorCode) {
		Result result = new Result();
		result.put("error", errorCode.code);
		result.put("message", errorCode.msg);
		return result;
	}

	/**
	 * 成功
	 * @return
	 */
	public static Result success() {
		return response(ErrorCode.Successful);
	}

	/**
	 * 未知
	 * @return
	 */
	public static Result unknown() {
		return response(ErrorCode.Unknown);
	}

	/**
	 * 失败
	 * @return
	 */
	public static Result error() {
		return response(ErrorCode.ServerError);
	}

	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public static Result okObject(Object object) {
		Result result = new Result();
		result.put("error", 0);
		result.put("message", "Successful");
		result.put("result", object);
		return result;
	}

	public static Result okList(Integer pageCurr, Integer pageSize, Integer total, List<?> list) {
		Result result = new Result();
		result.put("error", 0);
		result.put("message", "Successful");
		result.put("result", new ResultList(pageCurr, pageSize, total, list));
		return result;
	}

	public static Result ok(Map<String, Object> map) {
		Result result = new Result();
		result.putAll(map);
		return result;
	}

	private static class ResultList implements Serializable {
		private List<?> list;
		private Integer pageCurr;
		private Integer pageSize;
		private Integer total;

		public Integer getPageCurr() {
			return pageCurr;
		}

		public void setPageCurr(Integer pageCurr) {
			this.pageCurr = pageCurr;
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

		public ResultList(Integer pageCurr, Integer pageSize, Integer total, List<?> list) {
			this.pageCurr = pageCurr + 1;
			this.pageSize = pageSize;
			this.total = total;
			this.list = list;
		}
		public List<?> getList() {
			return list;
		}
		public void setList(List<?> list) {
			this.list = list;
		}
	}

}


