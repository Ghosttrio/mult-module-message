function del(mode,kind){
	const check = document.querySelectorAll('input[name="ck"]:checked');

	if(check.length > 0){
		let val = [];
		for(let i = 0; i < check.length; i++){
			val.push(check[i].value);
		}
		const d = confirm("선택하신 "+check.length+"개의 "+mode+"(을/를) 삭제하시겠습니까?");
		if(d){
			ajax('../mutldel', 'POST', {
			  	sno:val,
				mode:mode,
				kind: kind
			})
			  .then((data) => {
			  	alert(data.msg);

			  	if(data.location != null) {
					location.href=data.location;
				}else {
					location.href=document.location.href;
				}
			  })
			  .catch((error) => console.log(error));
		}
	}else{
		alert("삭제할 게시판을 선택해주세요.");
	}
}

function userUnsubs(){
	const check = document.querySelectorAll('input[name="ck"]:checked');

	if(check.length > 0){
		const val = [];
		for(let i = 0; i < check.length; i++){
			val.push(check[i].value);
		}
		const d = confirm("선택하신 "+check.length+"명의 회원을 탈퇴시키겠습니까?");
		if(d){
			console.log(val.pop());
			ajax('./delete', 'POST', {"list":val})
			  .then((data) => {
			  	alert(data);
				location.href=document.location.href;
			  })
			  .catch((error) => console.log(error));
		}
	}else{
		alert("탈퇴시킬 회원을 선택해주세요.");
	}
}

