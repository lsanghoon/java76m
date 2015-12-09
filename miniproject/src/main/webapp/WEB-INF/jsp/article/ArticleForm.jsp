<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>게시물 등록</title>
  </head>
<body>

      <h2>게시물 등록</h2> 
        <form action="add.do" method="post" enctype="multipart/form-data">
      
          <textarea name="content" cols='70' rows='20'></textarea>
        
          <input type="file" id="photo" name="photo"/><br>
        
	          <button type="submit">등록</button>
			  
	      </form>


</body>
</html>




