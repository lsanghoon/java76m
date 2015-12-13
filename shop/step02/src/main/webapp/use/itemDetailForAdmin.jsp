<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<link rel="stylesheet" type="text/css" href="../css/chartStyle.css" />
<table border="0" style="background-color: white;margin-left: auto; margin-right: auto;">
  <tr>
    <td rowspan="5" width="400px"><img name="cpphoto" src="../productfile/${product.pphoto}" width="400px" height="400px"></td>
    <td width="100px"></td>
    <td width="500px" height="50"></td>
  </tr>
  <tr>
    <td height="50"></td>
    <td>
      <h1>상품명: ${product.pname}</h1>
      <hr>
      <input type="hidden" name="no" value="${product.no}">
    </td>
  </tr>
  <tr>
    <td></td>
    <td height="80" style="font-size: 26px;">가격: <input type="text" name="cpcost" value="${product.pcost}" disabled="disabled" style="border:none;"></td>
  </tr>
  <tr>
    <td height="50"></td>
    <td style="font-size: 22px;">재고: <input type="text" name="cstock" value="${product.pstock}" style="width: 160px;border:none;" readonly/></td>
  </tr>
  <tr>
    <td></td>
    <td height="80"></td>
  </tr>
</table>

<hr>
  <p style="text-align: center; font-size: 30px;">
    <a data-toggle="modal" data-target="#squareProUpdateModal" class='button3' style="color: black; text-decoration: none;">변경</a>
    &nbsp; &nbsp; &nbsp; &nbsp;
    <a href="../product/delete.do?no=${product.no}" class='button3' style="color: black; text-decoration: none;">삭제</a>
  </p>
<hr>

<table style="background-color: white;margin-left: auto; margin-right: auto;">
<tr>
  <td><img src="../productfile/${product.fimage}"></td>
</tr>
<tr>
  <td><img src="../productfile/${product.simage}"></td>
</tr>
</table>



 <!-- --------------------상품 업데이트 구간-------------------- -->
   <div class="modal fade" id="squareProUpdateModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
         
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span><span class="sr-only">Close</span>
               </button>
               <h3 class="modal-title" id="lineModalLabel">상품 정보 변경</h3>
            </div>
            
            <div class="modal-body">
              <section>
                <article>
                  <fieldset class="row div div-join">
                     
                    <form action='../product/update.do' method='post' enctype="multipart/form-data">
                      <div class="panel panel-default">
                           
                        <div class="panel-heading">
                          <label>상품을 수정해주세요~</label>
                        </div>
                              
                        <div class="panel-body">
                        
                          <div id="pcateForm" class="form-group has-feedback">
                            <label for="pcate">카테고리</label> 
                            <select name="pcate" style="text-align: center;">
                              <option>선택하세요</option>
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
                            <input type="hidden" name="no" value="${product.no}">
                            <input type="text" class="form-control" value="${product.pname}" id="pname" name="pname" maxlength="30" required="required"/>
                          </div>
                          
                          <div id="pcostForm" class="form-group has-feedback">
                            <label for="pcost">가격</label> 
                            <input type="text" class="form-control" value="${product.pcost}" id="pcost" name="pcost" maxlength="30" required="required"/>
                          </div>
                          
                          <div id="pstockForm" class="form-group has-feedback">
                            <label for="pstock">재고</label> 
                            <input type="text" class="form-control" value="${product.pstock}" id="pstock" name="pstock" min="1" max="999" required="required"/>
                          </div>
                          
                          <div id="pphotoForm" class="form-group has-feedback">
                            <label for="pphoto">메인이미지</label> 
                            <input type="file" class="form-control" id="pphoto" name="pphotofile"/>
                            <input type="hidden" name="pphoto" value="${product.pphoto}"/>
                          </div>
                          
                          <div id="fimageForm" class="form-group has-feedback">
                            <label for="fimage">이미지1</label> 
                            <input type="file" class="form-control" id="fimage" name="fimagefile"/>
                            <input type="hidden" name="fimage" value="${product.fimage}"/>
                          </div>
                          
                          <div id="simageForm" class="form-group has-feedback">
                            <label for="simage">이미지2</label> 
                            <input type="file" class="form-control" id="simage" name="simagefile"/>
                            <input type="hidden" name="simage" value="${product.simage}"/>
                          </div>
                          
                          <div class="div-center">
                            <button type="submit" id="joinBtn" class="btn btn-lg btn-primary btn-join">변경</button>
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