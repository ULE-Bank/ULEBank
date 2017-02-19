<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="HTML5 Template" />
<meta name="description" content="The Corps — Multi-Purpose HTML Template" />
<meta name="author" content="potenzaglobalsolutions.com" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<title><spring:message code="label.sitetitle"/></title>

<!-- Favicon -->
<link rel="shortcut icon" href="resources/template/images/favicon.ico" />

<!-- bootstrap -->
<link href="resources/template/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<!-- plugins -->
<link href="resources/template/css/plugins-css.css" rel="stylesheet" type="text/css" />

<!-- mega menu -->
<link href="resources/template/css/mega-menu/mega_menu.css" rel="stylesheet" type="text/css" />

 <!-- default -->
<link href="resources/template/css/default.css" rel="stylesheet" type="text/css" />

<!-- main style -->
<link href="resources/template/css/style.css" rel="stylesheet" type="text/css" />

<!-- responsive -->
<link href="resources/template/css/responsive.css" rel="stylesheet" type="text/css" />

<!-- custom style -->
<link href="resources/template/css/custom.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div class="page-wrapper over-inherit">

<!--=================================
 preloader -->
 
<div id="preloader">
  <div class="clear-loading loading-effect"> <span></span> </div>
</div>

<!--=================================
 preloader -->
 
 
<!--=================================
 header -->

