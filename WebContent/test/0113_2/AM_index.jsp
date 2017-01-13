<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Getting Started</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="assets/css/weihan_googlemap.css">
    <link rel="stylesheet" href="assets/css/weihan_login_form.css">
    <link rel="stylesheet" href="assets/css/weihan_main.css">
    <link rel="stylesheet" href="assets/css/weihan_nav.css">
</head>

<body>
    <div id="TOP" style="padding:0;">
        <nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">選單切換</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">CSS可樂</a>
    </div>

    <!-- 手機隱藏選單區 -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <!-- 左選單 -->
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">關於CSS可樂</a></li>
            <li><a href="#">CSS教學</a></li>
            <li><a href="#">CSS範例</a></li>
            <li><a href="#">原創CSS</a></li>
        </ul>

        <!-- 搜尋表單 -->
        <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="請輸入條件">
            </div>
            <button type="submit" class="btn btn-default">篩選</button>
        </form>

        <!-- 右選單 -->
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Amos 您好</a></li>
            <li><a href="#">登出</a></li>
            <li><a href="#">個人設定</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">繁體中文 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">繁體中文</a></li>
                    <li><a href="#">English</a></li>
                    <li><a href="#">日本語</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- 手機隱藏選單區結束 -->
</nav>
    </div>
    <div id="MIDDLE">
        <div class="col-md-4 hidden-xs hidden-sm" id="AM_aside">
    <div id="AM_login">
        <div class="login-clean">
            <form method="post">
                <h2 class="sr-only">Login Form</h2>
                <div class="illustration">
                    <i class="icon ion-ios-navigate"></i>
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="Email" />
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="Password" />
                </div>
                <div class="form-group">
                    <!-- type="submit"有甚麼改進方法? -->
                    <button class="btn btn-primary btn-block" type="submit">登入</button>
                </div>
                <a href="#" class="forgot">忘記密碼?</a>
            </form>
        </div>
    </div>
</div>
        <div class="col-md-8" data-aos="fade-up" id="AM_section">
    <div id="AM_bookmark" class="btn-group-vertical hidden-xs hidden-sm">
        <button type="button" id="AM_Mem" class="btn btn-default am_bookmark">會員中心</button>
        <button type="button" id="AM_Friend" class="btn btn-primary am_bookmark">朋友</button>
        <button type="button" id="AM_MapInfo" class="btn btn-success am_bookmark">地圖資訊</button>
        <!--    <button type="button" class="btn btn-info am_bookmark">參加的活動</button> -->
        <!--    <button type="button" class="btn btn-warning am_bookmark">店家管理</button> -->
        <!--         <button type="button" class="btn btn-danger">Danger</button> -->
        <!--         <button type="button" class="btn btn-link">Link</button> -->
    </div>
    <div id="AM_map_menu" class="btn-group btn-group-sm" role="group">
        <button type="button" class="btn btn-warning">商城 </button>
        <button type="button" id="AM_MapInfo" class="btn btn-success">動物圖鑑</button>
        <button type="button" id="AM_Friend" class="btn btn-primary">討論版</button>
        <a href="#" class="btn btn-danger btn-lg">
            <span class="glyphicon glyphicon-ok-circle"></span> 發文
        </a>
    </div>
    <div id="AM_issue" class="btn-group-vertical btn-group-sm">
        <div style="height:40px;"></div>
    </div>
    <div id="AM_google_Map">
        <!-- 面機算法 -->
        <div id="map-polygon-01"></div>
    </div>
</div>
    </div>
    <div id="BUTTON">
        <div>
    <div class="col-md-12" id="AM_footer">
        <div class="col-md-12" id="AM_footer_content">
            <p>
                <b>第川組 最棒棒。出品</b>
                <a> 動物地圖 © 2016</a>
            </p>
        </div>
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </div>
</div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="assets/js/jquery.tinyMap.min.js"></script>
    <script src="assets/js/weihan_googlemap.js"></script>
    <script src="assets/js/weihan_main.js"></script>
</body>

</html>