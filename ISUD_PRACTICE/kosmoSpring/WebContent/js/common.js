

function comma(s){
	let result = s.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	console.log(result);
	return result;
}


function comma_replace(s){
	let result = s.toString().replace(/,/g, "");
	console.log(result);
	return result;
}

function numpad(s) {
	if (s.length == 1){
		s = '0' + s;
	}
	return s;
}