<header id="header" class="header-4">
   <div id="menu-toggle">
      <div id="menu-icon">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
       </div>
      </div>
   <div id="menu">
    <div class="menu-side-top">
		<%--     <spring:message code=""/> --%>
         <h3 class="text-white">ULe-Bank</h3>
          <a href="#"><spring:message code="label.sitehome"/></a>
          <a href="#"><spring:message code="label.siteservices"/></a>
          <a href="#"><spring:message code="label.siteabout"/></a>
          <a href="#"><spring:message code="label.sitecontact"/></a>
         </div>
         <div class="login-side mt-40 text-left">
          <h3 class="text-white"><spring:message code="lable.sitelogin"/></h3>
           <form>  
             <div class="form-group">     
              <label><spring:message code="label.siteloginusername"/></label>
               <input type="text" name="username" placeholder="Email Address" />
                </div>
                <div class="form-group">
                 <label><spring:message code="label.siteloginpassword"/></label>
                <input type="password" name="password" placeholder="Password" />      
               </div>
               <div class="remember-checkbox">
                 <input type="checkbox" name="one" id="one" />
               <label class="remember" for="one"><spring:message code="label.siteloginrememberme"/></label>
               </div>
               <div class="clearfix">
               <a href="#" class="button button-white mt-20">
                  <span><spring:message code="lable.sitelogin"/></span>
                </a>
               <a class="forgot" href="#"><spring:message code="label.siteloginforgotpassword"/></a> 
              </div>
           <p class="register text-white mt-20"><spring:message code="lable.sitedonthaveaccount"/>  <a href="#"> <spring:message code="label.siteregisternow"/></a></p> 
         </form>
      </div>
  </div>
 
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
            <li>
                <a href="home-1-default.html"><img id="logo_img" src="resources/template/images/logo.png" alt="logo"> </a>
            </li>
        </ul>
        <!-- menu links -->
        <ul class="menu-links">
            <!-- active class -->
            <li class="active"><a href="javascript:void(0)"> <spring:message code="label.sitehome"/> <i class="fa fa-angle-down fa-indicator"></i></a>
                <div class="drop-down grid-col-8 offset-4">
                <!--grid row-->
                 <div class="grid-row">
                   <!--grid column 3-->
                    <div class="grid-col-4">
                     <ul>
                        <li><a href="home-1-default.html">Home 1 - Default <span class="label label-danger ml-10">Hot</span></a></li>
                        <li><a href="home-2-rain.html">Home 2 - Rain</a></li> 
                        <li><a href="home-3-corporate.html">Home 3 - Corporate</a></li>
                        <li class="active"><a href="home-4-corporate.html">Home 4 - Corporate</a></li>
                        <li><a href="home-5-creative.html">Home 5 - Creative</a></li>
                     </ul>
                    </div>
                    <div class="grid-col-4">
                     <ul>
                        <li><a href="home-6-business.html">Home 6 - Business <span class="label label-info ml-10">New</span> </a></li>
                        <li><a href="home-7-classic.html">Home 7 - Classic <span class="label label-primary ml-10">New</span></a></li> 
                        <li><a href="home-8-agency.html">Home 8 - Agency <span class="label label-success ml-10">New</span></a></li>
                        <li><a href="home-9-personal.html">Home 9 - Personal <span class="label label-warning ml-10">New</span></a></li>
                        <li><a href="home-10-parallax.html">Home 10 - Parallax <span class="label label-default ml-10">New</span></a></li>
                     </ul>
                    </div>
                    <div class="grid-col-4">
                     <ul>
                        <li><a target="_blank" href="http://themes.potenzaglobal.net/thecorps/one-page/one-page-1-default/index.html">One page 1 - Default </a></li>
                        <li><a target="_blank" href="http://themes.potenzaglobal.net/thecorps/one-page/one-page-2-rain/index.html">One page 2 - Rain </a></li>
                        <li><a target="_blank" href="http://themes.potenzaglobal.net/thecorps/one-page/one-page-3-corporate/index.html">One page 3 - Corporate </a></li>
                        <li><a target="_blank" href="http://themes.potenzaglobal.net/thecorps/one-page/one-page-4-corporate/index.html">One page 4 - Corporate </a></li>
                        <li><a target="_blank" href="http://themes.potenzaglobal.net/thecorps/one-page/one-page-5-creative/index.html">One page 5 - Creative </a></li>
                     </ul>
                    </div>
                   </div>
                  </div>
              </li>
            <li><a href="#services"><spring:message code="label.siteservices"/><i class="fa fa-angle-down fa-indicator"></i></a>
                <!-- drop down full width -->
                <div class="drop-down menu-bg grid-col-12">
                    <!--grid row-->
                    <div class="grid-row">
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="/apr"><spring:message code="label.siteservice1"/></a></li>
                              <li><a href="/leasing"><spring:message code="label.siteservice2"/></a></li>
                              <li><a href="/offersconsulting"><spring:message code="label.siteservice3"/></a></li>
                              <li><a href="/loans"><spring:message code="label.siteservice4"/></a></li>
                              <li><a href="/discounts"><spring:message code="label.siteservice5"/></a></li>
                              <li><a href="/reversemortgage"><spring:message code="label.siteservice6"/></a></li>
                              <li><a href="/creditaccount"><spring:message code="label.siteservice7"/></a></li>
                            </ul>
                        </div>
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="team-single.html">team single </a></li>
                              <li><a href="contact-1.html">contact 1 </a></li>
                              <li><a href="contact-2.html">contact 2 </a></li>
                              <li><a href="contact-3.html">contact 3 </a></li>
                              <li><a href="faqs-1.html">faqs 1 </a></li>
                              <li><a href="faqs-2.html">faqs 2 </a></li>
                              <li><a href="our-clients-1.html">our clients 1 </a></li>
                              <li><a href="our-clients-2.html">our clients 2 </a></li>
                              <li><a href="careers.html">careers </a></li>
                            </ul>
                        </div>
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="maintenance-1.html">maintenance 1 </a></li>
                              <li><a href="maintenance-2.html">maintenance 2 </a></li>
                              <li><a href="login-1.html">login 1 </a></li>
                              <li><a href="login-2.html">login 2 </a></li>
                              <li><a href="register-1.html">register 1 </a></li>
                              <li><a href="register-2.html">register 2 </a></li>
                              <li><a href="error-404-1.html">error 404 1 </a></li>
                              <li><a href="error-404-2.html">error 404 2 </a></li>
                              <li><a href="coming-soon-1.html">coming soon 1 </a></li>
                            </ul>
                        </div>
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="coming-soon-2.html">coming soon 2 </a></li>
                              <li><a href="page-left-sidebar.html">page left sidebar </a></li>
                              <li><a href="page-right-sidebar.html">page right sidebar </a></li>
                              <li><a href="page-two-sidebar.html">page two sidebar </a></li>
                              <li><a href="sitemap.html">sitemap </a></li>
                              <li><a href="terms-and-conditions.html">terms and conditions </a></li>
                              <li><a href="privacy-policy.html">privacy policy </a></li>
                            </ul>
                        </div>
                        
                    </div>
                </div>
            </li>
            <li><a href="javascript:void(0)">blog <i class="fa fa-angle-down fa-indicator"></i></a>
                <!-- drop down multilevel  -->
                <ul class="drop-down-multilevel">
                    <li><a href="javascript:void(0)">blog classic <i class="fa fa-angle-right fa-indicator"></i> </a>

                        <!-- drop down second level -->
                        <ul class="drop-down-multilevel">
                           <li><a href="blog-classic-left-sidebar.html">left sidebar</a></li>
                           <li><a href="blog-classic-right-sidebar.html">right sidebar</a></li>
                           <li><a href="blog-classic-fullwidth.html">fullwidth</a></li>
                        </ul>
                    </li>
                    <li><a href="javascript:void(0)">grid <i class="fa fa-angle-right fa-indicator"></i> </a>
                        <!-- drop down second level -->
                        <ul class="drop-down-multilevel">
                            <li><a href="blog-grid-2-column.html"> 2 column </a> </li>
                            <li><a href="blog-grid-3-column.html"> 3 column </a> </li>
                            <li><a href="blog-grid-2-column-left-sidebar.html">left sidebar</a></li>
                            <li><a href="blog-grid-2-column-right-sidebar.html">right sidebar</a></li>
                        </ul> 
                    </li>
                    <li><a href="javascript:void(0)">Masonry  <i class="fa fa-angle-right fa-indicator"></i> </a>
                      <!-- drop down second level -->
                        <ul class="drop-down-multilevel">
                            <li><a href="blog-masonry-2-columns.html"> 2 column </a> </li>
                            <li><a href="blog-masonry-3-columns.html"> 3 column </a> </li>
                            <li><a href="blog-masonry-2-columns-left-sidebar.html">left sidebar</a></li>
                           <li><a href="blog-masonry-2-columns-right-sidebar.html">right sidebar</a></li>
                        </ul> 
                    </li>
                    <li><a href="#">timeline  <i class="fa fa-angle-right fa-indicator"></i></a>
                        <!-- drop down second level -->
                        <ul class="drop-down-multilevel">
                          <li><a href="blog-timeline.html">fullwidth</a></li>
                          <li><a href="blog-timeline-left-sidebar.html">left sidebar</a></li>
                          <li><a href="blog-timeline-right-sidebar.html">right sidebar</a></li>
                        </ul> 
                    </li>
                    <li><a href="#">single post  <i class="fa fa-angle-right fa-indicator"></i></a>
                        <!-- drop down second level -->
                        <ul class="drop-down-multilevel">
                            <li><a href="blog-single-image-post.html"> blog image post </a> </li>
                            <li><a href="blog-single-video-post.html"> blog video post </a> </li>
                            <li><a href="blog-single-youtube-post.html"> blog youtube post </a> </li>
                            <li><a href="blog-single-vimeo-post.html"> blog vimeo post </a> </li>
                            <li><a href="blog-single-audio-post.html"> blog audio post  </a> </li>
                        </ul> 
                    </li>
                </ul>
            </li>
            <li><a href="javascript:void(0)">Portfolio<i class="fa fa-angle-down fa-indicator"></i></a>
                <!-- drop down multilevel  -->
                <ul class="drop-down-multilevel left-side">
                    
                    <li><a href="#">portfolio classic <i class="fa fa-angle-left fa-indicator"></i></a>
                      <!-- drop down second level -->
                        <ul class="drop-down-multilevel left-side">
                            <li><a href="javascript:void(0)"> 1 column  <i class="fa fa-angle-left fa-indicator"></i></a>
                                <!-- drop down third level -->
                                <ul class="drop-down-multilevel left-side">
                                    <li><a href="portfolio-classic-1-column-default.html">default</a></li>
                                    <li><a href="portfolio-classic-1-columns-left-sidebar.html">left sidebar</a></li>
                                    <li><a href="portfolio-classic-1-columns-right-sidebar.html">right sidebar</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)"> 2 column  <i class="fa fa-angle-left fa-indicator"></i></a>
                                <!-- drop down third level -->
                                <ul class="drop-down-multilevel left-side">
                                    <li><a href="portfolio-classic-2-columns-left-sidebar.html">left sidebar</a></li>
                                    <li><a href="portfolio-classic-2-columns-right-sidebar.html">right sidebar</a></li>
                                    <li><a href="portfolio-classic-2-columns-fullwidth.html">fullwidth</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)"> 3 column  <i class="fa fa-angle-left fa-indicator"></i></a>
                                <!-- drop down third level -->
                                <ul class="drop-down-multilevel left-side">
                                    <li><a href="portfolio-classic-3-columns-left-sidebar.html">left sidebar</a></li>
                                    <li><a href="portfolio-classic-3-columns-right-sidebar.html">right sidebar</a></li>
                                    <li><a href="portfolio-classic-3-columns-fullwidth.html">fullwidth</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)"> 4 column <i class="fa fa-angle-left fa-indicator"></i></a>
                                <!-- drop down third level -->
                                <ul class="drop-down-multilevel left-side">
                                    <li><a href="portfolio-classic-4-columns-left-sidebar.html">left sidebar</a></li>
                                    <li><a href="portfolio-classic-4-columns-right-sidebar.html">right sidebar</a></li>
                                    <li><a href="portfolio-classic-4-columns-fullwidth.html">fullwidth</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="javascript:void(0)">portfolio Masonry <i class="fa fa-angle-left fa-indicator"></i></a>
                      <!-- drop down second level -->
                        <ul class="drop-down-multilevel left-side">
                            <li><a href="portfolio-masonry-2-columns.html"> 2 column </a> </li>
                            <li><a href="portfolio-masonry-3-columns.html"> 3 column </a> </li>
                            <li><a href="portfolio-masonry-4-columns.html"> 4 column </a> </li>
                            <li><a href="portfolio-masonry-full-screen.html"> full screen </a> </li>
                        </ul> 
                    </li>
                    <li><a href="#">portfolio grid <i class="fa fa-angle-left fa-indicator"></i></a>
                      <ul class="drop-down-multilevel left-side">
                            <li><a href="javascript:void(0)"> grid <i class="fa fa-angle-left fa-indicator"></i></a>  
                               <!-- drop down third level -->
                                <ul class="drop-down-multilevel left-side">
                                    <li><a href="portfolio-grid-2-columns.html">2 column</a></li>
                                    <li><a href="portfolio-grid-3-columns.html">3 column</a></li>
                                    <li><a href="portfolio-grid-4-columns.html">4 column</a></li>
                                </ul>
                              </li>
                            <li><a href="javascript:void(0)"> grid full screen <i class="fa fa-angle-left fa-indicator"></i></a> 
                               <!-- drop down third level -->
                                <ul class="drop-down-multilevel left-side">
                                    <li><a href="portfolio-grid-full-screen-2-columns.html">2 column</a></li>
                                    <li><a href="portfolio-grid-full-screen-3-columns.html">3 column</a></li>
                                    <li><a href="portfolio-grid-full-screen-4-columns.html">4 column</a></li>
                                    <li><a href="portfolio-grid-full-screen-5-columns.html">5 column</a></li>
                                </ul>
                            </li>
                       </ul>
                    </li>
                    <li><a href="#">portfolio Packery <i class="fa fa-angle-left fa-indicator"></i></a>
                      <!-- drop down second level -->
                        <ul class="drop-down-multilevel left-side">
                            <li><a href="portfolio-packetry.html"> packetry fullwidth </a> </li>
                            <li><a href="portfolio-packetry-fullwidth.html"> full screen </a> </li>
                         </ul>
                    </li>
                    <li><a href="#">portfolio single <i class="fa fa-angle-left fa-indicator"></i></a>
                      <!-- drop down second level -->
                        <ul class="drop-down-multilevel left-side">
                            <li><a href="portfolio-single-1.html"> single 01 </a> </li>
                            <li><a href="portfolio-single-2.html"> single 02 </a> </li>
                         </ul>
                    </li>
                </ul>
            </li>
            <li><a href="javascript:void(0)"> Shortcodes <i class="fa fa-angle-down fa-indicator"></i></a>
              <!-- drop down full width -->
                <div class="drop-down grid-col-12">
                    <!--grid row-->
                    <div class="grid-row">
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="elements-accordions.html"><i class="fa fa-list-ul"></i> accordions </a></li>
                              <li><a href="elements-action-box.html"><i class="fa fa-rocket"></i> action box</a></li>
                              <li><a href="elements-alerts-and-callouts.html"><i class="fa fa-info-circle"></i> alerts and callouts</a></li>
                              <li><a href="elements-buttons.html"><i class="fa fa-external-link"></i> buttons</a></li>
                              <li><a href="elements-carousel-slider.html"><i class="fa fa-exchange"></i> carousel slider</a></li>
                            </ul>
                        </div>
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="elements-columns.html"><i class="fa fa-th"></i> columns</a></li>
                              <li><a href="elements-content-box.html"><i class="fa fa-file-text-o"></i> content box</a></li>
                              <li><a href="elements-counter.html"><i class="fa fa-sort-numeric-asc"></i> counter</a></li>
                              <li><a href="elements-data-table.html"><i class="fa fa-table"></i> data table</a></li>
                              <li><a href="elements-lists-style.html"><i class="fa fa-th-list"></i> lists style</a></li>
                            </ul>
                        </div>
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="elements-post-style.html"> <i class="fa fa-photo"></i> post style</a></li>
                              <li><a href="elements-pricing-tables.html"><i class="fa fa-money"></i> pricing tables</a></li>
                              <li><a href="elements-skills.html"><i class="fa fa-tasks"></i> skills</a></li>
                              <li><a href="elements-social-icon.html"><i class="fa fa-share-alt"></i> social icon</a></li>
                              <li><a href="elements-social-widget-gallery.html"><i class="fa fa-bullhorn"></i> social widget gallery</a></li>
                            </ul>
                        </div>
                        <!--grid column 3-->
                        <div class="grid-col-3">
                            <ul>
                              <li><a href="elements-tabs.html"><i class="fa fa-star"></i> tabs</a></li>
                              <li><a href="elements-team.html"><i class="fa fa-users"></i> team</a></li>
                              <li><a href="elements-typography.html"><i class="fa fa-italic"></i> typography</a></li>
                            </ul>
                        </div>
                    </div>
                </div> 
            </li>
            <li><a href="javascript:void(0)"> Contact <i class="fa fa-angle-down fa-indicator"></i></a>
                 <!-- drop down multilevel  -->
                <ul class="drop-down-multilevel right-menu">
                    <li><a href="contact-1.html">Contact 1</a></li>
                    <li><a href="contact-2.html">Contact 2</a></li>
                    <li><a href="contact-3.html">Contact 3</a></li>
                </ul>
            </li>
            <li><a href="javascript:void(0)"> <spring:message code="label.sitelanguage"/> <i class="fa fa-angle-down fa-indicator"></i></a>
                 <!-- drop down multilevel  -->
                <ul class="drop-down-multilevel right-menu">
                    <li><a href="?language=en"><spring:message code="label.english"/></a></li>
                    <li><a href="?language=es"><spring:message code="label.spanish"/></a></li>
                </ul>
            </li>
            <li>
              <div class="search-3">
                      <a class="search-btn not_click" href="javascript:void(0);">Search Button</a>
                        <div class="search-3-box not-click">
                           <input type="text" class="not-click" placeholder="Search" value="" name="s">
                         <i class="fa fa-search"></i>
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


