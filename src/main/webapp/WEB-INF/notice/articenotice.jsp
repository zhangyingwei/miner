<%@ page language="java" import="java.util.*,com.zhangyingwei.miner.common.util.TokenUtil" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String tokenstr = TokenUtil.TOKEN_KEY+"="+session.getAttribute(TokenUtil.TOKEN_KEY);
%>

<!DOCTYPE html>
<html lang="en" height="100%">
<head>
<meta charset="utf-8" />
<title></title>
<!-- basic styles -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />

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
<style type="text/css">
	body {
		height: 100%;
	}
	
	.page-content {
		height: 100%;
	}
	
	html {
		background: #fff;
	}
	
	img {
		max-width: 100%;
	}
	
	.loadwrap {
		position: absolute;
		left: 0;
		width: 100%;
		text-align: center;
	}
</style>
</head>
<body>
	<div style="display:none" id="tokenstr"><%=tokenstr %></div>
	<div class="breadcrumbs" id="breadcrumbs">
		<div class="visible-md visible-lg hidden-sm btn-group"
			style="padding:0 10px;">
			<i class="icon-bookmark icon-red"></i> 当前共有<span
				class="badge badge-danger">${pageinfo.total }</span>篇未读文章...
		</div>
	</div>
	<div id="loadimg" class="loadwrap"><img src="images/loading.gif" /></div>
	<div class="page-content">
		<c:forEach items="${articles }" var="article">
				<div class="widget-container-span" style="width:23%; float:left; margin:1%; display:none;">
					<div class="widget-box light-border">
						<div
							class="widget-header header-color-dark header-color-pink header-color-blue ">
							<h5 class="smaller">
								<a href="${article.elink}" class="articletitle" target="_blank" style="color:#fff" ; title="${article.etitle}">${article.etitle}</a>
							</h5>
							<div class="widget-toolbar">
								<span class="btn btn-minier btn-danger notintr">不感兴趣</span>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-6">
								<div class="alert alert-info edescription" style="height:100px;">${article.edescription}</div>
							</div>
						</div>
						<div style="padding:4px; border-left:1px solid #D6D6D6;border-right:1px solid #D6D6D6;">
							<a href="${article.slink}" title="${article.stitle}" target="_blank" class="label label-warning arrowed-right websitename" style="text-decoration:none;">${article.stitle}</a>
						</div>
					</div>
				</div>
		</c:forEach>
		
		<div style="padding:0 20%">
			<ul class="pagination">
				<c:forEach begin="1" end="${pageinfo.totalPage }" var="p">
					<li class="pagenums" style="display:none;"  
						<c:if test="${pageinfo.currentPage==p }">
							class="active"
						</c:if>
					>
						<a href="#">${p }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		
	</div>

	<jsp:include page="../common/include_foot.jsp"></jsp:include>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			
			var tokenstr = $("#tokenstr").text();
			
			$(".notintr").click(function() {
				//alert('不感兴趣');
				var elink = $(this).parent().prev().find('a').attr('href');
				articleDelete(elink);
				//$(this).parent().parent().parent().parent().remove();
			});
			$(".articletitle").click(function(){
				var elink = $(this).attr('href');
				articleDelete(elink);
				//$(this).parent().parent().parent().parent().remove();
			});
			//截取文章标题
			$(".articletitle").each(function() {
				var text = $(this).text();
				$(this).text(subString(text, 10));
			});
			
			$("#loadimg").hide();
			
			//截取简介内容
			$(".alert-info").each(function(){
				var text = $(this).text();
				if(text==undefined||text.length==0){
					text="没有简介...";
				}
				$(this).text(subString(text,40));
				$(this).parent().parent().parent().parent().slideDown(800);//缓慢显示
			});

			$(".websitename").each(function() {
				var text = $(this).text();
				$(this).text(subString(text, 16));
			});

			$(".pagination").find("li").each(function(){
				$(this).click(function(){
					location.href="articlelist.do?currentPage="+$(this).find("a").text()+"&"+tokenstr;
				});
			});
			
			showPageNums();//显示页码信息
			
			//截取文字
			function subString(str, len) {
				if (str.length > len) {
					return str.substring(0, len) + "...";
				}
				return str;
			}
			
			
			//发送ajax请求
			function articleDelete(elink){
				$.ajax({
					type:'POST',
					url:'articledel.do',
					dataType:'josn',
					data:{'elink':elink},
					success:function(data){
						console.log(data.message);
						location.href="articlelist.do?"+tokenstr;
					},
					error:function(data){
						console.log("err");
						location.href="articlelist.do?"+tokenstr;
					}
				});
			}
			
			function showPageNums(){
				var pagenums = $(".pagenums");
				var nums = pagenums
				$(".pagenums").each(function(){
					$(this).show(3000);
				});
			}
		})
	</script>
	<!-- <script type="text/javascript" src="js/flow-box.js"></script> -->
</body>
</html>