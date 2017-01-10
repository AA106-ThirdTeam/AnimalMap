<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-default" role="navigation" style="padding: 0px;">
    <!-- logo區 -->
    <a class="navbar-brand" href="#"><img class="img-circle" src="https://i.imgur.com/qztHSNn.png" width="40" height="40"></a>
    <!-- 左選單 -->
    <ul class="nav navbar-nav">
        <li class="active"><a href="#">關於CSS可樂</a></li>
        <li><a href="#">CSS教學</a></li>
        <li><a href="#">CSS範例</a></li>
        <li><a href="#">原創CSS</a></li>
    </ul>

    <!-- 搜尋表單 -->
    <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="請輸入關鍵字">
        </div>
        <button type="submit" class="btn btn-default">搜尋</button>
    </form>

    <!-- 右選單 -->
    <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Amos 您好</a></li>
        <li><a href="#">登出</a></li>
        <li><a href="#">個人設定</a></li>
        <!-- 下拉選單 -->
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">繁體中文 <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#">繁體中文</a></li>
                <li><a href="#">English</a></li>
                <li><a href="#">日本語</a></li>
            </ul>
        </li>
    </ul>
</nav>