<!--=================================
slider- -->
<!-- data-interval se necesita pra definir la pausa en cada slide. Al haber texto, es mejor poner algo más. -->
  <section id="animated-slider" class="carousel slide" data-ride="carousel" data-interval="6000">
      <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#animated-slider" data-slide-to="0" class="active"></li>
          <li data-target="#animated-slider" data-slide-to="1"></li>
          <li data-target="#animated-slider" data-slide-to="2"></li>
        </ol>
        <!-- Carousel inner -->
        <div class="carousel-inner">
          <!--/ Carousel item end -->
          <div class="item active bg-opacity-black-50">
            <img class="img-responsive" src="resources/template/images/gallery/facultadeconomicas.jpg" alt="slider">  
            <div class="slider-content">
              <div class="container">
              <div class="row">
                <div class="col-md-12 text-center">
                 <div class="slider-2">
                    <span class="animated1"><spring:message code ="label.welcometopmessage1"/></span>
                    <h1 class="animated2 text-white"><spring:message code ="label.welcomemessage1"/></h1>
                    <p class="animated3"><spring:message code ="label.welcomesubmessage1"/></p>
                    <a href="#" class="button animated8"> <span> Read More </span></a>
                    <a target="_blank" href="http://themeforest.net/item/the-corps-multipurpose-html5-template/15623522" class="button button-black animated8"><span> Purchase Now </span> </a>
                 </div>
                </div>
              </div>
            </div>
            </div>
          </div>
          <div class="item bg-opacity-black-50">
            <img class="img-responsive" src="resources/template/images/gallery/facultadingenieras.jpg" alt="slider">  
            <div class="slider-content">
              <div class="container">
              <div class="row">
                <div class="col-md-12 text-center">
                 <div class="slider-2">
                  <span class="animated1"><spring:message code ="label.welcometopmessage2"/></span>
                    <h1 class="animated4 text-white"><spring:message code ="label.welcomemessage2"/></h1>
                    <p class="animated5"><spring:message code ="label.welcomesubmessage2"/></p>
                    <a href="#" class="button animated8"> <span> Read More </span></a>
                    <a target="_blank" href="http://themeforest.net/item/the-corps-multipurpose-html5-template/15623522" class="button button-black animated8"><span> Purchase Now </span> </a>
                 </div>
                </div>
              </div>
            </div>
            </div>
          </div>
           <div class="item bg-opacity-black-50">
            <img class="img-responsive" src="resources/template/images/gallery/bibliotecauniversitaria.jpg" alt="slider">  
            <div class="slider-content">
              <div class="container">
              <div class="row">
                <div class="col-md-12 text-center">
                 <div class="slider-2">
                  <span class="animated1"><spring:message code ="label.welcometopmessage3"/></span>
                    <h1 class="animated6 text-white"><spring:message code ="label.welcomemessage3"/></h1>
                    <p class="animated7"><spring:message code ="label.welcomesubmessage3"/></p>
                    <a href="#" class="button animated8"> <span> Read More </span></a>
                    <a target="_blank" href="http://themeforest.net/item/the-corps-multipurpose-html5-template/15623522" class="button button-black animated8"><span> Purchase Now </span> </a>
                 </div>
                </div>
              </div>
            </div>
            </div>
          </div>
          <!--/ Carousel item end -->
        </div>
  </section>
 
