var EventUtil={
	addHandler:function(element,type,handler){
		if(element.addEventListener){
			element.addEventListener(type,handler);
		}else if(element.attachEvent){
			element.attachEvent("on"+type,handler);
		}else{
			element[on+type]=handler;
		}
	}
};

(function start(){
	var table_left=document.getElementById('table_left');
	var li=table_left.getElementsByTagName('li');
	/*个人信息设置*/
	EventUtil.addHandler(li[0],"click",function(){
		$.ajax({
			type:"GET",
			dataType:"json",
			url:"",
			data:""
		}).success(function(data){
			var string1='<h3>我的基本信息</h3>\
				<form id="my_info" action="" target=""enctype="multipart/form-data" method="post">\
						<div id="nickname">\
					   		<label>昵称：</label><input name="nickname"type="text">\
						</div>\
						<div id="user_id">\
							<label>用户ID：</label><span></span>\
						</div>\
						<div id="personality">\
							<label>个性签名:</label><textarea name="personality"></textarea>\
						</div>\
						<div id="sex">\
							<label>性别：</label>\
							<input type="radio" name="sex"value="男"><span>男</span>\
							<input type="radio" name="sex"value="女"><span>女</span>\
							<input type="radio" name="sex"value="不明"><span>不明</span>\
						</div>\
						<div id="birth_date">\
							<label>出生日期：</label>\
							<select name="year">\
								<option value="1995">1995</option>\
								<option value="1996">1996</option>\
								<option value="1997">1997</option>\
							</select>\
							<select name="month">\
								<option value="1">1</option>\
								<option value="2">2</option>\
								<option value="3">3</option>\
								<option value="4">4</option>\
							</select>\
							<select name="day">\
							</select>\
						</div>\
						<div id="address">\
							<label>地址：</label>\
							<select name="city">\
								<option value="重庆">重庆</option>\
							</select>\
							<select name="thread">\
								<option value="重庆市">重庆市</option>\
							</select>\
						</div>\
						<div id="button">提交</div>\
					</form> '
			$('#table_right').eq(0).html(string1);
			/*构建select*/
			(function createSelect(){
				var year='';
				for(var i=1990;i<=10;i++){
					year+='<option value="'+i+'">+'+i+'</option>';
				}
				$('input[name="year"]').html(year);

				var month='';
				for(var i=1;i<=12;i++){
					month+='<option value="'+i+'">+'+i+'</option>';
				}
				var day='';
				for(var i=0;i<=31;i++){
					day+='<option value="'+i+'">+'+i+'</option>';
				}
				$('input[name="year"]').html(year);
			})();
			$('#button').click(function(){
				$('form').submit();
			})
			/*给选中的赋值*/
			$('input[name="nickname"]').val(data);
			$('user_id span').html(data);
			$('#personality textarea').html(data);
			if(data=="男"){
				$('input[name="sex"]').eq(0).prop('checked',true);
			}else if(data=="女"){
				$('input[name="sex"]').eq(1).prop('checked',true);
			}else{
				$('input[name="sex"]').eq(2).prop('checked',true);
			}
			$('select[name="year"] option').eq(data).prop('selected',true);
			$('select[name="month"] option').eq(data).prop('selected',true);
			$('select[name="day"] option').eq(data).prop('selected',true);
		})
	});
	/*个人头像设置*/
	EventUtil.addHandler(li[1],"click",function(){
		$.ajax({
			url:'',
			data:'',
			type:'GET',
			dataType:'json',
		}).success(function(){
			$('#table_right').html('<div id="personal_logo"><img id="info_setting_logo"src=""width="200px" height="200px"></div>\
					<form id="change_logo"action="" target=""enctype="multipart/form-data" method="post">\
					更换头像<input hidden type="file" id="logo_fileUp" name="person_logo" width="100px"/></form>\
					<h3>推荐</h3>\
					<div id="recommend">\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
						<div class="recommend_logo"><img src=""width="110px" height="110px"></div>\
					</div>');
			$('#personal_logo img').eq(0).porp("src",data);
			var $r_img=$('.recommend_logo img');
			for(var i=0;i<$r_img.length;i++){
				$r_img.eq(i).prop("src",data)
			}
			$('#change_logo').click(function(){
				$('input[name="personal_logo"]').trigger("click");
			})

		});
	})
})();