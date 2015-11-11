function flow(mh, mv) {// ����mh��mv�Ƕ������ݿ�֮��ļ�࣬mh��ˮƽ���룬mv�Ǵ�ֱ����
	var w = document.documentElement.offsetWidth;// ����ҳ����
	var ul = document.getElementById("flow-box");
	var li = $("li");
	var iw = li[0].offsetWidth + mh;// �������ݿ�Ŀ��
	var c = Math.floor(w / iw);// ��������
	ul.style.width = iw * c - mh + "px";// ����ul�Ŀ�����ʺϱ��������css�����margin���������ݾ���

	var liLen = li.length;
	var lenArr = [];
	for ( var i = 0; i < liLen; i++) {// ����ÿһ�����ݿ齫�߶ȼ�������
		lenArr.push(li[i].offsetHeight);
	}

	var oArr = [];
	for ( var i = 0; i < c; i++) {// �ѵ�һ���ŷźã�����ÿһ�еĸ߶ȼ�������oArr
		if(li[i]!=undefined){
			li[i].style.top = "0";
			li[i].style.left = iw * i + "px";
			li[i].style.opacity = "1";
			li[i].style["-moz-opacity"] = "1";
			li[i].style["filter"] = "alpha(opacity=100)";
		}
		oArr.push(lenArr[i]);
	}

	for ( var i = c; i < liLen; i++) {// ���������ݿ鶨λ����̵�һ�к��棬Ȼ���ٸ��¸��еĸ߶�
		var x = _getMinKey(oArr);// ��ȡ��̵�һ�е�����ֵ
		li[i].style.top = oArr[x] + mv + "px";
		li[i].style.left = iw * x + "px";
		li[i].style.opacity = "1";
		li[i].style["-moz-opacity"] = "1";
		li[i].style["filter"] = "alpha(opacity=100)";
		oArr[x] = lenArr[i] + oArr[x] + mv;// ���¸��еĸ߶�
	}
	document.getElementById("loadimg").style.top = _getMaxValue(oArr) + 50
			+ "px";// ��loading�Ƶ�����

}
// ���ڼ�����ɺ�ִ��
window.onload = function() {
	flow(10, 10)
	$('#loadimg').hide();
};
// �ı䴰�ڴ�Сʱ���²���
var re;
window.onresize = function() {
	clearTimeout(re);
	re = setTimeout(function() {
		flow(10, 10);
	}, 100);
}

// ��ȡ������������ֵ
function _getMaxValue(arr) {
	var a = arr[0];
	for ( var k in arr) {
		if (arr[k] > a) {
			a = arr[k];
		}
	}
	return a;
}
// ��ȡ����������Сֵ������
function _getMinKey(arr) {
	var a = arr[0];
	var b = 0;
	for ( var k in arr) {
		if (arr[k] < a) {
			a = arr[k];
			b = k;
		}
	}
	return b;
}