<!--=================================
slider -->
 
 <!--=================================
custom-content -->

<section class="custom-content-3 hello-content white-bg">
  <div class="container">
     <div class="row">
        <div class="col-lg-7 col-md-7">
          <div class="page-section-pt">
           <span>Hello, i’m</span>
           <h2 class="text-blue">- Felicity Queen</h2>
           <strong class="mb-50">I work for every kind of customer's requirement.</strong>
           <div class="custom-content-3-info pull-left">
             <i class="fa fa-quote-right"></i>
             <p>I am consectetur adipisicing elit. At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut, nulla, illo. Fugit rerum, nisi quo nam iste labore? Libero possimus excepturi, labore! At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut. Fugit rerum, nisi quo nam iste labore? Libero possimus.</p>
             <img class="signature pull-right" src="resources/template/images/signature.png" alt="">
           </div> 
           <div class="row">
             <div class="col-lg-6 col-md-6">
               <div class="feature-8 clearfix mt-30">
                <div class="feature-8-title">
                  <span class="icon-layers" aria-hidden="true"></span>
                </div>
                <div class="feature-8-info">
                  <h4 class="text-back">Professional Design</h4>
                  <p class="textjustify">Dolor sit amet, consectetur adipisicing elit. Vero quod conseqt quibusdam</p>
                </div>
              </div>
             </div>
             <div class="col-lg-6 col-md-6">
               <div class="feature-8 clearfix mt-30">
                <div class="feature-8-title">
                  <span class="icon-picture" aria-hidden="true"></span>
                </div>
                <div class="feature-8-info">
                  <h4 class="text-back">Revolution Slider</h4>
                  <p class="textjustify">Dolor sit amet, consectetur adipisicing elit. Vero quod conseqt quibusdam </p>
                </div>
              </div>
             </div>
           </div>
         </div>
        </div>
        <div class="col-lg-5 col-md-5">
         <div class="custom-content-3-image mt-15">
           <img src="resources/template/images/device/women-2.jpg" alt="">
         </div>
        </div>
     </div>
  </div>
</section> 

<!--=================================
custom-content -->


<!--=================================
 creativity -->

<section class="bg-4 bg-opacity-black-80 creativity page-section-ptb">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12 text-center"> 
        <h1 class="text-white">See what others don't see <br/>Then show it to them</h1>
        <p class="text-white mt-30 mb-0">That is creativity </p>
        <a class="button mt-50" target="blank" href="http://themeforest.net/item/the-corps-multipurpose-html5-template/15623522">
            <span>Purchase Now</span>
            <i class="fa fa-download"></i>
         </a>
        <a class="button button-white mt-50" href="#">
          <span>Discover more</span>
          <i class="fa fa-eye"></i>
       </a>
      </div>
    </div>
  </div>
</section>

<!--=================================
 creativity -->


 <!--=================================
 our-clients -->

<section class="happy-clients white-bg page-section-ptb">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <div class="section-title-2 text-center">
          <h1 class="text-blue">Our Happy Clients</h1>
          <div class="title-line"></div>
          <p>What Our Happy Clients say about us</p>
        </div>
       </div>
      </div>
      <div class="row">
       <div class="col-lg-12 col-md-12">
         <div id="tabs">
             <div id="tab1" class="tabcontent"> 
                  <p>" I would like to express my thanks and appreciation to you for understanding the subject matter and for your excellent writing. Good job and well done. I look forward to working with you in our next project Quae ratione, in ipsa.Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos ”</p>
              </div>
              <div id="tab2" class="tabcontent"> 
                  <p>" We are very pleased with your service and the professional way all our queries and problems have been handled. I certainly would not hesitate to recommend your organisation to other people I come into contact with. Quae ratione, in ipsa.Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos ”</p>
              </div>
              <div id="tab3" class="tabcontent"> 
                  <p>" Our old site was very information-heavy; the Corps helped to capture and simplify the message we wanted to get across. It’s now more precise, easy to use and looks great! quos magnam cupiditate pariatur? Quae ratione, in ipsa.Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra. ”</p>
              </div>
              <div id="tab4" class="tabcontent"> 
                  <p>" We are very pleased with your service and the professional way all our queries and problems have been handled. I certainly would not hesitate to recommend your organisation to other people I come into contact with. Quae ratione, in ipsa.Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra per inceptos. ”</p>
              </div>
              <div id="tab5" class="tabcontent"> 
                  <p>" I would like to express my thanks and appreciation to you for understanding the subject matter and for your excellent writing. Good job and well done. I look forward to working with you in our next project Quae ratione, in ipsa.Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra per inceptos. ”</p>
              </div>
              <div id="tab6" class="tabcontent"> 
                  <p>" Our old site was very information-heavy; the Corps helped to capture and simplify the message we wanted to get across. It’s now more precise, easy to use and looks great! quos magnam cupiditate pariatur? Quae ratione, in ipsa.Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra per inceptos. ”</p>
              </div>
              <ul class="tabs">
                 <li data-tabs="tab1" class="animated-arrow active"> <img class="img-responsive" src="resources/template/images/clients/01.png" alt=""></li>
                 <li data-tabs="tab2" class="animated-arrow"> <img class="img-responsive" src="resources/template/images/clients/02.png" alt=""></li>
                 <li data-tabs="tab3" class="animated-arrow"> <img class="img-responsive" src="resources/template/images/clients/03.png" alt=""></li>
                 <li data-tabs="tab4" class="animated-arrow"> <img class="img-responsive" src="resources/template/images/clients/04.png" alt=""></li>
                 <li data-tabs="tab5" class="animated-arrow"> <img class="img-responsive" src="resources/template/images/clients/05.png" alt=""></li>
                 <li data-tabs="tab6" class="animated-arrow"> <img class="img-responsive" src="resources/template/images/clients/02.png" alt=""></li>
                </ul>
          </div>
      </div>
    </div>
  </div>
