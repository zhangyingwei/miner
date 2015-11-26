<%@ page language="java" import="java.util.*,com.zhangyingwei.miner.rssclient.entity.User,com.zhangyingwei.miner.common.util.TokenUtil" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)session.getAttribute("logonuser");
String tokenstr = TokenUtil.TOKEN_KEY+"="+session.getAttribute(TokenUtil.TOKEN_KEY);
%>

<!DOCTYPE html>
<html lang="en" height="100%">
	<head>
		<meta charset="utf-8" />
		<title>Miner[掘金者]</title>
		<meta name="keywords" content="rss,rss阅读器,java,rssreader4j" />
		<meta name="description" content="rss阅读器,java写的rss阅读器" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="<%=basePath %>assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=basePath %>assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=basePath %>assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<!-- page specific plugin styles -->
		<!-- fonts -->
		<link rel="stylesheet" href="<%=basePath %>assets/css/font.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="<%=basePath %>assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=basePath %>assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=basePath %>assets/css/ace-skins.min.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=basePath %>assets/css/ace-ie.min.css" />
		<![endif]-->
		<!-- inline styles related to this page -->
		<!-- ace settings handler -->
		<script src="<%=basePath %>assets/js/ace-extra.min.js"></script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="<%=basePath %>assets/js/html5shiv.js"></script>
		<script src="<%=basePath %>assets/js/respond.min.js"></script>
		<![endif]-->
		<script type="<%=basePath %>assets/js/jquery-2.0.3.min.js"></script>
		
		<!-- icon -->
		<link rel="shortcut icon" href="<%=basePath %>images/icon_mini.ico" type="image/x-icon" />
	</head>

	<body height="100%">
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small><i class="icon-leaf"></i>Miner[掘金者]</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">

						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info"><small>欢迎光临,</small>${logonuser.getUsername()}</span>
								<i class="icon-caret-down"></i>
							</a>
							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="logout.do"><i class="icon-off"></i>退出</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<!--菜单-->
					<ul class="nav nav-list">
						<li class="active">
							<a>
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 控制台 </span>
							</a>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-book"></i>
								<span class="menu-text"> 订阅 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a href="weblist.do?<%=tokenstr %>" target="sonwin"><i class="icon-double-angle-right"></i>RSS订阅管理</a>
								</li>
								<li style="display:none">
									<a href="wxweblist.do?<%=tokenstr %>" target="sonwin"><i class="icon-double-angle-right"></i>微信公众号订阅管理</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 阅读 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="articlelist.do?<%=tokenstr %>" target="sonwin"><i class="icon-double-angle-right"></i>RSS阅读列表</a>
								</li>
								<li style="display:none">
									<a href="wxmessagelist.do?<%=tokenstr %>" target="sonwin"><i class="icon-double-angle-right"></i>微信公众号阅读列表</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					<iframe id="sonwin" name="sonwin" src="mainshow.do?<%=tokenstr %>" style="width:100%;height:100%;border:0;" scrolling="auto" >
					</iframe>
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->

        <!-- <![endif]-->

		<!--[if IE]>
		 <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
		<![endif]-->
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=basePath %>assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>
		<!-- <![endif]-->
		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='<%=basePath %>assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=basePath %>assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="<%=basePath %>assets/js/bootstrap.min.js"></script>
		<script src="<%=basePath %>assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<!--[if lte IE 8]>
		  <script src="<%=basePath %>assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="<%=basePath %>assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=basePath %>assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=basePath %>assets/js/jquery.slimscroll.min.js"></script>
		<script src="<%=basePath %>assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=basePath %>assets/js/jquery.sparkline.min.js"></script>
		<script src="<%=basePath %>assets/js/flot/jquery.flot.min.js"></script>
		<script src="<%=basePath %>assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=basePath %>assets/js/flot/jquery.flot.resize.min.js"></script>
		<!-- ace scripts -->
		<script src="<%=basePath %>assets/js/ace-elements.min.js"></script>
		<script src="<%=basePath %>assets/js/ace.min.js"></script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				$('#sonwin').css('height',$(window).height()-50	);
			})
		</script>
</body>
</html>

