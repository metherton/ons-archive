<%@ include file="/WEB-INF/views/includes.jsp" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet"  href="<c:url value="/resources/main.css" />" type="text/css" >
        <title>Etherton One Name Study - A worldwide study of the Etherton surname</title>
    </head>
    <body style="background-color:ghostwhite;margin:0">
        <div id="container" style="width:100%">
            <div id="menu" style="background-color:ghostwhite;height:259px;width:11%;float:left;">
                <div style="margin: 0px auto;text-align: center">
                    <a title="Visit Guild of one name studies" href="http://www.goons.org.uk">
                        <img border="0" align="center" width="116" height="139" src="resources/logo-ghost.png" />
                    </a>
                </div>
                <ul style="list-style:none;">
                    <li><a href="/trees">Trees</a></li>
                    <li><a href="/persons">People</a></li>
                    <li><a href="/surnames">Surnames</a></li>
                </ul>
            </div>
            <div id="header" style="width:89%;background-color:white;;float:left;">
                <div style="padding:1%;">
                    <div id="welcomeWrapper">
                        <div id="welcomeBox">
                            <div id="welcome">Welcome to the Etherton One Name Study</div>
                            <div id="welcome-small">a worldwide study of the evolution of the Etherton surname</div>
                            <div id="welcome-small">over 5000 Ethertons on file</div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="content" style="background-color:#EEEEEE;height:200px;width:89%;float:left;">
                <div style="margin: 0px auto;width:98%;background-color: red">
                    <div style="width: 50%;background-color: yellow;height:100px;float: left;"></div>
                    <div style="width: 50%;background-color: green;height:100px; float: left;"></div>
                </div>
            </div>
            <div id="footer" style="background-color:ghostwhite;clear:both;text-align:center;">
                <p id="website-author">Site is maintained by ${webmaster}</p>
            </div>
        </div>
    </body>
</html>