</section>

 <!--=================================
 our-clients -->


<!--=================================
 video-background -->
 
<div id="video-background" class="video-content bg-opacity-black-30" style="width: 100%;" data-vide-bg="mp4: resources/template/video/video-1, webm: resources/template/video/video-1, ogv: resources/template/video/video-1, poster: resources/template/video/video-1" data-vide-options="position: 0% 50%">
 <div class="video-bg bg-opacity-black-50 page-section-pt">
  <div class="container">
    <div class="row">
       <div class="section-title-2 text-center">
          <h1 class="text-white">Video Background</h1>
          <div class="title-line-2"></div>
          <p class="text-white mt-20 mb-30">Beautiful HTML5 Video background</p>
          <a target="blank" href="http://themeforest.net/item/the-corps-multipurpose-html5-template/15623522" class="button-border-white">
            <span>Purchase Now</span>
         </a>
        </div>
     </div>
    </div>
   </div>
</div>

<!--=================================
 video-background -->


 <!--=================================
 owl-custom -->

<section class="owl-custom white-bg page-section-ptb">
  <div class="container">
    <div class="row">
     <div class="owl-carousel-12">
      <div class="item">
      <div class="col-lg-6 col-md-6">
        <img class="img-responsive" src="resources/template/images/device/device-3.png" alt="">
      </div>
      <div class="col-lg-6 col-md-6">
       <div class="custom-content">
         <h2 class="text-blue mb-20">Easy To Use Templates</h2>
         
         <p>There are lots of reasons, but most importantly because. lorem ipsum dolor sit amet, consectetur adipisicing elit. At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut, nulla, illo. Fugit rerum, nisi quo nam.</p>
          <ul class="mt-20">
            <li><i class="fa fa-hand-o-right"></i> Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, </li>
            <li><i class="fa fa-hand-o-right"></i> lorem quis bibendum auctor, nisi elit consequat ipsum, </li>
            <li><i class="fa fa-hand-o-right"></i> nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate  </li>
            <li><i class="fa fa-hand-o-right"></i> cursus a sit amet mauris. Morbi accumsan ipsum velit. </li>
            <li><i class="fa fa-hand-o-right"></i> cursus a sit amet mauris. Morbi accumsan ipsum velit. </li>
          </ul>
         </div>
        </div>
     </div>
     <div class="item">
      <div class="col-lg-6 col-md-6">
       <div class="custom-content">
         <h2 class="text-blue mb-30">Clean & Simple Code! </h2>
         <p>There are lots of reasons, but most importantly because. lorem ipsum dolor sit amet, consectetur adipisicing elit. At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut, nulla, illo. Fugit rerum, nisi quo nam.</p>
           <div class="feature-8 mt-30">
            <div class="feature-8-title">
             <span aria-hidden="true" class="icon-equalizer"></span>
            </div> 
            <div class="feature-8-info">
              <h4 class="text-back">Built with HTML5 and css3</h4>
              <p>Dolor sit amet, consectetur conseqt quibusdam,  incidunt Vero quod conseqt quibusdam, enim expedita sed quia nesciunt incidunt</p>
            </div>
         </div>
         <div class="feature-8 mt-30">
            <div class="feature-8-title">
             <span class="icon-picture" aria-hidden="true"></span>
            </div>
            <div class="feature-8-info">
              <h4 class="text-back">Revolution Slider</h4>
              <p>Dolor sit amet, consectetur conseqt quibusdam,  incidunt Vero quod conseqt quibusdam, enim expedita sed quia nesciunt incidunt</p>
            </div>
         </div>
         </div>
        </div>
        <div class="col-lg-6 col-md-6">
        <img class="img-responsive" src="resources/template/images/device/device-2.png" alt="">
      </div>
     </div>
     <div class="item">
      <div class="col-lg-6 col-md-6">
        <img class="img-responsive center-block pt-60" src="resources/template/images/device/device.png" alt="">
      </div>
      <div class="col-lg-6 col-md-6">
       <div class="custom-content">
         <h2 class="text-blue mb-30">Unlimited Options</h2>
         <p>There are lots of reasons, but most importantly because. lorem ipsum dolor sit amet, consectetur adipisicing elit. At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut, nulla, illo. Fugit rerum, nisi quo nam.</p>
          <ul class="mt-20 mb-20">
            <li><i class="fa fa-hand-o-right"></i> Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, </li>
            <li><i class="fa fa-hand-o-right"></i> lorem quis bibendum auctor, nisi elit consequat ipsum, </li>
            <li><i class="fa fa-hand-o-right"></i> lorem quis bibendum auctor, nisi elit consequat ipsum, </li>
          </ul>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut, nulla, illo. Fugit rerum, nisi quo nam iste labore? Libero possimus excepturi, labore! At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut.</p>
         </div>
        </div>
      </div>
      </div>
    </div>
   </div>
  </section>

<!--=================================
 owl-custom -->


<!--=================================
blog -->

