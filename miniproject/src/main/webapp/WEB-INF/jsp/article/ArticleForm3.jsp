<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>게시물 등록</title>

<style>
body {
  background: #2b2f3a;
}

.form {
  z-index: 15;
  position: relative;
  background: #FFFFFF;
  width: 400px;
  border-radius: 4px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
  margin: 35px auto 10px;
  overflow: hidden;
}
.form-group {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex-wrap: wrap;
      -ms-flex-wrap: wrap;
          flex-wrap: wrap;
  -webkit-box-pack: justify;
  -webkit-justify-content: space-between;
      -ms-flex-pack: justify;
          justify-content: space-between;
  margin: 0 0 20px;
}
.form-group:last-child {
  margin: 0;
}
.form-group label {
  display: block;
  margin: 0 0 10px;
  color: rgba(0, 0, 0, 0.6);
  font-size: 16px;
  font-weight: 500;
  line-height: 1;
  text-transform: uppercase;
  letter-spacing: .2em;
}
.form-group textarea {
  resize:none;
  font-family: inherit;
  font-size: 15px;
  font-weight: 500;
}

.form-group input {
  font-family: inherit;
  text-transform: lowercase;
  box-shadow: 0 0 0px #000000
  
}
.form-group button {
  outline: none;
  background: #2b2f3a;
  width: 100%;
  border: 0;
  border-radius: 4px;
  padding: 12px 20px;
  color: #FFFFFF;
  font-family: inherit;
  font-size: 20px;
  font-weight: 500;
  line-height: inherit;
  text-transform: uppercase;
  cursor: pointer;
}


.archive {
  max-width: 500px;
  margin: 0 auto;
}

.entry {
  position: relative;
  overflow: hidden;
  margin: 100px 0;
  padding: 20px 20px 4em 20px;
  background: #FFF;
  font-family: "Open Sans", sans-serif;
  box-shadow: 0 0 15px #999;
}

.entry-title,
.entry-title a {
  margin-top: 0;
  font-family: Oswald, sans-serif;
  color: #333;
  text-decoration: none;
}

</style>
</head>
<body>

<div class="archive">
  <div id="content">

    <div class="post type-post status-publish format-standard hentry category-uncategorized entry">
      <h2 class="entry-title">게시물 등록</h2> 
      <div class="entry-content">
        <form action="add.do" method="post" enctype="multipart/form-data">
      
        <div class="form">
          <div class="form-group">
          <textarea name="content" cols='70' rows='20'></textarea>
          </div>
        </div>
        
        <div class="form">
          <div class="form-group">
          <input type="file" id="photo" name="photo"/><br>
          </div>
        </div>
        
        <div class="form">
	        <div class="form-group">
	          <button type="submit">등록</button>
	        </div>
			  </div>
			  
	      </form>
      </div><!-- end .entry-content -->
    </div><!-- end .entry -->
  </div>
</div><!-- end .archive -->


</body>
</html>




