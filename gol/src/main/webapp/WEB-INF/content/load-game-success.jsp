<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/gol.js"></script>
<script type="text/javascript">
/* function setListener() {
	$('input[type="submit"]').click(function() {
		$(this).toggleClass('red');
	});
} */
</script>
<style type="text/css">
.red {
	background-color: red;
}
</style>
</head>
<body onload="setListener()">
	<h2>
		<s:property value="gamename" />
	</h2>
	<button onclick="playGame()">Start Game</button>
	<br />
	<s:hidden name="playMaxX" id="playMaxX" value="%{max_x}"  />
	<s:hidden name="playMaxY" id="playMaxY" value="%{max_x}"  />
	<s:iterator var="y" begin="1" end="%{max_y}">
		<s:iterator var="x" begin="1" end="%{max_x}">
			<s:submit id="%{max_y * (#y - 1) + #x}" value="" align="left"
				cssStyle="float:left;" />
		</s:iterator>
		<br />
		<br />
	</s:iterator>
</body>
</html>