<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<header id="header" class="header-4">

	<!--=================================
 mega menu -->

	<div class="menu">
		<!-- menu start -->
		<nav id="menu-1" class="mega-menu">
			<!-- menu list items container -->
			<section class="menu-list-items">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<!-- menu logo -->
							<ul class="menu-logo">
								<li><a href="./"><img id="logo_img"
										src="resources/template/images/logo.png" alt="logo"> </a></li>
							</ul>
							<!-- menu links -->
							<ul class="menu-links">
								<!-- active class -->
								<li class="page-scroll"><a href="./"> <spring:message
											code="label.sitehome" /></a></li>
								<li class="page-scroll"><a href="#services"><spring:message
											code="label.siteservices" /><i
										class="fa fa-angle-down fa-indicator"></i></a> <!-- drop down full width -->
									<div class="drop-down menu-bg grid-col-2">
										<!--grid row-->
										<div class="grid-row">
											<!--grid column 3-->
											
												<ul>
													<li><a href="/apr"><spring:message
																code="label.siteservice1" /></a></li>
													<li><a href="/leasing"><spring:message
																code="label.siteservice2" /></a></li>
													<li><a href="/offersconsulting"><spring:message
																code="label.siteservice3" /></a></li>
													<li><a href="/loans"><spring:message
																code="label.siteservice4" /></a></li>
													<li><a href="/discounts"><spring:message
																code="label.siteservice5" /></a></li>
													<li><a href="/reversemortgage"><spring:message
																code="label.siteservice6" /></a></li>
													<li><a href="/creditaccount"><spring:message
																code="label.siteservice7" /></a></li>
												</ul>
											
										</div>
									</div></li>
								<li><a href=""> <spring:message
											code="label.sitelanguage" /> <i
										class="fa fa-angle-down fa-indicator"></i></a> <!-- drop down multilevel  -->
									<ul class="drop-down-multilevel right-menu">
										<li><a href="?language=en"><spring:message
													code="label.english" /></a></li>
										<li><a href="?language=es"><spring:message
													code="label.spanish" /></a></li>
									</ul></li>
								<li>
									<div class="search-3">
										<a class="search-btn not_click" href="javascript:void(0);">Search
											Button</a>
										<div class="search-3-box not-click">
											<input type="text" class="not-click" placeholder="Search"
												value="" name="s"> <i class="fa fa-search"></i>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</section>
		</nav>
		<!-- menu end -->
	</div>
</header>

<!--=================================
 header -->