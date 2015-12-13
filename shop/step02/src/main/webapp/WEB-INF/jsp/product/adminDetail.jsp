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
      <li class="sidebar-brand"> <a href="../auth/list.do"> FASHION MAKER </a> </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Outer <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Outer menu</li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=cardigan">가디건</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=jacket">자켓</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=coat">코트</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=jumper">점퍼/야상</a></li>
        </ul>
      </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Top <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Top menu</li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=longT">긴팔</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=shortT">반팔</a></li>
        </ul>
      </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Pants <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Pants menu</li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=longP">롱 팬츠</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=shortP">숏 팬츠</a></li>
        </ul>
      </li>
      
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Dress <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Dress menu</li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=slim">슬림</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=loose">루즈</a></li>
        </ul>
      </li>

      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i> Bag <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Bag menu</li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=shoulder">숄더백</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/catelist.do?pcate=clutch">클러치백</a></li>
        </ul>
      </li>
        
      <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-male"></i>${loginUser.name}님<span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">물품 관리</li>
          <li><a href="${pageContext.request.contextPath}/users/list.do">회원목록</a></li>
          <li><a data-toggle="modal" data-target="#squareProAddModal">상품 추가</a></li>
          <li><a href="${pageContext.request.contextPath}/purchase/list.do">판매 리스트</a></li>
          <li><a href="${pageContext.request.contextPath}/auth/logout.do">로그아웃</a></li>
        </ul>
      </li>
        
    </ul>
  </nav>
  
  <!-- --------------------상품추가 구간-------------------- -->
   <div class="modal fade" id="squareProAddModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
         
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span><span class="sr-only">Close</span>
               </button>
               <h3 class="modal-title" id="lineModalLabel">상품추가</h3>
            </div>
            
            <div class="modal-body">
              <section>
                <article>
                  <fieldset class="row div div-join">
                     
                    <form action='../product/add.do' method='post' enctype="multipart/form-data">
                      <div class="panel panel-default">
                           
                        <div class="panel-heading">
                          <label>상품을 추가해주세요~</label>
                        </div>
                              
                        <div class="panel-body">
                        
                          <div id="pcateForm" class="form-group has-feedback">
                            <label for="pcate">카테고리</label> 
                            <select name="pcate" style="text-align: center;">
                              <option value=" ">선택하세요</option>
                              <option value=" ">--Outer--</option>
															<option value='cardigan'>가디건</option>
															<option value='jacket'>자켓</option>
															<option value='coat'>코트</option>
															<option value='jumper'>점퍼/야상</option>
															
                              <option value=" ">---Top---</option>
															<option value='longT'>긴팔</option>
															<option value='shortT'>반팔</option>

                              <option value=" ">--Dress--</option>
															<option value='slim'>슬림</option>
															<option value='loose'>루즈</option>

                              <option value=" ">--Pants--</option>
															<option value='longP'>롱팬츠</option>
															<option value='shortP'>숏팬츠</option>

                              <option value=" ">---Bag---</option>
															<option value='shoulder'>숄더백</option>
															<option value='clutch'>클러치백</option>
                            </select>
                          </div>
                          
                          <div id="pnameForm" class="form-group has-feedback">
                            <label for="pname">상품명</label> 
                            <input type="text" class="form-control" id="pname" name="pname" maxlength="30" required="required"/>
                          </div>
                          
                          <div id="pcostForm" class="form-group has-feedback">
                            <label for="pcost">가격</label> 
                            <input type="text" class="form-control" id="pcost" name="pcost" maxlength="30" required="required"/>
                          </div>
                          
                          <div id="pstockForm" class="form-group has-feedback">
                            <label for="pstock">재고</label> 
                            <input type="text" class="form-control" id="pstock" name="pstock" maxlength="30" required="required"/>
                          </div>
                          
                          <div id="pphotoForm" class="form-group has-feedback">
                            <label for="pphoto">메인이미지</label> 
                            <input type="file" class="form-control" id="pphoto" name="pphotofile"/>
                          </div>
                          
                          <div id="fimageForm" class="form-group has-feedback">
                            <label for="fimage">이미지1</label> 
                            <input type="file" class="form-control" id="fimage" name="fimagefile"/>
                          </div>
                          
                          <div id="simageForm" class="form-group has-feedback">
                            <label for="simage">이미지2</label> 
                            <input type="file" class="form-control" id="simage" name="simagefile"/>
                          </div>
                          
                          <div class="div-center">
                            <button type="submit" id="joinBtn" class="btn btn-lg btn-primary btn-join">등록</button>
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
   <!-- --------------------/상품추가 구간-------------------- -->
  
  <!-- /#sidebar-wrapper --> 
  
  <!-- Page Content -->
  <div id="page-content-wrapper">
    <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas"> <span class="hamb-top"></span> <span class="hamb-middle"></span> <span class="hamb-bottom"></span> </button>
    
    <jsp:include page="/use/itemDetailForAdmin.jsp"/>
    
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