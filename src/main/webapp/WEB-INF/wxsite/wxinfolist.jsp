<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- basic styles -->

    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
    
    <link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.full.min.css"/>
    <link rel="stylesheet" src="assets/js/jquery.ui.touch-punch.min.js"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="assets/js/ace-extra.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body style="background:#fff;">
    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th class="hidden-50">名称</th>
            <th class="hidden-580">描述</th>
            <th class="hidden-480" style="min-width:50px;">订阅</th>
        </tr>
        </thead>

        <tbody id="wxinfostablelist">
        	<c:forEach var="wxinfo" items="${wxinfos }">
	            <tr style="height:auto;">
	                <td><span class="label label-lg label-primary arrowed-right">${wxinfo.name }</span></td>
	                <td class="description"><a>${wxinfo.description }</a></td>
	                <td>
	                	<label class="inline">
							<input id="id-pills-stacked"  type="checkbox" class="ace ace-switch ace-switch-5 checklist" />
							<span class="lbl"></span>
						</label>
	                </td>
	            </tr>
        	</c:forEach>
        </tbody>
    </table>
    
   	<jsp:include page="../common/include_foot.jsp"></jsp:include>
	<!-- inline scripts related to this page -->
    <script type="text/javascript">
	    jQuery(function($){
	    	$(".checklist").click(function(){
	    		var name = $(this).parent().parent().prev().prev().find("span").text();
	    		if(this.checked){
	    			add(name);
	    		}else{
	    			del(name);
	    		}
	    	});
	    	
	    	function add(name){
	    		$.ajax({
	    			type:'POST',
	    			url:'savewxsite.do',
	    			dataType:'json',
    				data:{'wxname':name},
    				success:function(data){
    					console.log(data.message);
    				}
	    		});
	    	}
	    	
	    	function del(name){
	    		console.log("del:"+name);
	    	}
	    })
    </script>
</body>
</html>