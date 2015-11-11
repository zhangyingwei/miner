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
    <meta name="viewport" content=	"width=device-width, initial-scale=1.0"/>

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
	<div style="height:40px;">
		<div class="visible-md visible-lg hidden-sm btn-group" style="float:right; width:100%;">
	    	<button class="btn btn-success" id="bootbox-regular" style="height:40px;width:100%;"><span style="margin-right:2em;font-weight:bold;">当前总数: ${pageinfo.total}</span><i class="icon-zoom-in bigger-130"></i></button>
	    </div>
	</div>
    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th class="hidden-50">编号</th>
            <th class="hidden-580">名称</th>
            <th class="hidden-580">描述</th>
            <th class="hidden-480" style="min-width:50px;">操作</th>
        </tr>
        </thead>

        <tbody>
        	<c:forEach var="wxsiteinfo" items="${wxsiteinfos }">
	            <tr>
	                <td><span class="label label-lg label-primary arrowed-right">${wxsiteinfo.id }</span></td>
	                <td>${wxsiteinfo.wxname }</td>
	                <td class="description"><a>${wxsiteinfo.description }</a></td>
	                <td>
	                    <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
	                        <a class="webdelbut red" href="#"><i class="icon-trash bigger-130"></i></a>
	                    </div>
	                </td>
	            </tr>
        	</c:forEach>
        </tbody>
        <tfoot style="text-align:center; background-color:#fff; height:100%;">
        	<tr>
        		<td colspan=5>
				    <div>
						<ul class="pagination">
							<c:forEach begin="1" end="${pageinfo.totalPage }" var="p">
								<li 
									<c:if test="${pageinfo.currentPage==p }">
										class="active"
									</c:if>
								>
									<a href="#">${p }</a>
								</li>
							</c:forEach>
						</ul>
					</div>
        		</td>
        	</tr>
        </tfoot>
    </table>
    
    <div id="dialog-message" class="hide">
	   	<div class="input-group">
			<input class="form-control input-mask-date wxname" name="wxname" type="text" id="form-field-mask-1" placeholder="请输入公众号名称" />
			<span class="input-group-btn">
				<button class="btn btn-sm btn-default" id="querybut">
					<i class="icon-globe bigger-110"></i>查询
				</button>
			</span>
		</div>
	   	<div id="framediv" style="margin-top:10px;"></div>
	</div>
    
   	<jsp:include page="../common/include_foot.jsp"></jsp:include>
	<!-- inline scripts related to this page -->
    <script type="text/javascript">
	    jQuery(function($){
	    	$( "#bootbox-regular" ).on('click', function(e) {
				e.preventDefault();
				var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
					modal: true,
					title: "微信公众号查询",
					width:"700",
					height:"400",
					buttons:[{
						text:"关闭",
						"class":"btn btn-primary btn-xs",
						click:function(){
							$( this ).dialog( "close" );
							//关闭窗口的时候刷新页面
							location.href="wxweblist.do"
						}
					}]
				});
				$(".ui-dialog-titlebar-close").hide();
	    	});
	    	
	    	$("#querybut").click(function(){
	    		$("#framediv").html("<img src='images/loading2.gif' style='margin:10% 47%'/>");
	    		var wxname = $(".wxname").val();
	    		$.ajax({
	    			type:'POST',
    				url:'searchwxsite.do',
    				dataType:'html',
    				data:{'wxname':wxname},
    				success:function(data){
    					$("#framediv").html(data);
    				},
    				error:function(){
    					$("#framediv").html("<h2 style='text-align:center;'>加载失败...</h2>");
    				}
	    		});
	    	});
	    	
	    	$(".webdelbut").each(function(){
	    		$(this).click(function(){
	    			var wxsiteid = $(this).parent().parent().prev().prev().prev().children().text();
	    			$.ajax({
	    				type:'POST',
	    				url:'delwxsite.do',
	    				dataType:'json',
	    				data:{'wxsiteid':wxsiteid},
	    				success:function(data){
	    					console.log(data.message);
	    					location.href="wxweblist.do";
	    				}
	    			});
	    		})
	    	});
	    	
	    	$(".pagination").find("li").each(function(){
				$(this).click(function(){
					location.href="wxweblist.do?currentPage="+$(this).find("a").text();
				});
			});
	    })
    </script>
</body>
</html>