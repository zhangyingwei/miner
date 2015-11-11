<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>rssreader4j服务信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 	<script type="text/javascript" src="assets/js/jquery-2.0.3.min.js"></script>
  </head>
  
  <body>
  	<div style="margin-top:10%;">
  		<div id="typefield" style="text-align:center; padding:10%; height:100%;line-height:40px; font-size:20px; font-family: '微软雅黑'"></div>
	  	<h2 id="message" style="display:none;">${message }</h2>
  	</div>
  </body>
   <script language="javascript" type="text/javascript">
    	$(function(){
	        var max=0;
	        function keeptext(){
	            max=keeptext.arguments.length;
	            for(var i=0;i<=max;i++)
	                this[i]=keeptext.arguments[i];
	        }
	        var myvlue = $("#message").html();
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
</html>
