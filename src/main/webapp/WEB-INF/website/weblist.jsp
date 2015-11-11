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
    
    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.custom.min.css" />
	<link rel="stylesheet" href="assets/css/jquery.gritter.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>

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
            <th class="hidden-580">地址</th>
            <th class="hidden-480" style="min-width:50px;">操作</th>
        </tr>
        </thead>

        <tbody>
        	<c:forEach var="website" items="${websites }">
	            <tr>
	                <td><span class="label label-lg label-primary arrowed-right">${website.id }</span></td>
	                <td><a href="${website.link }" target="_blank">${website.title }</a></td>
	                <td class="description"><a>${website.description }</a></td>
	                <td><a>${website.websitelink }</a></td>
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
    
    
   	<jsp:include page="../common/include_foot.jsp"></jsp:include>
	<!-- inline scripts related to this page -->
    <script type="text/javascript">
	    jQuery(function($){
	    	$("#bootbox-regular").on(ace.click_event, function(data) {
				bootbox.prompt("<i class='icon-edit'></i>请输入RSS地址",function(result) {
					if (result === null|| result.length===0) {
						//showErrorMsg("提示","内容不能为空");
						//return false;
					} else {
						mask.show();
						$.ajax({
							type:'POST',
							url:'webadd.do',
							data:{'data':result},
							dataType:'json',
							success:function(data){
								showSuccMsg("提示",data.message,null,function(){
									mask.hide();
									location.href="weblist.do";
								});
							}
						});
					}
				});
			});
	    	
	    	
	    	$(".webdelbut").each(function(){
	    		$(this).click(function(){
	    			var website = $(this).parent().parent().prev().children().text();
	    			$.ajax({
	    				type:'POST',
	    				url:'webdel.do',
	    				dataType:'json',
	    				data:{'website':website},
	    				success:function(data){
	    					showSuccMsg("提示",data.message,null,function(){location.href="weblist.do"});
	    				}
	    			});
	    		})
	    	});
	    	
	    	$(".pagination").find("li").each(function(){
				$(this).click(function(){
					location.href="weblist.do?currentPage="+$(this).find("a").text();
				});
			});
	    })
	    
	    $(".description a").each(function(){
	    	$(this).css('color','#FD9B14');
	    	$(this).text($(this).text()===""||$(this).text()===undefined?'没有描述信息':$(this).text());
	    })
    </script>
</body>
</html>