<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--[if !IE]> -->

<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>  -->

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
	window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
   
   <script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="assets/js/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
<script src="assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="assets/js/bootbox.min.js"></script>
<script src="assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="assets/js/jquery.gritter.min.js"></script>

<!-- ace scripts -->

<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>

<div class='modal-backdrop fade in' style="display:none;" id='mask'><img style="margin-left:49%;margin-top:25%;" src='images/loading2.gif' /></div>

<script>
	function showErrorMsg(titlemsg,contentmsg,before_close,after_close){
		$.gritter.add({
			title: titlemsg,
			text: contentmsg,
			time:1000,
			before_close:before_close,
			after_close:after_close,
			class_name: 'gritter-error gritter-center'
		});
	}
	
	function showSuccMsg(titlemsg,contentmsg,before_close,after_close){
		$.gritter.add({
			title: titlemsg,
			text: contentmsg,
			time:1000,
			before_close:before_close,
			after_close:after_close,
			class_name: 'gritter-success gritter-center'
		});
	}
	
	function showMsg(titlemsg,contentmsg,before_close,after_close){
		$.gritter.add({
			title: titlemsg,
			text: contentmsg,
			sticky: false,
			time: '1000',
			before_close:before_close,
			after_close:after_close,
			class_name: 'gritter-light'
		});
	}
	
	function Mask(){
		this.show = function(){
			$("#mask").show();
		}
		this.hide = function(){
			$("#mask").hide();
		}
	}
	
	var mask = new Mask();
	
</script>