<section class="our-blog hover-direction white-bg">
  <div class="container-fluid">
     <div class="row">
        <div class="col-lg-6 col-md-6">
          <div class="blog-box-info">
             <h1 class="text-white">Our Latest Blog Post</h1>
             <span class="text-white"> Read what we say in our blog</span>
             <p class="text-white pt-30 pb-20">Lorem ipsum dolor sit amet, consectetur adipisicing elit. At molestiae debitis quaerat nesciunt, aliquam perferendis ab! Ut, nulla, illo. Fugit rerum, nisi quo nam iste labore? Libero. </p>
             <a href="#" class="button button-white">
                <span>View all post</span>
                <i class="fa fa-hand-o-right"></i>
             </a>
          </div>
        </div>
        <div class="col-lg-3 col-md-3">
          <div class="blog-box-image">
            <div class="portfolio-item">
                 <img class="img-responsive" src="resources/template/images/portfolio/medium/06.jpg" alt="">
                 <div class="portfolio-caption text-right">
                   <a href="#">Lorem ipsum dolor sit </a>
                    <ul class="port-tag">
                      <li><a href="#"><i class="fa fa-user"></i> By The Corps</a></li>
                      <li><a href="#"><i class="fa fa-comments-o"></i> 5 Comments</a></li>
                      <li><a href="#"><i class="fa fa-folder-open"></i> Business</a></li>
                   </ul>
                  <a href="#" class="button-border">
                    <span>Read view</span>
                  </a>
               </div>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-3">
          <div class="blog-box-image">
            <div class="portfolio-item">
                 <img class="img-responsive" src="resources/template/images/portfolio/medium/17.jpg" alt="">
                 <div class="portfolio-caption text-right">
                   <a href="#">Lorem ipsum dolor sit </a>
                    <ul class="port-tag">
                      <li><a href="#"><i class="fa fa-user"></i> By The Corps</a></li>
                      <li><a href="#"><i class="fa fa-comments-o"></i> 5 Comments</a></li>
                      <li><a href="#"><i class="fa fa-folder-open"></i> Business</a></li>
                   </ul>
                  <a href="#" class="button-border">
                    <span>Read view</span>
                  </a>
               </div>
            </div>
        </div>
      </div>
     </div>
     <div class="row">
        <div class="col-lg-3 col-md-3">
          <div class="blog-box-image">
            <div class="portfolio-item">
                 <img class="img-responsive" src="resources/template/images/portfolio/medium/10.jpg" alt="">
                 <div class="portfolio-caption text-right">
                   <a href="#">Lorem ipsum dolor sit </a>
                    <ul class="port-tag">
                      <li><a href="#"><i class="fa fa-user"></i> By The Corps</a></li>
                      <li><a href="#"><i class="fa fa-comments-o"></i> 5 Comments</a></li>
                      <li><a href="#"><i class="fa fa-folder-open"></i> Business</a></li>
                   </ul>
                  <a href="#" class="button-border">
                    <span>Read view</span>
                  </a>
               </div>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-3">
          <div class="blog-box-image">
            <div class="portfolio-item">
                 <img class="img-responsive" src="resources/template/images/portfolio/medium/16.jpg" alt="">
                 <div class="portfolio-caption text-right">
                   <a href="#">Lorem ipsum dolor sit </a>
                    <ul class="port-tag">
                      <li><a href="#"><i class="fa fa-user"></i> By The Corps</a></li>
                      <li><a href="#"><i class="fa fa-comments-o"></i> 5 Comments</a></li>
                      <li><a href="#"><i class="fa fa-folder-open"></i> Business</a></li>
                   </ul>
                  <a href="#" class="button-border">
                    <span>Read view</span>
                  </a>
               </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6 col-md-6">
          <div class="blog-box-image">
             <div class="portfolio-item">
                 <img class="img-responsive" src="resources/template/images/blog/big/24.jpg" alt="">
                 <div class="portfolio-caption text-right">
                   <a href="#">Lorem ipsum dolor sit </a>
                    <ul class="port-tag">
                      <li><a href="#"><i class="fa fa-user"></i> By The Corps</a></li>
                      <li><a href="#"><i class="fa fa-comments-o"></i> 5 Comments</a></li>
                      <li><a href="#"><i class="fa fa-folder-open"></i> Business</a></li>
                   </ul>
                   <a href="#" class="button-border">
                    <span>Read view</span>
                  </a>
               </div>
            </div>
          </div>
        </div>
     </div>
  </div>
</section>

<!--=================================
blog -->


<!--=================================
news-letter -->

<section class="news-letter bg-8 bg-opacity-white-70">
  <div class="container">
     <div class="row">
        <div class="col-lg-6 col-md-6">
            <h1 class="text-blue">News letter sign up</h1>
            <p>Keep up on our always evolving product features and technology. Enter your e-mail and subscribe to our newsletter.</p>
        </div>
        <div class="col-lg-6 col-md-6">
           <div class="section-field mt-30">
              <div class="field-widget">
                <i class="fa fa-envelope-o"></i>
                <input type="text" name="name" placeholder="Email address..."  id="name">
                <a href="#" class="button-border pull-right">
                    <span>Sign up</span>
                  </a>
              </div>  
            </div>
        </div>
    </div>
  </div>
</section>

<!--=================================
news-letter -->


 <!--=================================
 key-features -->
 
 
<!--  Estos son todos los simple line icons que se pueden usar  -->
<!-- .icon-user-female, .icon-user-follow, .icon-user-following, .icon-user-unfollow, .icon-trophy, .icon-screen-smartphone,  -->
<!-- .icon-screen-desktop, .icon-plane, .icon-notebook, .icon-moustache, .icon-mouse, .icon-magnet, .icon-energy, .icon-emoticon-smile, . -->
<!--  icon-disc, .icon-cursor-move, .icon-crop, .icon-credit-card, .icon-chemistry, .icon-user, .icon-speedometer, .icon-social-youtube,  -->
<!-- .icon-social-twitter, .icon-social-tumblr, .icon-social-facebook, .icon-social-dropbox, .icon-social-dribbble, .icon-shield, .icon-screen-tablet,  -->
<!-- .icon-magic-wand, .icon-hourglass, .icon-graduation, .icon-ghost, .icon-game-controller, .icon-fire, .icon-eyeglasses, .icon-envelope-open, .icon-envelope-letter,  -->
<!-- .icon-bell, .icon-badge, .icon-anchor, .icon-wallet, .icon-vector, .icon-speech, .icon-puzzle, .icon-printer, .icon-present, .icon-playlist,  -->
<!-- .icon-pin, .icon-picture, .icon-map, .icon-layers, .icon-handbag, .icon-globe-alt, .icon-globe, .icon-frame, .icon-folder-alt, .icon-film, .icon-feed,  -->
<!-- .icon-earphones-alt, .icon-earphones, .icon-drop, .icon-drawer, .icon-docs, .icon-directions, .icon-direction, .icon-diamond, .icon-cup, .icon-compass,  -->
<!-- .icon-call-out, .icon-call-in, .icon-call-end, .icon-calculator, .icon-bubbles, .icon-briefcase, .icon-book-open, .icon-basket-loaded, .icon-basket,  -->
<!-- .icon-bag, .icon-action-undo, .icon-action-redo, .icon-wrench, .icon-umbrella, .icon-trash, .icon-tag, .icon-support, .icon-size-fullscreen, .icon-size-actual,  -->
<!-- .icon-shuffle, .icon-share-alt, .icon-share, .icon-rocket, .icon-question, .icon-pie-chart, .icon-pencil, .icon-note, .icon-music-tone-alt, .icon-music-tone,  -->
<!-- .icon-microphone, .icon-loop, .icon-logout, .icon-login, .icon-list, .icon-like, .icon-home, .icon-grid, .icon-graph, .icon-equalizer, .icon-dislike, .icon-cursor,  -->
<!-- .icon-control-start, .icon-control-rewind, .icon-control-play, .icon-control-pause, .icon-control-forward, .icon-control-end, .icon-calendar, .icon-bulb, .icon-bar-chart,  -->
<!-- .icon-arrow-up, .icon-arrow-right, .icon-arrow-left, .icon-arrow-down, .icon-ban, .icon-bubble, .icon-camcorder, .icon-camera, .icon-check, .icon-clock, .icon-close,  -->
<!-- .icon-cloud-download, .icon-cloud-upload, .icon-doc, .icon-envelope, .icon-eye, .icon-flag, .icon-folder, .icon-heart, .icon-info, .icon-key, .icon-link,  -->
<!-- .icon-lock, .icon-lock-open, .icon-magnifier, .icon-magnifier-add, .icon-magnifier-remove, .icon-paper-clip, .icon-paper-plane, .icon-plus, .icon-pointer,  -->
<!-- .icon-power, .icon-refresh, .icon-reload, .icon-settings, .icon-star, .icon-symbol-female, .icon-symbol-male, .icon-target, .icon-volume-1, .icon-volume-2,  -->
<!-- .icon-volume-off, .icon-users  -->

