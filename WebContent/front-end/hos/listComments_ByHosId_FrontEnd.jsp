<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hosComm.model.*"  %>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="listComments_ByHosId" scope="request" type="java.util.Set" />
<jsp:useBean id="HosSvc" scope="page" class="com.hos.model.HosService" />
<jsp:useBean id="memSvc" scope="page" class="com.mem_dream.model.MemService" />



<html>
<head>
	<style>
		.grpMessage {
		    background-color: lightblue;
		    margin: 5px 0px 5px 20px;
		    border-radius: 5px;
		    padding: 5px;
		}

		.messageAvatar {
		    width: 30px;
		    height: 30px;
		    border-radius: 50%;
		    margin-left: 15px;
		}
    </style>

	<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
	
</head>
<body bgcolor='white'>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>
				
	<div class="container" style="width: 600px;padding:0px">
		<div class="row">
			<div class="col-xs-12 col-sm-12 ">
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do" name="form1">
                <div class="input-group text msgBtnDiv">
                    <textarea style="height:2em" rows="1" cols="20" class=" form-control" id="text" 
                    placeholder="leave a message..." maxlength="300" name="hosComment_content"></textarea>
                    <input type="hidden" name="hos_Id" value="${hos_Id}">
                    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
                    <input type="hidden" name="action"value="insert">
                    <span class="input-group-btn">
						<button class="btn btn-info " type="submit">留言</button>
					</span>
                 </div>
                 </FORM>
             </div>
       </div>
	   
	<c:forEach var="hosCommVO" items="${listComments_ByHosId}" varStatus="s">
		  <div class="row">
             <div class="col-xs-12 col-sm-12">
                <img src="${memSvc.getOneMem(hosCommVO.hosComment_MemId).mem_profile}" class="messageAvatar">${memSvc.getOneMem(hosCommVO.hosComment_MemId).mem_name}:
             </div>
          </div>
          <div class="row">
            <div class="col-xs-12 col-sm-7 grpMessage">
	          	<c:if test="${hosComment_content!=''&&(hosCommVO.hosComment_Id!=param.hosComment_Id)}" var="showComment">
					<div >${hosCommVO.hosComment_content}</div>
				</c:if>
				
				<c:if test="${!showComment}">
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do" name="confirmUpdateComment${s.index}">
						<textarea style="height:2em" rows="1" cols="50" 
						id="text"  maxlength="300" name="hosComment_content" placeholder="change your comment...">${hosCommVO.hosComment_content}</textarea>
						<input type="hidden" name="forUpdateHosComment_Id" value="${hosCommVO.hosComment_Id}">
				  		<input type="hidden" name="hosComment_HosId" value="${hosCommVO.hosComment_HosId}">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="action" value="confirmUpdateComment">
					</FORM>
				</c:if>

				
			</div>
			
			<div class="col-xs-8 col-sm-2" style="padding:0px">
			    	<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" 
	            	value="${hosCommVO.hosComment_SendTime}"/>
			</div>	
			<div class="col-xs-4 col-sm-1" style="padding:0px">
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do" style="margin:0px">
				    <button type="submit" class="btn btn-danger btn-xs">刪除</button>
				    <input type="hidden" name="hosComment_Id" value="${hosCommVO.hosComment_Id}">
				    <input type="hidden" name="hosComment_HosId" value="${hosCommVO.hosComment_HosId}">
				    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
				    <input type="hidden" name="action" value="delete">
			    </FORM>

				<c:if test="${showComment}">
					<button onclick="changeComment${s.index}()" class="btn btn-warning btn-xs">修改留言</button>
				</c:if>
			
				<c:if test="${!showComment}">
					<button onclick="confirmChangeComment${s.index}()" class="btn btn-warning btn-xs">確認修改留言</button>
				</c:if>
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do" 
			name="updateComment${s.index}"  style="margin:0px">
			    <input type="hidden" name="hosComment_Id" value="${hosCommVO.hosComment_Id}">
			    <input type="hidden" name="hosComment_HosId" value="${hosCommVO.hosComment_HosId}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action" value="updateComment">
			</FORM>
			</div>
			
			
			
         </div>
            
		
	
			<script>
		function changeComment${s.index}(){
			$("form[name='updateComment"+${s.index}+"']").submit();
		}
	
		
 		function confirmChangeComment${s.index}(){
			$("form[name='confirmUpdateComment"+${s.index}+"']").submit();
		}
		
			</script>
		</c:forEach>
	</div>
</table>


</body>

<script>
var observe;

function textAreaStretch() {
    if (window.attachEvent) {
        observe = function(element, event, handler) {
            element.attachEvent('on' + event, handler);
        };
    } else {
        observe = function(element, event, handler) {
            element.addEventListener(event, handler, false);
        };
    }

    var text = document.getElementById('text');

    function resize() {
        text.style.height = 'auto';
        text.style.height = text.scrollHeight + 'px';
    }
    /* 0-timeout to get the already changed text */
    function delayedResize() {
        window.setTimeout(resize, 0);
    }

    observe(text, 'change', resize);
    observe(text, 'cut', delayedResize);
    observe(text, 'paste', delayedResize);
    observe(text, 'drop', delayedResize);
    observe(text, 'keydown', delayedResize);

    text.focus();
    text.select();
    resize();
}

window.onload = textAreaStretch;
</script>
	

</html>
