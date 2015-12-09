<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<style>
body {
}

p {
  margin: 0 0 1.5em;
}
.archive {
  max-width: 400px;
  margin: 0 auto;
}

.entry {
  position: relative;
  overflow: hidden;
  margin: 30px 0;
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

.entry-title a:hover {
  color: #555;
}

.more-link {
  position: absolute;
  left: 0;
  bottom: 0;
  display: block;
  width: 100%;
  padding: 8px;
  background: #555;
  color: #FFF;
  text-align: center;
  text-transform: uppercase;
  text-decoration: none;
  font-weight: bold;
  box-shadow: 0 0 10px #000;
}

.more-link:hover {
  background: #5E5E5E;
}

.more-link:after {
  content: "\2193";
  margin-left: 8px;
  font-size: .8em;
}

.more-link.open:after {
  content: "\2191";
}
</style>


<div class="archive">
  <div id="content">

    <div class="post type-post status-publish format-standard hentry category-uncategorized entry">
      <%-- <h2 class="entry-title"><a href="#">a ${article.name}</a></h2> --%> 
      <div class="entry-content">
      <c:forEach var="article" items="${articles}">
        <table align="center" width="350px">
          <tr>
            <td rowspan="2" width="60px" height="60px">${article.photo}</td>
            <td>&nbsp;&nbsp;${article.name}</td>
          </tr>
          <tr>
            <td>&nbsp;&nbsp;${article.createdDate}</td>
          </tr>
          <tr>
            <td colspan="2" height="30px">attachphotofile</td>
          </tr>
          <tr>
            <td colspan="2">${article.content}</td>
          </tr>
        </table>
        </c:forEach> 
      </div><!-- end .entry-content -->
    </div><!-- end .entry -->
  </div>
</div><!-- end .archive -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function() {
  var closeHeight = '8em'; /* Default "closed" height */
  var moreText  = '더보기'; /* Default "Read More" text */
  var lessText  = '닫기'; /* Default "Read Less" text */
  var duration  = '1000'; /* Animation duration */
  var easing = 'linear'; /* Animation easing option */

  // Limit height of .entry-content div
  $('.page-template-page_blog-php #content .entry, .archive #content .entry').each(function() {
    
    // Set data attribute to record original height
    var current = $(this).children('.entry-content');
    current.data('fullHeight', current.height()).css('height', closeHeight);

    // Insert "Read More" link
    current.after('<a href="javascript:void(0);" class="more-link closed">' + moreText + '</a>');

  });
  
  // Link functinoality
  var openSlider = function() {
    link = $(this);
    var openHeight = link.prev('.entry-content').data('fullHeight') + 'px';
    link.prev('.entry-content').animate({'height': openHeight}, {duration: duration }, easing);
    link.text(lessText).addClass('open').removeClass('closed');
      link.unbind('click', openSlider);
    link.bind('click', closeSlider);
  }

  var closeSlider = function() {
    link = $(this);
      link.prev('.entry-content').animate({'height': closeHeight}, {duration: duration }, easing);
    link.text(moreText).addClass('closed').removeClass('open');
    link.unbind('click');
    link.bind('click', openSlider);
  }
  
    // Attach link click functionality
  $('.more-link').bind('click', openSlider);
  
});
</script>

