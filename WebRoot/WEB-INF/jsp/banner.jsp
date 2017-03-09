<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
    <!-- banner -->
	<div class="banner about-w3bnr">
		<!-- header -->
		<div class="header">
			<div class="w3ls-header"><!-- header-one --> 
				<div class="container">
					<div class="w3ls-header-left">
						<p>Free home delivery at your doorstep For Above $30</p>
					</div>
					<div class="w3ls-header-right">
						<ul> 
							<li class="head-dpdn">
								<i class="fa fa-phone" aria-hidden="true"></i> TEL: +01 222 33345 
							</li> 
							<!-- 用户已登录 -->
							<s:if test="#session.existCustomer!=null">
								<li class="head-dpdn">
									<a href="${pageContext.request.contextPath}/"><i class="fa fa-sign-in" aria-hidden="true"></i>
										欢迎你，
										<s:property value="#session.existCustomer.cname"/>
										！
									</a>
								</li> 
								<li class="head-dpdn">
									<a href="${pageContext.request.contextPath}/customer_logout.action"><i class="fa fa-sign-out" aria-hidden="true"></i>
										退出登录
									</a>
								</li> 
								
							</s:if>
							<!-- 用户未登录 -->
							<s:else>
								<li class="head-dpdn">
									<a href="${pageContext.request.contextPath}/customer_loginPage.action"><i class="fa fa-sign-in" aria-hidden="true"></i> 登录</a>
								</li> 
								<li class="head-dpdn">
									<a href="${pageContext.request.contextPath}/customer_signupPage"><i class="fa fa-user-plus" aria-hidden="true"></i> 注册</a>
								</li>
							</s:else>
							 
							<li class="head-dpdn">
								<a href="offers.html"><i class="fa fa-gift" aria-hidden="true"></i> Offers</a>
							</li> 
							<li class="head-dpdn">
								<a href="help.html"><i class="fa fa-question-circle" aria-hidden="true"></i> Help</a>
							</li>
						</ul>
					</div>
					<div class="clearfix"> </div> 
				</div>
			</div>
			<!-- //header-one -->    
			<!-- navigation -->
			<div class="navigation agiletop-nav">
				<div class="container">
					<nav class="navbar navbar-default">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header w3l_logo">
							<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>  
							<h1><a href="${pageContext.request.contextPath}/customer_index">美时订餐</a></h1>
						</div> 
						<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="${pageContext.request.contextPath}/customer_index">首页</a></li>	
								<!-- Mega Menu -->
								<li class="dropdown">
								
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">订餐<b class="caret"></b></a>
									<ul class="dropdown-menu multi-column columns-3">
										<div class="row">
										
											<s:iterator value="#session.tList" var="t">
												<div class="col-sm-4">
													<ul class="multi-column-dropdown">
														<h6><s:property value="#t.tname"/></h6>  
															<s:iterator>
															<li><a href="${pageContext.request.contextPath}/menu_page"></a></li> 
															</s:iterator>
													</ul>
												</div>
											</s:iterator>
										
											<div class="clearfix"></div>
										</div>
									</ul>
								</li>
								<li><a href="about.html">About</a></li> 
								<li class="w3pages"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pages <span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="icons.html">Web Icons</a></li>
										<li><a href="codes.html">Short Codes</a></li>     
									</ul>
								</li>  
								<li><a href="contact.html">Contact Us</a></li>
							</ul>
						</div>
						<div class="cart cart box_1"> 
							<form action="#" method="post" class="last"> 
								<input type="hidden" name="cmd" value="_cart" />
								<input type="hidden" name="display" value="1" />
								<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
							</form>   
						</div> 
					</nav>
				</div>
			</div>
			<!-- //navigation --> 
		</div>
		<!-- //header-end --> 
		<!-- banner-text -->
		<div class="banner-text">	
			<div class="container">
				<h2>美食相伴每刻 <br> <span>Best Chefs For you.</span></h2> 
			</div>
		</div>
	</div>
	<!-- //banner -->