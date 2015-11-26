<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" style="height:90%">
<head>
    <title></title>
    <script type="text/javascript" src="assets/js/jquery-2.0.3.min.js"></script>
    <script language="javascript" type="text/javascript">
    	$(function(){
    		var days = ["日","一","二","三","四","五","六"];
	        var max=0;
	        function keeptext(){
	            max=keeptext.arguments.length;
	            for(var i=0;i<=max;i++)
	                this[i]=keeptext.arguments[i];
	        }
	        var myvlue = $("#textfieldhtml").html();
	        myvlue+=new Date().getFullYear()+"年"+(new Date().getMonth()+1)+"月"+new Date().getDate()+"日  星期"+days[new Date().getDay()];
	        myvlue+="   至于天气嘛......额......不清楚......╭∩╮(︶︿︶)╭∩╮"
	        console.log(myvlue);
	        //mytext=new keeptext("My name is SeanHan.Talk is cheap,show me the code.");
	        mytext=new keeptext(myvlue);
	        var x=0,pos=0;
	        var len=mytext[0].length;
	        function typetext(){ 
	        	var mytt=document.getElementById("typefield");
	        	$("#typefield").text(mytext[x].substring(0,pos)+"_");
	            //mytt.value=mytext[x].substring(0,pos)+"_";
	            if(pos++==1){
	                setTimeout(typetext,1200);
	                if(++x==max) x=0;
	                len=mytext[x].length;
	                
	                if(!(mytext[x].length+1===(mytext[x].substring(0,pos)+"_").length)){
		                setTimeout(typetext,150);
	                }
	            }
	            else{
	                if(!(mytext[x].length+1===(mytext[x].substring(0,pos)+"_").length)){
		                setTimeout(typetext,150);
	                }
	            }
	        }
	        typetext();
    	});
    </script>
</head>
<body style="height:100%;">
<form name="typeform" runat="server" style="height:60%">
    <div style="height:100%;">
    	<div id="typefield" style="text-align:center; padding:10%; height:100%;line-height:40px; font-size:20px; font-family: '微软雅黑'"></div>
	    <div id="textfieldhtml" style="display:none">
	    	欢迎使用Miner[掘金者]  系统，当前时间是：
	    </div>
    </div>
</form>
</body>
