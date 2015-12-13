<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="2;url=../product/list.do">
<title>로그인 실패</title>

<style rel="stylesheet">
html {
  width: 100%;
  height: 100%;
}

body {
  background: #f5f5f5;
  color: rgba(0, 0, 0, 0.6);
  font-family: "Roboto", sans-serif;
  font-size: 14px;
  line-height: 1.6em;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.overlay, .form-panel.one:before {
  position: absolute;
  top: 0;
  left: 0;
  display: none;
  background: rgba(0, 0, 0, 0.8);
  width: 100%;
  height: 100%;
}

.form {
  z-index: 15;
  position: relative;
  background: #FFFFFF;
  width: 600px;
  border-radius: 4px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
  margin: 100px auto 10px;
  overflow: hidden;
  font-family: inherit;
}

.form-panel {
  padding: 60px calc(5% + 60px) 60px 60px;
  box-sizing: border-box;
  height: 495px
}
.form-panel.one:before {
  content: '';
  display: block;
  opacity: 0;
  visibility: hidden;
  -webkit-transition: 0.3s ease;
          transition: 0.3s ease;
}
.form-panel.one.hidden:before {
  display: block;
  opacity: 1;
  visibility: visible;
}

.form-header {
  margin: 0 0 40px;
}
.form-header h1 {
  padding: 4px 0;
  color: #990000;
  font-size: 32px;
  font-weight: 700;
  text-transform: uppercase;
}
.two .form-header h1 {
  position: relative;
  z-index: 40;
  color: #FFFFFF;
}

.content {
  font-size: 20px; 
  color: #000000;
}

.errorimage {
  height: 175px;
  width: 130px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

</style>

<div class="form">
  <div class="form-panel one">
    <div class="form-header">
      <h1>로그인 실패</h1>
    </div>
    <div class="errorimage">
       <img src="../img/logout2.png" width="150px" height="150px">
    </div>
    <p class="content" font-color="">이메일 또는 암호가 일치하지 않습니다.</p>
    <p>잠시 후 다시 시도하세요.</p>
  </div>       
</div>


</body>
</html>