<section id="services" class="key-features white-bg page-section-ptb">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <div class="section-title-2 text-center">
          <h1 class="text-blue"><spring:message code ="label.siteservicestitle"/></h1>
          <div class="title-line"></div>
          <p> <spring:message code ="label.siteservicessubtitle"/></p>
        </div>
       </div>
      </div>
      <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="feature-10 text-center mb-30 wow fadeInUp" data-wow-delay="0.2s" data-wow-duration="1.5s ">
            <a href="/apr"><span class="icon-calculator" aria-hidden="true"></span></a>
            <h4 class="text-back pt-20 pb-10"><spring:message code ="label.siteservice1"/></h4>
            <p><spring:message code ="label.siteservice1description"/></p>
          </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="feature-10 text-center mb-30 wow fadeInUp" data-wow-delay="0.4s" data-wow-duration="1.5s">
            <a href="/leasing"><span class="icon-layers" aria-hidden="true"></span></a>
            <h4 class="text-back pt-20 pb-10"><spring:message code ="label.siteservice2"/></h4>
            <p><spring:message code ="label.siteservice2description"/></p>
          </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="feature-10 text-center mb-30 wow fadeInUp" data-wow-delay="0.6s" data-wow-duration="1.5s">
            <a href="/offersconsulting"><span class="icon-book-open" aria-hidden="true"></span></a>
            <h4 class="text-back pt-20 pb-10"><spring:message code ="label.siteservice3"/></h4>
            <p><spring:message code ="label.siteservice3description"/></p>
          </div>
        </div>
     </div>
     <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="feature-10 text-center mb-30 wow fadeInUp" data-wow-delay="0.8s" data-wow-duration="1.5s">
            <a href="/loans"><span class="icon-wallet" aria-hidden="true"></span></a>
            <h4 class="text-back pt-20 pb-10"><spring:message code ="label.siteservice4"/></h4>
            <p><spring:message code ="label.siteservice4description"/></p>
          </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="feature-10 text-center mb-30 wow fadeInUp" data-wow-delay="1.0s" data-wow-duration="1.5s">
            <a href="/discounts"><span class="icon-basket-loaded" aria-hidden="true"></span></a>
            <h4 class="text-back pt-20 pb-10"><spring:message code ="label.siteservice5"/></h4>
            <p><spring:message code ="label.siteservice5description"/></p>
          </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="feature-10 text-center mb-30 wow fadeInUp" data-wow-delay="1.2s" data-wow-duration="1.5s">
            <a href="/reversemortgage"><span class="icon-shuffle" aria-hidden="true"></span></a>
            <h4 class="text-back pt-20 pb-10"><spring:message code ="label.siteservice6"/></h4>
            <p><spring:message code ="label.siteservice6description"/></p>
          </div>
        </div>
     </div>
     <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4">
          <div class="feature-10 text-center wow fadeInUp" data-wow-delay="1.4s" data-wow-duration="1.5s">
            <a href="creditaccount"><span class="icon-credit-card" aria-hidden="true"></span></a>
            <h4 class="text-back pt-20 pb-10"><spring:message code ="label.siteservice7"/></h4>
            <p><spring:message code ="label.siteservice7description"/></p>
          </div>
        </div>
     </div>
   </div>
</section>

<!--=================================
  key-features -->

<!--=================================
 testimonial (sponsors) -->

<section class="testimonial-3 bg-17 bg-opacity-black-40 white-bg page-section-ptb">
   <div class="container">
      <div class="row">
         <div class="col-lg-12 col-md-12 text-center">
          <h2 class="text-white mb-60"><spring:message code="label.oursponsorstitle"></spring:message></h2>
           <div class="owl-carousel-19">
            <div class="item">
             <p><a href="www.unileon.es"><img alt="logoule" src="resources/template/images/sponsors/logo-ule.png"></a></p>
             <span>Universidad de León</span><br>
             <span><a href="www.unileon.es">Acceder</a></span>
            </div>
            <div class="item">
              <p><a href="http://centros.unileon.es/eiii/"><img alt="logoule" src="resources/template/images/sponsors/logo-ule.png"/></a></p>
              <span>Escuela de Ingenierías</span><br>
             <span><a href="http://centros.unileon.es/eiii/">Acceder</a></span>
            </div>
            <div class="item">
              <p><a href="http://economicas.unileon.es/"><img alt="logoule" src="resources/template/images/sponsors/logo-ule.png"/></a></p>
              <span>Facultad de Ciencias Económicas y Empresariales</span><br>
             <span><a href="http://economicas.unileon.es/">Acceder</a></span>
            </div>
           </div>  
       </div>
   </div>
 </div>
</section> 

 <!--=================================
 testimonial (sponsors)-->

<!--=================================
our-team  -->

 <section class="our-team white-bg page-section-ptb">
   <div class="container">
     <div class="row">
       <div class="col-lg-12 col-md-12">
         <div class="section-title-2 text-center">
          <h2 class="text-blue"><spring:message code="label.meetourteam"/></h2>
          <div class="title-line"></div>
          <p><spring:message code="label.meetourteamsub"/></p>
        </div>
       </div> 
    </div>
  <div class="team-2">
   <div class="row">
    <div class="col-lg-3 col-md-3 col-sm-6">
       <div class="team-2-box">
        <img alt="" src="resources/template/images/team/random1.jpg" class="img-responsive"> 
          <div class="team-overlay text-center"> 
              <div class="info">
                 <h5 class="text-white">Camino Fernández</h5>
               <span><spring:message code="label.teamrol1"/></span>
             </div>
              <div class="social">
               <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
            </ul>
          </div>
       </div>
      </div>
     </div> 
      <div class="col-lg-3 col-md-3 col-sm-6">
         <div class="team-2-box">
          <img alt="" src="resources/template/images/team/random3.jpg" class="img-responsive"> 
            <div class="team-overlay text-center"> 
                <div class="info">
                   <h5 class="text-white">Alexis Gutiérrez</h5>
                 <span><spring:message code="label.teamrol2"/></span>
               </div>
                <div class="social">
                 <ul>
                  <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                  <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                  <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                  <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
              </ul>
            </div>
         </div>
        </div>
       </div>
      <div class="col-lg-3 col-md-3 col-sm-6">
       <div class="team-2-box">
        <img alt="" src="resources/template/images/team/random1.jpg" class="img-responsive"> 
          <div class="team-overlay text-center"> 
              <div class="info">
                 <h5 class="text-white">Javier Castaño</h5>
               <span><spring:message code="label.teamrol3"/></span>
             </div>
              <div class="social">
               <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
            </ul>
          </div>
       </div>
      </div>
     </div> 
      <div class="col-lg-3 col-md-3 col-sm-6">
       <div class="team-2-box">
        <img alt="" src="resources/template/images/team/random2.jpg" class="img-responsive"> 
          <div class="team-overlay text-center"> 
              <div class="info">
                 <h5 class="text-white">Razvan Raducu</h5>
               <span><spring:message code="label.teamrol2"/></span>
             </div>
              <div class="social">
               <ul>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                <li><a href="#"><i class="fa fa-vimeo"></i></a></li>
            </ul>
          </div>
       </div>
      </div>
     </div> 
   </div>
  </div>
 </div>
</section>

<!--=================================
our-team -->



 <!--=================================
 map-->

