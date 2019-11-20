<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <!-- head -->
    <head>
        <title>Little Closet</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Little Closet template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/bootstrap-4.1.2/bootstrap.min.css"></c:url>">
        <link href="<c:url value="/resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css"></c:url>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css"></c:url>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/plugins/OwlCarousel2-2.2.1/animate.css"></c:url>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/main_styles.css"></c:url>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/responsive.css"></c:url>">
        </head>
        <body>
            <!-- Mobile Menu -->
        <jsp:include page="./include/mobile-menu.jsp"/>

        <div class="super_container">

            <!-- Header -->
            <jsp:include page="./include/header.jsp"/>

            <div class="super_container_inner">
                <div class="super_overlay"></div>		

                <!-- Products -->

                <div class="products">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 offset-lg-3">
                                <div class="section_title text-center">Newest on Little Closet</div>
                            </div>
                        </div>
                        <c:if test="${param.action != null}">
                            <div class="row">
                                <div class="col-xl-12 col-md-12">                                
                                    <div class="dropdown float-right">
                                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Sort by
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&sort=Latest"/>">Latest</a>
                                            <a class="dropdown-item" href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&sort=Oldest"/>">Oldest</a>
                                            <a class="dropdown-item" href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&sort=HightoLow"/>">Price: High to Low</a>
                                            <a class="dropdown-item" href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&sort=LowtoHigh"/>">Price: Low to High</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row products_row">
                            <c:if test="${products.size()==0}">
                                <div class="col-md-12" style="text-align: center">
                                    <h3>We couldn't find any matches!</h3>
                                </div>

                            </c:if>
                            <c:forEach var="product" items="${products}">
                                <!-- Product -->
                                <div class="col-xl-4 col-md-6">
                                    <div class="product">
                                        <div class="product_image"><a href="<c:url value="/product?id=${product.id}"></c:url>"><img src="${product.images[0].url}" alt=""></a></div>
                                            <div class="product_content">
                                                <div class="product_info d-flex flex-row align-items-start justify-content-start">
                                                    <div>
                                                        <div>
                                                            <div class="product_name"><a href="<c:url value="/product?id=${product.id}"></c:url>">${product.name}</a></div>
                                                        <div class="product_category">In <a href="<c:url value="/category?id=${product.category.id}&page=1"></c:url>">${product.category.name}</a></div>
                                                        </div>
                                                    </div>
                                                    <div class="ml-auto text-right">
                                                        <div class="rating_r"><i class="fa fa-heart fa-1x" style="color: #ff66a3" aria-hidden="true"></i> ${product.totalFavorite}</div>
                                                    <div class="product_price text-right">$${product.price}</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>                               


                        </div>
                        <div class="row page_nav_row">
                            <div class="col">
                                <div class="page_nav">
                                    <ul class="d-flex flex-row align-items-start justify-content-center">
                                        <c:forEach begin="1" end="${page}" varStatus="status">
                                            <c:if test="${param.action == null}">
                                                <c:choose>
                                                    <c:when test="${param.page==null && status.index==1}">
                                                        <li class="active"><a href="<c:url value="/?page=${status.index}"/>">${status.index}</a></li>
                                                        </c:when>
                                                        <c:when test="${param.page==null && status.index!=1}">
                                                        <li><a href="<c:url value="/?page=${status.index}"/>">${status.index}</a></li>
                                                        </c:when>
                                                        <c:when test="${param.page!=null && param.page==status.index}">
                                                        <li class="active"><a href="<c:url value="/?page=${status.index}"/>">${status.index}</a></li>
                                                        </c:when>                                                   
                                                        <c:otherwise>
                                                        <li><a href="<c:url value="/?page=${status.index}"/>">${status.index}</a></li>
                                                        </c:otherwise>
                                                    </c:choose>      
                                                </c:if>
                                                <c:if test="${param.action != null}">
                                                <c:choose>
                                                    <c:when test="${param.page==null && status.index==1}">
                                                        <li class="active"><a href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&page=${status.index}&sort=${param.sort}"/>">${status.index}</a></li>
                                                        </c:when>
                                                        <c:when test="${param.page==null && status.index!=1}">
                                                        <li><a href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&page=${status.index}&sort=${param.sort}"/>">${status.index}</a></li>
                                                        </c:when>
                                                        <c:when test="${param.page!=null && param.page==status.index}">
                                                        <li class="active"><a href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&page=${status.index}&sort=${param.sort}"/>">${status.index}</a></li>
                                                        </c:when>                                                   
                                                        <c:otherwise>
                                                        <li><a href="<c:url value="/search?action=searchProduct&searchText=${param.searchText}&page=${status.index}&sort=${param.sort}"/>">${status.index}</a></li>
                                                        </c:otherwise>
                                                    </c:choose>  
                                            </c:if>                        
                                        </c:forEach>                                        
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>		

            </div>
        </div>


        <!-- Footer -->
        <jsp:include page="./include/footer.jsp"/>

        <!-- script -->
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/styles/bootstrap-4.1.2/popper.js"></c:url>"></script>
        <script src="<c:url value="/resources/styles/bootstrap-4.1.2/bootstrap.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/greensock/TweenMax.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/greensock/TimelineMax.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/scrollmagic/ScrollMagic.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/greensock/animation.gsap.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/greensock/ScrollToPlugin.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/easing/easing.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/progressbar/progressbar.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/plugins/parallax-js-master/parallax.min.js"></c:url>"></script>
        <script src="<c:url value="/resources/js/custom.js"></c:url>"></script>  
        <script src="<c:url value="/resources/js/product-script-custom.js"></c:url>"></script>  
    </body>
</html>