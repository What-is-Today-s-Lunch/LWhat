function ChangeValue(){
var value_str = document.getElementById('select_value');
alert("value: "+value_str.options[value_str.selectedIndex].value);
}