<section id="contact" class="white-bg contact clearfix page-section-pt">
  <div class="container">
    <div class="row">
     <div class="col-lg-12 col-md-12">
      <div class="section-title text-center">
        <h1 class="text-blue"><spring:message code="label.getintouch"/></h1>
        <div class="title-line"></div>
        <p><spring:message code="label.getintouchsub"/></p>
       </div>
      </div>
     </div>
   </div>
   <div class="container-fluid">
     <div class="contact-map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d11744.720547149747!2d-5.567375190484793!3d42.61513548195593!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd379a96402735cb%3A0x3f44569fb640efd5!2sUniversity+of+Le%C3%B3n!5e0!3m2!1sen!2ses!4v1487545508683" width="100%" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
     </div>       
  </div>
</section>

<!--=================================
  social -->

<section class="social-full white-bg">
  <div class="container-fluid">
   <ul>
    <li><a class="fb" href="#"><i class="fa fa-facebook"></i></a></li>
    <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
    <li><a class="pinterest" href="#"><i class="fa fa-pinterest-p"></i></a></li>
    <li><a class="vimeo" href="#"><i class="fa fa-vimeo"></i></a></li>
    <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
    <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
    <li><a class="rss" href="#"><i class="fa fa-rss"></i></a></li>
    <li><a class="behance" href="#"><i class="fa fa-behance"></i></a></li>
   </ul>
  </div>
</section>

<!--=================================
  social -->


<!--=================================
 footer -->

<footer class="footer-4 page-section-pt">
 <div class="container">
  <div class="row">
    <div class="col-lg-3 col-md-3 col-sm-6">
       <div class="get-in-touch footer-hedding">
        <h4 class="text-blue mb-20"><spring:message code="label.getintouch"/></h4>
         <div class="contact-add">
           <i class="fa fa-map-marker"></i>
           <p class="mt-15 mb-15 text-white">Campus Universitario de Vegazana, S/N, 24071 León</p>
         </div>
         <div class="contact-add">
           <i class="fa fa-phone"></i>
           <p class="mt-15 mb-15 text-white">987 29 10 00 (ES)</p>
         </div>
         <div class="contact-add">
           <i class="fa fa-envelope-o"></i>
           <p class="mt-15 mb-15 text-white"> rraduc00@estudiantes.unileon.es </p>
         </div>
    </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6">
      <div class="office-hours footer-hedding">
        <h4 class="text-blue mb-20"><spring:message code="label.siteofficehours"/></h4>
         <p>Mon-Fri : 10 a.m. – 7 p.m. (GMT +1)</p>
         <p>Saturday : 9 a.m. – 1 p.m. (GMT +1)</p>
         <img src="resources/template/images/clock.png" alt="">
      </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6">
       <div class="tags footer-hedding">
        <h4 class="text-blue mb-20"><spring:message code="label.sitetopsearch"/></h4>
        <ul>
          <li><a href="/apr"><spring:message code="label.siteservice1"/></a></li>
          <li><a href="/offersconsulting"><spring:message code="label.siteservice3"/></a></li>
          <li><a href="/discounts"><spring:message code="label.siteservice5"/></a></li>
          <li><a href="/creditaccount"><spring:message code="label.siteservice7"/></a></li>
        </ul>
      </div>
      </div>
    <div class="col-lg-3 col-md-3 col-sm-6">
      <div class="footer-useful-link footer-hedding">
        <h4 class="text-blue mb-20">Latest Tweets</h4>
         <ul class="twitter-feed">
           <li><i class="fa fa-twitter"></i> <p class="text-white">Our brand new website builder, Envato Sites, has just launched into private beta! <a href=""> http://enva.to/nKqxx </a></p></li>           
           <li><i class="fa fa-twitter"></i> <p class="text-white">Get your photo on Unstock and win prizes. <a href="#">http://enva.to/unstock</a></p></li>           
         </ul>   
      </div>
    </div>
   </div>
  </div>
  <div class="footer-widget mt-60">
   <div class="container"> 
    <div class="row">
      <div class="col-lg-6 col-md-6 col-sm-6">
        <p class="text-white mt-15"> &copy;Copyright <span id="copyright"> <script>document.getElementById('copyright').appendChild(document.createTextNode(new Date().getFullYear()))</script></span> <a href="#"> ULe-Bank </a> <spring:message code="label.siterights"/> </p>
      </div>
    </div>    
   </div>
  </div>
</footer>

<!--=================================
 footer -->


<!--=================================
 popup contact -->

<div class="popup-contact">
 <div class="popup-contact-box">
  <a href="#" id="contact-btn"><i class="fa fa-envelope-o"></i></a> 
  <div class="contact-info clearfix">
    <h4 class="mb-30">Send us a message</h4>
    <div id="formmessage-2">Success/Error Message Goes Here</div>
     <form class="form-horizontal" id="contactform-2" role="form" method="post" action="php/contact-form-2.php">
        <div class="contact-form">
        <div class="section-field">
            <div class="field-widget">
            <i class="fa fa-user"></i>  
            <input id="name" type="text" placeholder="Name*"  name="name">
          </div> 
         </div>
         <div class="section-field">
            <div class="field-widget">
            <i class="fa fa-envelope-o"></i>
             <input type="email" placeholder="Email*" name="email">
          </div> 
         </div>
         <div class="section-field clearfix">
          <div class="field-widget">
               <i class="fa fa-pencil"></i>
               <textarea class="input-message"  placeholder="Comment*" rows="3" name="message"></textarea>
            </div>
          </div>
          <input type="hidden" name="action" value="sendEmail"/>
             <button id="submit-2" name="submit" type="submit" value="Send" class="button-border pull-right clearfix"><span>Send</span></button>
             </div> 
         </form>
       <div id="ajaxloader-2" style="display:none"><img class="center-block mt-30 mb-30" src="resources/template/images/ajax-loader.gif" alt=""></div>
    </div>
 </div>
</div> 

<!--=================================
 popup contact -->
 
 </div>
 
<div id="back-to-top"><a class="top arrow" href="#top"><i class="fa fa-long-arrow-up"></i></a></div>
  
<!--=================================
 jquery -->

<!-- jquery  -->
<script type="text/javascript" src="resources/template/js/jquery.min.js"></script>

<!-- bootstrap -->
<script type="text/javascript" src="resources/template/js/bootstrap.min.js"></script>

<!-- plugins-jquery -->
<script type="text/javascript" src="resources/template/js/plugins-jquery.js"></script>

<!-- mega menu -->
<script type="text/javascript" src="resources/template/js/mega-menu/mega_menu.js"></script>
 
<!-- hover -->
<script type="text/javascript" src="resources/template/js/portfolio/jquery.directional-hover.js"></script>
 
<!-- socialstream -->
<script src="resources/template/js/social/socialstream.jquery.js"></script>

<!-- videoBG -->
<script src="resources/template/js/video/jquery.vide.js"></script>

<!-- popup -->
<script src="resources/template/js/popup/jquery.magnific-popup.js"></script>

<!-- isotope -->
<script src="resources/template/js/isotope/isotope.pkgd.min.js"></script>

<!-- Wow --> 
<script type="text/javascript" src="resources/template/js/wow.min.js"></script>

<!-- custom -->
<script type="text/javascript" src="resources/template/js/custom.js"></script>
 
</body>
</html>
