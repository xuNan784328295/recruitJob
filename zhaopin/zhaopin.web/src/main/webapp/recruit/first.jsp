<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Favicon-->
		<link rel="shortcut icon" href="recruit/img/fav.png">
		<!-- Author Meta -->
		<meta name="author" content="codepixer">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Job Listing</title>

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="recruit/css/linearicons.css">
			<link rel="stylesheet" href="recruit/css/font-awesome.min.css">
			<link rel="stylesheet" href="recruit/css/bootstrap.css">
			<link rel="stylesheet" href="recruit/css/magnific-popup.css">
			<link rel="stylesheet" href="recruit/css/nice-select.css">					
			<link rel="stylesheet" href="recruit/css/animate.min.css">
			<link rel="stylesheet" href="recruit/css/owl.carousel.css">
			<link rel="stylesheet" href="recruit/css/main.css">
		</head>
		<body>

			  <header id="header" id="home">
			    <div class="container">
			    	<div class="row align-items-center justify-content-between d-flex">
				      <div id="logo">
				        <a href="index.html"><img src="recruit/img/logo.png" alt="" title="" /></a>
				      </div>
				      <nav id="nav-menu-container">
				        <ul class="nav-menu">
				          <li class="menu-active"><a href="index.html">Home</a></li>
				          <li><a href="about-us.html">About Us</a></li>
				          <li><a href="category.html">Category</a></li>
				          <li><a href="price.html">Price</a></li>
				          <li><a href="blog-home.html">Blog</a></li>
				          <li><a href="contact.html">Contact</a></li>
				          <li class="menu-has-children"><a href="">Pages</a>
				            <ul>
								<li><a href="elements.html">elements</a></li>
								<li><a href="search.jsp">search</a></li>
								<li><a href="single.html">single</a></li>
				            </ul>
				          </li>
				          <li><a class="ticker-btn" href="#">Signup</a></li>
				          <li><a class="ticker-btn" href="#">Login</a></li>				          				          
				        </ul>
				      </nav><!-- #nav-menu-container -->		    		
			    	</div>
			    </div>
			  </header><!-- #header -->


			<!-- start banner Area -->
			<section class="banner-area relative" id="home">	
				<div class="overlay overlay-bg"></div>
				<div class="container">
					<div class="row fullscreen d-flex align-items-center justify-content-center">
						<div class="banner-content col-lg-12">
							<h1 class="text-white">
								<span>1500+</span> Jobs posted last week				
							</h1>	
							<form action="/recruit/searchByTerm.whtml" class="serach-form-area" method="post">
								<div class="row justify-content-center form-wrap">
									<div class="col-lg-4 form-cols">
										<input type="text" class="form-control" name="search" placeholder="what are you looging for?">
									</div>
									<div class="col-lg-3 form-cols">
										<div class="default-select" id="default-selects">
											<select  name="area">
												<option value="1">Select area</option>
												<option value="2">Dhaka</option>
												<option value="3">Rajshahi</option>
												<option value="4">Barishal</option>
												<option value="5">Noakhali</option>
											</select>
										</div>
									</div>
									<div class="col-lg-3 form-cols">
										<div class="default-select" id="default-selects2">
											<select name="category">
												<option value="1">All Category</option>
												<option value="2">Medical</option>
												<option value="3">Technology</option>
												<option value="4">Goverment</option>
												<option value="5">Development</option>
											</select>
										</div>										
									</div>
									<div class="col-lg-2 form-cols">
									    <button type="submit" class="btn btn-info" >
									      <span class="lnr lnr-magnifier"></span> Search
									    </button>
									</div>								
								</div>
							</form>	
							<p class="text-white"> <span>Search by tags:</span> Tecnology, Business, Consulting, IT Company, Design, Development</p>
						</div>											
					</div>
				</div>
			</section>
			<!-- End banner Area -->
			<script src="recruit/js/vendor/jquery-2.2.4.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="recruit/js/vendor/bootstrap.min.js"></script>			
			
  			<script src="recruit/js/easing.min.js"></script>			
			<script src="recruit/js/hoverIntent.js"></script>
			<script src="recruit/js/superfish.min.js"></script>	
			<script src="recruit/js/jquery.ajaxchimp.min.js"></script>
			<script src="recruit/js/jquery.magnific-popup.min.js"></script>	
			<script src="recruit/js/owl.carousel.min.js"></script>			
			<script src="recruit/js/jquery.sticky.js"></script>
			<script src="recruit/js/jquery.nice-select.min.js"></script>			
			<script src="recruit/js/parallax.min.js"></script>		
			<script src="recruit/js/mail-script.js"></script>	
			<script src="recruit/js/main.js"></script>	
		</body>
	</html>



