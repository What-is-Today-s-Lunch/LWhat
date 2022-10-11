/**
 * 
 */
var temp;
 	function output() {
	for (i = 1; i <= 4; i++) {
		var input = document.getElementById("input" + i).value;
		temp = input;
		document.getElementById("output" + i).value = temp;
	}
}