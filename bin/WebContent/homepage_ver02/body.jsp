<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="row" style="height: 50%;">
		<div class="col-md-12" id="AM_nav" >
			<%@include file="/homepage_ver02/nav.jsp" %>	
		</div>
	</div>
	<div class="row" style="box-shadow: 3px 3px 3px 5px #cccccc;height: 70%;">
		<div class="col-md-4" id="AM_aside">
			<div id="AM_login">
				<table border="0" align="center" cellspacing="0" id="tableLogin"
					class="empTable">
					<tr>
						<td colspan="2" align="center">
							<div class="form-group">
								<input type="email" name="memId" id="memId" placeholder="Email"
									class="form-control" />
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<div class="form-group">
								<input type="password" name="password" placeholder="Password"
									class="form-control" />
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<div class="form-group">
								<button class="btn btn-primary btn-block" type="submit">登入
								</button>
							</div>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="#0">忘記密碼了嗎?</a></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a id="JoinMembership"
							href="#0">加入會員</a></td>
					</tr>

				</table>
			</div>
		</div>
		<div class="col-md-8" data-aos="fade-up" id="AM_section">
			<div id="AM_bookmark" class="btn-group-vertical"
				style="z-index: 1; box-shadow: 2px 5px 5px #888889; opacity: 1;
				  position: absolute;
				  top: 0px;
				  left: 0;
			">
				<button class="btn btn-default" type="button" style="padding: 5px;">會員中心
				</button>
				<button class="btn btn-default" type="button">朋友</button>
				<button class="btn btn-default" type="button">地圖資訊</button>
				<button class="btn btn-default" type="button">參加的活動</button>
				<button class="btn btn-default" type="button">店家管理</button>
			</div>
			<div class="btn-group btn-group-sm" role="group" id="AM_Map_Button"
				style="padding-top: 10px; padding-right: 30px; 
				position: absolute; 
				top:0px; right: 0;
				z-index: 1;
			">
				<a class="btn btn-default action-button" role="button" href="#"
					style="">動物圖鑑 </a><a class="btn btn-default action-button"
					role="button" href="#">發文 </a><a
					class="btn btn-default action-button" role="button" href="#">商城
				</a> <a class="btn btn-default action-button" role="button" href="#">討論版
				</a>
			</div>
			<div id="AM_google_Map" >
<!-- 				<iframe> -->
					<%@include file="/homepage_ver02/google_Map.jsp" %>
<!-- 				</iframe> -->
			</div>				
		</div>
	
	</div>
	<div class="row">
		<div class="col-md-12" id="AM_footer"
			style="padding: 0; ">
			<%@include file="/homepage_ver02/footer.jsp" %>			
		</div>
		<div class="col-md-12"></div>
	</div>



