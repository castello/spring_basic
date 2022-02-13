on>로그인</button>
	<div>
		<label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> 아이디 기억</label> |
		<a href="">비밀번호 찾기</a> |
		<a href="">회원가입</a>
	</div>
	<script>
		function formCheck(frm) {
			var msg ='';
			if(frm.id.value.length==0) {
				setMessage('id를 입력해주세요.', frm.id);
				return false;
			}
			if(frm.pwd.value.length==0) {
				setMessage('password를 입력해주세요.', frm.pwd);
				return false;
			}
			return true;
		}
		function setMessage(msg, element){
			document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
			if(element) {
				element.select();
			}
		}
	</script>
</form>
</body>
</html>
