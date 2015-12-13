<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
 integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
 crossorigin="anonymous">
 
 
 <link rel="stylesheet" type="text/css" href="../css/style.css" />

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 
 <style>
.form-container {
   border: 2px solid #f5f5f5;
   background: #f5f5f5;
   background: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5), to(#f5f5f5));
   background: -webkit-linear-gradient(top, #f5f5f5, #f5f5f5);
   background: -moz-linear-gradient(top, #f5f5f5, #f5f5f5);
   background: -ms-linear-gradient(top, #f5f5f5, #f5f5f5);
   background: -o-linear-gradient(top, #f5f5f5, #f5f5f5);
   background-image: -ms-linear-gradient(top, #f5f5f5 0%, #f5f5f5 100%);
   -webkit-border-radius: 11px;
   -moz-border-radius: 11px;
   border-radius: 11px;
   -webkit-box-shadow: rgba(000,000,000,0.9) 0 1px 2px, inset rgba(255,255,255,0.4) 0 0px 0;
   -moz-box-shadow: rgba(000,000,000,0.9) 0 1px 2px, inset rgba(255,255,255,0.4) 0 0px 0;
   box-shadow: rgba(000,000,000,0.9) 0 1px 2px, inset rgba(255,255,255,0.4) 0 0px 0;
   font-family: 'Helvetica Neue',Helvetica,sans-serif;
   text-decoration: none;
   vertical-align: middle;
   min-width:300px;
   padding:20px;
   width:300px;
   }
.form-field {
   border: 1px solid #000000;
   background: #ffffff;
   -webkit-border-radius: 4px;
   -moz-border-radius: 4px;
   border-radius: 4px;
   color: #000000;
   -webkit-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(000,000,000,0.7) 0 0px 0px;
   -moz-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(000,000,000,0.7) 0 0px 0px;
   box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(000,000,000,0.7) 0 0px 0px;
   padding:8px;
   margin-bottom:20px;
   width:280px;
   }
.form-field:focus {
   background: #ffffff;
   color: #5662b0;
   }
.form-container h2 {
   text-shadow: #fdf2e4 0 1px 0;
   font-size:18px;
   margin: 0 0 10px 0;
   font-weight:bold;
   text-align:center;
    }
.form-title {
   margin-bottom:10px;
   color: #0f0f0f;
   text-shadow: #fdf2e4 0 1px 0;
   }
.submit-container {
   margin:8px 0;
   text-align:right;
   }
.submit-button {
   border: 1px solid #302726;
   background: #ffffff;
   background: -webkit-gradient(linear, left top, left bottom, from(#bab8b8), to(#ffffff));
   background: -webkit-linear-gradient(top, #bab8b8, #ffffff);
   background: -moz-linear-gradient(top, #bab8b8, #ffffff);
   background: -ms-linear-gradient(top, #bab8b8, #ffffff);
   background: -o-linear-gradient(top, #bab8b8, #ffffff);
   background-image: -ms-linear-gradient(top, #bab8b8 0%, #ffffff 100%);
   -webkit-border-radius: 8px;
   -moz-border-radius: 8px;
   border-radius: 8px;
   -webkit-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   -moz-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   text-shadow: #ffffff 0 1px 0;
   color: #302726;
   font-family: helvetica, serif;
   padding: 8.5px 18px;
   font-size: 14px;
   text-decoration: none;
   vertical-align: middle;
   }
.submit-button:hover {
   border: 1px solid #01010a;
   text-shadow: #31540c 0 1px 0;
   background: #ffffff;
   background: -webkit-gradient(linear, left top, left bottom, from(#302726), to(#ffffff));
   background: -webkit-linear-gradient(top, #302726, #ffffff);
   background: -moz-linear-gradient(top, #302726, #ffffff);
   background: -ms-linear-gradient(top, #302726, #ffffff);
   background: -o-linear-gradient(top, #302726, #ffffff);
   background-image: -ms-linear-gradient(top, #302726 0%, #ffffff 100%);
   color: #ffffff;
   }
.submit-button:active {
   text-shadow: #31540c 0 1px 0;
   border: 1px solid #01010a;
   background: #38a610;
   background: -webkit-gradient(linear, left top, left bottom, from(#38a610), to(#ffffff));
   background: -webkit-linear-gradient(top, #38a610, #38a610);
   background: -moz-linear-gradient(top, #38a610, #38a610);
   background: -ms-linear-gradient(top, #38a610, #38a610);
   background: -o-linear-gradient(top, #38a610, #38a610);
   background-image: -ms-linear-gradient(top, #38a610 0%, #38a610 100%);
   color: #fff;
   }
</style>
 
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
 integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
 crossorigin="anonymous"></script>
<link href='../css/bootstrap.min.css' rel='stylesheet'>
<link href="../css/join.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<script>
   function check(id) {
       var oid = $("#" + id).val();
       var oMsg = $("#" + id + "Msg");
       var oDiv = $("#" + id + "Form");
       var btn = $("#joinBtn");

       btn.addClass("disabled");
       //oDiv.removeClass("has-success");
       //oDiv.addClass("has-error");
       if (oid == "") {
      oDiv.removeClass("has-success");
      oDiv.addClass("has-error");
      oMsg.css("display", "block");
      oMsg.html("필수 정보입니다.");

      return false;
       }

       if (id == "id" || id == "password" || id == "password2") {
      var isID = /^[a-z0-9_@.]{4,20}$/;
      if (!isID.test(oid)) {
          oDiv.removeClass("has-success");
          oDiv.addClass("has-error");
          oMsg.css("display", "block");
          oMsg.html("4-20자의 영소문자, 숫자와 특수기호(_)만 사용 가능합니다.");

          return false;
      }
       }

       if (id == "playerName") {
      var isName = /^[가-힝]{2,}$/;

      if (!isName.test(oid) || oid == "") {
          oDiv.removeClass("has-success");
          oDiv.addClass("has-error");
          oMsg.css("display", "block");
          oMsg.html("한글로 입력해주세요");

          return false;
      }

      else {
          oDiv.addClass("has-success");
          oDiv.removeClass("has-error");
          oMsg.css("display", "block");
          oMsg.html("OK");

          return true;
      }
       }
     

       if (id == "email") {
      var isEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
      if (!isEmail.test(oid)) {
          oDiv.removeClass("has-success");
          oDiv.addClass("has-error");
          oMsg.css("display", "block");
          oMsg.html("양식에 맞게 입력해주세요");
          
          
          return false;
          
      }else 
          {
             oDiv.removeClass("has-success");
             oDiv.addClass("has-error");
             oMsg.css("display", "block");
             oMsg.html("OK");
          }
       }
      
      

       if (id == "phone") {
      var isPhone = /[01](0|1|6|7|8|9)[-](\d{4}|\d{3})[-]\d{4}$/;
      if (!isPhone.test(oid)) {
          oDiv.removeClass("has-success");
          oDiv.addClass("has-error");
          oMsg.css("display", "block");
          oMsg.html("양식에 맞게 입력해주세요");

          return false;
      }else 
          {
          oDiv.removeClass("has-success");
          oDiv.addClass("has-error");
          oMsg.css("display", "block");
          oMsg.html("OK");
       }
    }

       if (id == "password") {
      oDiv.removeClass("has-error");
      oDiv.addClass("has-success");
      oMsg.css("display", "block");
      oMsg.html("사용 가능한 비밀번호입니다.");
      return true;
       }

       if (id == "password2") {
      var oPswd = $("#password").val();
      if (oPswd == "" || oPswd != oid) {
          oDiv.removeClass("has-success");
          oDiv.addClass("has-error");
          oMsg.css("display", "block");
          oMsg.html("비밀번호가 일치하지 않습니다.");
          return false;
      }
      oDiv.removeClass("has-error");
      oDiv.addClass("has-success");
      oMsg.css("display", "block");
      oMsg.html("비밀번호가 일치합니다.");
      return true;
       }
   }
</script>

</head>
<body>

<section>
<article>
<fieldset class="row div div-join">
  <form action='update.do' method='post' enctype="multipart/form-data">
    <div class="panel panel-default">
     
      <div class="panel-heading">
       <label>회원 정보 수정</label>
      </div>
      
      <div class="panel-body">
        <div id="emailForm" class="form-group has-feedback">
        <label for="email">이메일</label> 
        <input type="text" class="form-control" id="email" name="email" value="${loginUser.email}"
         autofocus="true" onchange="check(this.id); nullCheck();">
       </div>
       
        <hr>
       <div id="passwordForm" class="form-group has-feedback">
        <label for="password">새로운 비밀번호</label> 
        <input type="password" class="form-control" id="password" name="password"
         maxlength="20" placeholder="새로운 비밀번호를 입력하세요." onchange="check(this.id); nullCheck();">
        <div class="control-label" id="passwordMsg" style="display: none;">필수 정보입니다.</div>
       </div>
       
       <div id="password2Form" class="form-group has-feedback">
        <label for="password2">새로운 비밀번호 확인</label> 
        <input type="password" class="form-control" id="password2" name="password2" maxlength="20"
         placeholder="새로운 비밀번호를 한번 더 입력하세요." onchange="check(this.id); nullCheck();">
        <div class="control-label" id="password2Msg" style="display: none;">필수 정보입니다.</div>
       </div>
       
       <hr>
       <div id="playerNameForm" class="form-group has-feedback">
        <label for="playerName">이름</label> 
        <input type="text" class="form-control" id="playerName" name="name" maxlength="20"
         autofocus="true" placeholder="이름을 입력하세요." onchange="check(this.id); nullCheck();">
        <div class="control-label" id="playerNameMsg" style="display: none;">필수 정보입니다.</div>
       </div>
       
       <div id="phoneForm" class="form-group has-feedback">
        <label for="phone">휴대전화번호</label>
        <input type="text" class="form-control" id="phone" name="tel" maxlength="13"
         placeholder="휴대전화번호를 입력해주세요 (예) 010-1234-5678" onchange="check(this.id); nullCheck();">
        <div class="control-label" id="phoneMsg" style="display: none;">양식에 맞게 입력해주세요.</div>
       </div>
       
      
       
       <div class="div-center">
        <button type="submit" id="joinBtn" class="btn btn-lg btn-primary btn-join">가입</button>
        <a type="button" class="btn btn-lg btn-danger btn-cancel" href="list.do">취소</a>
       </div>
      </div>
      
     </div>
    </form>
    
  </fieldset>
  </article>
 </section>

</body>
</html>