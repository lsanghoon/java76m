<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> FASHION MAKER </title>

<link rel="stylesheet" type="text/css" href="../css/style.css" />

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style>
.button {
   border: 2px solid #4f4f4f;
   background: #ffffff;
   background: -webkit-gradient(linear, left top, left bottom, from(#a3a3a3), to(#ffffff));
   background: -webkit-linear-gradient(top, #a3a3a3, #ffffff);
   background: -moz-linear-gradient(top, #a3a3a3, #ffffff);
   background: -ms-linear-gradient(top, #a3a3a3, #ffffff);
   background: -o-linear-gradient(top, #a3a3a3, #ffffff);
   background-image: -ms-linear-gradient(top, #a3a3a3 0%, #ffffff 100%);
   padding: 7px 14px;
   -webkit-border-radius: 13px;
   -moz-border-radius: 13px;
   border-radius: 13px;
   -webkit-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   -moz-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   text-shadow: #ffffff 0 1px 0;
   color: #000000;
   font-size: 15px;
   text-decoration: none;
   vertical-align: middle;
   }
.button:hover {
   border: 2px solid #000000;
   text-shadow: #1e4158 0 1px 0;
   background: #cfcfcf;
   background: -webkit-gradient(linear, left top, left bottom, from(#707070), to(#cfcfcf));
   background: -webkit-linear-gradient(top, #707070, #cfcfcf);
   background: -moz-linear-gradient(top, #707070, #cfcfcf);
   background: -ms-linear-gradient(top, #707070, #cfcfcf);
   background: -o-linear-gradient(top, #707070, #cfcfcf);
   background-image: -ms-linear-gradient(top, #707070 0%, #cfcfcf 100%);
   color: #fff;
   }
.button:active {
   text-shadow: #1e4158 0 1px 0;
   border: 2px solid #000000;
   background: #949294;
   background: -webkit-gradient(linear, left top, left bottom, from(#474747), to(#cfcfcf));
   background: -webkit-linear-gradient(top, #474747, #949294);
   background: -moz-linear-gradient(top, #474747, #949294);
   background: -ms-linear-gradient(top, #474747, #949294);
   background: -o-linear-gradient(top, #474747, #949294);
   background-image: -ms-linear-gradient(top, #474747 0%, #949294 100%);
   color: #fff;
   }
   
   .button1 {
   border: 2px solid #4f4f4f;
   background: #ffffff;
   background: -webkit-gradient(linear, left top, left bottom, from(#a3a3a3), to(#ffffff));
   background: -webkit-linear-gradient(top, #a3a3a3, #ffffff);
   background: -moz-linear-gradient(top, #a3a3a3, #ffffff);
   background: -ms-linear-gradient(top, #a3a3a3, #ffffff);
   background: -o-linear-gradient(top, #a3a3a3, #ffffff);
   background-image: -ms-linear-gradient(top, #a3a3a3 0%, #ffffff 100%);
   padding: 9px 14px;
   -webkit-border-radius: 13px;
   -moz-border-radius: 13px;
   border-radius: 13px;
   -webkit-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   -moz-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 1px 0;
   text-shadow: #ffffff 0 1px 0;
   color: #000000;
   font-size: 15px;
   text-decoration: none;
   vertical-align: middle;
   }
.button1:hover {
   border: 2px solid #000000;
   text-shadow: #1e4158 0 1px 0;
   background: #cfcfcf;
   background: -webkit-gradient(linear, left top, left bottom, from(#707070), to(#cfcfcf));
   background: -webkit-linear-gradient(top, #707070, #cfcfcf);
   background: -moz-linear-gradient(top, #707070, #cfcfcf);
   background: -ms-linear-gradient(top, #707070, #cfcfcf);
   background: -o-linear-gradient(top, #707070, #cfcfcf);
   background-image: -ms-linear-gradient(top, #707070 0%, #cfcfcf 100%);
   color: #fff;
   }
.button1:active {
   text-shadow: #1e4158 0 1px 0;
   border: 2px solid #000000;
   background: #949294;
   background: -webkit-gradient(linear, left top, left bottom, from(#474747), to(#cfcfcf));
   background: -webkit-linear-gradient(top, #474747, #949294);
   background: -moz-linear-gradient(top, #474747, #949294);
   background: -ms-linear-gradient(top, #474747, #949294);
   background: -o-linear-gradient(top, #474747, #949294);
   background-image: -ms-linear-gradient(top, #474747 0%, #949294 100%);
   color: #fff;
   }
/*-------------------------------*/
/*           VARIABLES           */
/*-------------------------------*/


body {
  position: relative;
  overflow-x: hidden;
}

body, html {
  height: 100%;
  background-color: whitesmoke;
}

.nav .open > a { background-color: transparent; }

.nav .open > a:hover { background-color: transparent; }

.nav .open > a:focus { background-color: transparent; }

/*-------------------------------*/
/*           Wrappers            */
/*-------------------------------*/

#wrapper {
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  padding-left: 0;
  -webkit-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#wrapper.toggled { padding-left: 220px; }

#wrapper.toggled #sidebar-wrapper { width: 220px; }

#wrapper.toggled #page-content-wrapper {
  margin-right: -220px;
  position: absolute;
}

#sidebar-wrapper {
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  background: #1a1a1a;
  height: 100%;
  left: 220px;
  margin-left: -220px;
  overflow-x: hidden;
  overflow-y: auto;
  -webkit-transition: all 0.5s ease;
  transition: all 0.5s ease;
  width: 0;
  z-index: 1000;
}
#sidebar-wrapper::-webkit-scrollbar {
 display: none;
}

#page-content-wrapper {
  padding-top: 70px;
  width: 100%;
}

/*-------------------------------*/
/*     Sidebar nav styles        */
/*-------------------------------*/

.sidebar-nav {
  list-style: none;
  margin: 0;
  padding: 0;
  position: absolute;
  top: 0;
  width: 220px;
}

.sidebar-nav li {
  display: inline-block;
  line-height: 20px;
  position: relative;
  width: 100%;
}

.sidebar-nav li:before {
  -moz-transition: width 0.2s ease-in;
  -ms-transition: width 0.2s ease-in;
  -webkit-transition: width 0.2s ease-in;
  background-color: #1c1c1c;
  content: '';
  height: 100%;
  left: 0;
  position: absolute;
  top: 0;
  -webkit-transition: width 0.2s ease-in;
  transition: width 0.2s ease-in;
  width: 3px;
  z-index: -1;
}

.sidebar-nav li:first-child a {
  background-color: #1a1a1a;
  color: #ffffff;
}

.sidebar-nav li:nth-child(2):before { background-color: #ffb90f; }

.sidebar-nav li:nth-child(3):before { background-color: #ffc026; }

.sidebar-nav li:nth-child(4):before { background-color: #ffc73e; }

.sidebar-nav li:nth-child(5):before { background-color: #ffce57; }

.sidebar-nav li:nth-child(6):before { background-color: #ffd56f; }

.sidebar-nav li:nth-child(7):before { background-color: #ffdc87; }

.sidebar-nav li:nth-child(8):before { background-color: #ffe39f; }

.sidebar-nav li:nth-child(9):before { background-color: #ffeab7; }

.sidebar-nav li:hover:before {
  -webkit-transition: width 0.2s ease-in;
  transition: width 0.2s ease-in;
  width: 100%;
}

.sidebar-nav li a {
  color: #dddddd;
  display: block;
  padding: 10px 15px 10px 30px;
  text-decoration: none;
}

.sidebar-nav li.open:hover before {
  -webkit-transition: width 0.2s ease-in;
  transition: width 0.2s ease-in;
  width: 100%;
}

.sidebar-nav .dropdown-menu {
  background-color: #222222;
  border-radius: 0;
  border: none;
  box-shadow: none;
  margin: 0;
  padding: 0;
  position: relative;
  width: 100%;
}

.sidebar-nav li a:hover, .sidebar-nav li a:active, .sidebar-nav li a:focus, .sidebar-nav li.open a:hover, .sidebar-nav li.open a:active, .sidebar-nav li.open a:focus {
  background-color: transparent;
  color: #ffffff;
  text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
  font-size: 20px;
  height: 65px;
  line-height: 44px;
}

/*-------------------------------*/
/*       Hamburger-Cross         */
/*-------------------------------*/

.hamburger {
  background: transparent;
  border: none;
  display: block;
  height: 32px;
  margin-left: 15px;
  position: fixed;
  top: 20px;
  width: 32px;
  z-index: 999;
}

.hamburger:hover { outline: none; }

.hamburger:focus { outline: none; }

.hamburger:active { outline: none; }

.hamburger.is-closed:before {
  -webkit-transform: translate3d(0, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  color: #ffffff;
  content: '';
  display: block;
  font-size: 14px;
  line-height: 32px;
  opacity: 0;
  text-align: center;
  width: 100px;
}

.hamburger.is-closed:hover before {
  -webkit-transform: translate3d(-100px, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  display: block;
  opacity: 1;
}

.hamburger.is-closed:hover .hamb-top {
  -webkit-transition: all 0.35s ease-in-out;
  top: 0;
}

.hamburger.is-closed:hover .hamb-bottom {
  -webkit-transition: all 0.35s ease-in-out;
  bottom: 0;
}
/* is-closed 아래 3개 열리기전 버튼 색상*/
.hamburger.is-closed .hamb-top {
  -webkit-transition: all 0.35s ease-in-out;
  background-color: rgba(0, 0, 0, 0.6);
  top: 5px;
}

.hamburger.is-closed .hamb-middle {
  background-color: rgba(0, 0, 0, 0.6);
  margin-top: -2px;
  top: 50%;
}

.hamburger.is-closed .hamb-bottom {
  -webkit-transition: all 0.35s ease-in-out;
  background-color: rgba(0, 0, 0, 0.6);
  bottom: 5px;
}

.hamburger.is-closed .hamb-top, .hamburger.is-closed .hamb-middle, .hamburger.is-closed .hamb-bottom, .hamburger.is-open .hamb-top, .hamburger.is-open .hamb-middle, .hamburger.is-open .hamb-bottom {
  height: 4px;
  left: 0;
  position: absolute;
  width: 100%;
}

.hamburger.is-open .hamb-top {
  -webkit-transform: rotate(45deg);
  -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);
  background-color: whitesmoke;  /*X 자 왼쪽위에서 오른쪽 아래방향 대각선  색상 */
  margin-top: -2px;
  top: 50%;
}

.hamburger.is-open .hamb-middle {
  background-color: #ffffff;
  display: none;
}

.hamburger.is-open .hamb-bottom {
  -webkit-transform: rotate(-45deg);
  -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);
  background-color: whitesmoke;  /* X 자 오른쪽위에서 왼쪽 아래방향 대각선 색상 */
  margin-top: -2px;
  top: 50%;
}

.hamburger.is-open:before {
  -webkit-transform: translate3d(0, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  color: #ffffff;
  content: '';
  display: block;
  font-size: 14px;
  line-height: 32px;
  opacity: 0;
  text-align: center;
  width: 100px;
}

.hamburger.is-open:hover before {
  -webkit-transform: translate3d(-100px, 0, 0);
  -webkit-transition: all 0.35s ease-in-out;
  display: block;
  opacity: 1;
}

/*-------------------------------*/
/*          Dark Overlay         */
/*-------------------------------*/

.overlay {
  position: fixed;
  display: none;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.4);
  z-index: 1;
}

/* SOME DEMO STYLES - NOT REQUIRED */

body, html { background-color: whitesmoke; }

body h1, body h2, body h3, body h4 { color: rgba(0, 0, 0, 0.9); }

body p, body blockquote { color: rgba(255, 255, 255, 0.7); }

body a {
  color: rgba(255, 255, 255, 0.8);
  text-decoration: underline;
}

body a:hover { color: #ffffff; }
</style>
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
     
       if (id == "addr") {
            var isName = /^[가-힝]{2,}$/;

            if (!isName.test(oid) || oid == "") {
                oDiv.removeClass("has-success");
                oDiv.addClass("has-error");
                oMsg.css("display", "block");
                oMsg.html("정확히 입력해주세요");

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

<div id="wrapper">
  <div class="overlay"></div>
  
  <!-- Sidebar -->
  <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
      <li class="sidebar-brand"> <a href="../product/list.do"> FASHION MAKER </a> </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Outer <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Outer menu</li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=cardigan">가디건</a></li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=jacket">자켓</a></li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=coat">코트</a></li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=jumper">점퍼/야상</a></li>
        </ul>
      </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Top <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Top menu</li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=longT">긴팔</a></li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=shortT">반팔</a></li>
        </ul>
      </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Pants <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Pants menu</li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=longP">롱 팬츠</a></li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=shortP">숏 팬츠</a></li>
        </ul>
      </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Dress <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Dress menu</li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=slim">슬림</a></li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=loose">루즈</a></li>
        </ul>
      </li>

      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Bag <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Bag menu</li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=shoulder">숄더백</a></li>
          <li><a href="${pageContext.request.contextPath}/product/catelist.do?pcate=clutch">클러치백</a></li>
        </ul>
      </li>
      
      <c:choose>
        <c:when test="${not empty loginUser}">
        
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i>${loginUser.name}님<span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li class="dropdown-header">Point : ${user.point} P</li>
              <li><a href='${pageContext.request.contextPath}/cart/list.do?email=${loginUser.email}'>장바구니</a></li>
              <li><a data-toggle="modal" data-target="#squareDetailModal">개인정보 변경</a></li>
              <li><a href='${pageContext.request.contextPath}/purchase/listone.do?email=${loginUser.email}'>구매 목록</a></li>
              <li><a href="${pageContext.request.contextPath}/auth/logout.do">로그아웃</a></li>
            </ul>
          </li>
        
        </c:when>
        <c:otherwise>
		      <li> <a data-toggle="modal" data-target="#squareloginModal"><i class="fa fa-fw fa fa-power-off"></i> Sing In</a> </li>
		      <li> <a data-toggle="modal" data-target="#squarespaceModal"><i class="fa fa-fw fa fa-power-off"></i> Sign Up</a> </li>
        </c:otherwise>
      </c:choose>
    </ul>
  </nav>
  <!-- --------------------회원정보 수정 구간--------------------- -->
  
  <div class="modal fade" id="squareDetailModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
         
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span><span class="sr-only">Close</span>
               </button>
               <h3 class="modal-title" id="lineModalLabel">회원가입</h3>
            </div>
            
            <div class="modal-body">
              <section>
                <article>
                  <fieldset class="row div div-join">
                     
                    <form action='../users/update.do' method='post' enctype="multipart/form-data">
                      <div class="panel panel-default">
                           
                        <div class="panel-heading">
                          <label>필수 입력 사항</label>
                        </div>
                              
                        <div class="panel-body">
                          <div id="emailForm" class="form-group has-feedback">
                            <label for="email">이메일</label> 
                            <input type="text" class="form-control" id="email" name="email" maxlength="30" value="${loginUser.email}" readonly>
                            <div class="control-label" id="emailMsg" style="display: none;">양식에 맞게 입력해주세요.</div>
                          </div>
                                 
                          <hr>
                          <div id="playerNameForm" class="form-group has-feedback">
                            <label for="playerName">이름</label> 
                            <input type="text" class="form-control" id="playerName" name="name" maxlength="20" autofocus="true" value="${loginUser.name}">
                            <div class="control-label" id="playerNameMsg" style="display: none;">필수 정보입니다.</div>
                          </div>
                                 
                          <div id="addrForm" class="form-group has-feedback">
                            <label for="addr">주소</label>
                            <input type="text" class="form-control" id="addr" name="addr" maxlength="50" autofocus="true" value="${loginUser.addr}">
                            <div class="control-label" id="addrMsg" style="display: none;">필수 정보입니다.</div>
                          </div>
                                 
                          <div id="phoneForm" class="form-group has-feedback">
                            <label for="phone">휴대전화번호</label>
                            <input type="text" class="form-control" id="phone" name="tel" maxlength="13" value="${loginUser.tel}">
                            <div class="control-label" id="phoneMsg" style="display: none;">양식에 맞게 입력해주세요.</div>
                          </div>
                                 
                          <div class="div-center">
                           <button type="submit" id="joinBtn" class="button">변경</button>
                          </div>
                        </div>
                            
                      </div>
                    </form>
                      
                  </fieldset>
                </article>
              </section>
            </div>
         </div>
      </div>
   </div>
   <!-- --------------------/회원정보 수정 구간-------------------- -->
  <!-- --------------------회원가입 구간--------------------- -->
  
  <div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
         
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span><span class="sr-only">Close</span>
               </button>
               <h3 class="modal-title" id="lineModalLabel">회원가입</h3>
            </div>
            
            <div class="modal-body">
							<section>
								<article>
									<fieldset class="row div div-join">
									   
										<form action='../users/add.do' method='post' enctype="multipart/form-data">
											<div class="panel panel-default">
											     
												<div class="panel-heading">
												  <label>필수 입력 사항</label>
												</div>
												      
												<div class="panel-body">
													<div id="emailForm" class="form-group has-feedback">
														<label for="email">이메일</label> 
														<input type="text" class="form-control" id="email" name="email" maxlength="30"
														  placeholder="이메일을 입력해주세요" autofocus="true" onchange="check(this.id); nullCheck();">
														<div class="control-label" id="emailMsg" style="display: none;">양식에 맞게 입력해주세요.</div>
													</div>
													       
													<hr>
													<div id="passwordForm" class="form-group has-feedback">
														<label for="password">비밀번호</label> 
														<input type="password" class="form-control" id="password" name="password"
														 maxlength="20" placeholder="비밀번호를 입력하세요." onchange="check(this.id); nullCheck();">
														<div class="control-label" id="passwordMsg" style="display: none;">필수 정보입니다.</div>
													</div>
													       
													<div id="password2Form" class="form-group has-feedback">
														<label for="password2">비밀번호 재입력</label> 
														<input type="password" class="form-control" id="password2" name="password2" maxlength="20"
														  placeholder="비밀번호를 재입력하세요." onchange="check(this.id); nullCheck();">
														<div class="control-label" id="password2Msg" style="display: none;">필수 정보입니다.</div>
													</div>
													       
													<hr>
													<div id="playerNameForm" class="form-group has-feedback">
														<label for="playerName">이름</label> 
														<input type="text" class="form-control" id="playerName" name="name" maxlength="20"
														  autofocus="true" placeholder="이름을 입력하세요." onchange="check(this.id); nullCheck();">
														<div class="control-label" id="playerNameMsg" style="display: none;">필수 정보입니다.</div>
													</div>
													       
													<div id="addrForm" class="form-group has-feedback">
														<label for="addr">주소</label>
														<input type="text" class="form-control" id="addr" name="addr" maxlength="50"
														  autofocus="true" placeholder="주소를 입력해 주세요" onchange="check(this.id); nullCheck();">
														<div class="control-label" id="addrMsg" style="display: none;">필수 정보입니다.</div>
													</div>
													       
													<div id="phoneForm" class="form-group has-feedback">
														<label for="phone">휴대전화번호</label>
														<input type="text" class="form-control" id="phone" name="tel" maxlength="13"
														  placeholder="휴대전화번호를 입력해주세요 (예) 010-1234-5678" onchange="check(this.id); nullCheck();">
														<div class="control-label" id="phoneMsg" style="display: none;">양식에 맞게 입력해주세요.</div>
													</div>
													       
													<div class="div-center">
													 <button type="submit" id="joinBtn" class="button">가입</button>
													 <a type="button" class="button1" href="list.do">취소</a>
													</div>
												</div>
											      
											</div>
										</form>
									    
									</fieldset>
								</article>
							</section>
            </div>
         </div>
      </div>
   </div>
   <!-- --------------------/회원가입 구간-------------------- -->
   
   <!-- --------------------로그인 구간-------------------- -->
   <div class="modal fade" id="squareloginModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
         
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span><span class="sr-only">Close</span>
               </button>
               <h3 class="modal-title" id="lineModalLabel">로그인</h3>
            </div>
            
            <div class="modal-body">
              <section>
                <article>
                  <fieldset class="row div div-join">
                     
                    <form action='../auth/login.do' method='post' enctype="multipart/form-data">
                      <div class="panel panel-default">
                           
	                      <div class="panel-heading">
	                        <label>환영합니다~ 이메일과 패스워드를 입력해주세요!</label>
	                      </div>
	                            
	                      <div class="panel-body">
	                      
	                        <div id="emailForm" class="form-group has-feedback">
	                          <label for="email">이메일</label> 
	                          <input type=email class="form-control" id="email" name="email" value='${cookie.email.value}' maxlength="30" required="required"/>
	                        </div>
	                        
	                        <div id="passwordForm" class="form-group has-feedback">
                            <label for="password">비밀번호</label> 
                            <input type="password" class="form-control" id="password" name="password" maxlength="30" required="required"/>
                          </div>
                          
                          <%-- <div id="passwordForm" class="form-group has-feedback">
                            <label for="saveEmail">이메일 저장</label>
                            <input type="checkbox" name="saveEmail" ${(empty cookie.email)?"":"checked"}>
                          </div> --%>
                          
		                      <div class="div-center">
	                          <button type="submit" id="joinBtn" class="button">로그인</button>
	                        </div>
                        </div>
	                      
                      </div> 
                    </form>
                      
                  </fieldset>
                </article>
              </section>
            </div>
         </div>
      </div>
   </div>
   <!-- --------------------/로그인 구간-------------------- -->
   
  <!-- /#sidebar-wrapper --> 
  
  <!-- Page Content -->
  <div id="page-content-wrapper">
    <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas"> <span class="hamb-top"></span> <span class="hamb-middle"></span> <span class="hamb-bottom"></span> </button>

    <jsp:include page="/use/cart.jsp"/>
    
  </div>
  <!-- /#page-content-wrapper --> 
  
</div>

<!-- /#wrapper --> 
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<script>
$(document).ready(function () {
  var trigger = $('.hamburger'),
      overlay = $('.overlay'),
     isClosed = false;

    trigger.click(function () {
      hamburger_cross();      
    });

    function hamburger_cross() {

      if (isClosed == true) {          
        overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
        isClosed = false;
      } else {   
        overlay.show();
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
        isClosed = true;
      }
  }
  
  $('[data-toggle="offcanvas"]').click(function () {
        $('#wrapper').toggleClass('toggled');
  });  
});
</script>
</body>
</html>    