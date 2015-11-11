package com.zhangyingwei.miner.rssclient.controller.base;


import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.zhangyingwei.miner.common.util.ResultData;

public class BaseController {
	
	protected ResultData getResultData(){
		return new ResultData();
	}
	
	@Autowired(required=false)
	HttpServletResponse response;
	
	protected void setResultMsg(String message){
		try {
			this.response.setCharacterEncoding("utf-8");
			this.response.getWriter().print(message);
			this.response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void setResultMsg(Map message){
		try {
			this.response.setCharacterEncoding("utf-8");
			this.response.getWriter().print(JSONObject.fromObject(message).toString());
			this.response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
