function preview(img, selection) {
	if (!selection.width || !selection.height)
	return;

	var scaleX = 100 / selection.width;
	var scaleY = 100 / selection.height;

	$('#preview img').css({
	width: Math.round(scaleX * 400),
	height: Math.round(scaleY * 500),
	marginLeft: -Math.round(scaleX * selection.x1),
	marginTop: -Math.round(scaleY * selection.y1)
	});

$('#x1').val(selection.x1);
$('#y1').val(selection.y1);
$('#x2').val(selection.x2);
$('#y2').val(selection.y2);
$('#w').val(selection.width);
$('#h').val(selection.height);    
}

$(function () {
$('#photo').imgAreaSelect({ aspectRatio: '1:1', handles: true,
fadeSpeed: 200, onSelectChange: preview });
});