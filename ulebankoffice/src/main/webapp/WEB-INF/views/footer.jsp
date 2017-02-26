<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include.jsp"%>

<footer id="contact2" class="footer-4 ">
	<div class="footer-widget mt-10">
		<div class="container">
			<div class="row">
				<div class="pr-0 col-lg-4 col-md-3 col-sm-3">
					<p class="text-white mt-15">
						&copy;Copyright <span id="copyright"> <script>
							document.getElementById('copyright').appendChild(
									document.createTextNode(new Date()
											.getFullYear()))
						</script></span> <a href="./"> ULe-Bank </a>
						<spring:message code="label.siterights" />
					</p>
				</div>
				<div class="pl-0 pr-0 col-lg-2 col-md-2 col-sm-2">
					<p class="text-white mt-15">
						<span id="copyright"></span> <a href="cookies"><spring:message
								code="label.cookiespolicy" /></a>
					</p>
				</div>
				<div class="pl-0 col-lg-1 col-md-1 col-sm-1">
					<p class="text-white mt-15">
						<span id="copyright"></span> <a href="./#contact"><spring:message
								code="label.contact" /></a>
					</p>
				</div>
			</div>
			<div class="row">
					<a href="https://www.unileon.es"><img id="logo_img"
						src="resources/template/images/sponsors/logo-ule.png" alt="logo"></a>
			</div>
		</div>
	</div>
</footer>