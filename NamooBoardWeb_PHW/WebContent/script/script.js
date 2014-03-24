function modify() {
	//
	history.back();
};

function checkForm() {
	if (document.getElementById("inputText").value) {
		//
		var pays = document.getElementsByName("pay");
		for (var i=0; i<pays.length; i++) {
			if (pays[i].checked == true) {
				return true;
			}
		}
		alert("모두 입력해주세요.");
		return false;
	}
	alert("모두 입력해주세요.");
	return false;
}


