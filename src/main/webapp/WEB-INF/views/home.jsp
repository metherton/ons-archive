<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%@ taglib prefix="rssNewsFeedItems" uri="rssNewsFeedItems" %>
<div style="width: 54%;float: left;">
    <div class="innercontentleft">
        <div class="innercontentleftheader">On this day</div>
        <div class="innercontentleftbody">There are no significant events yet in our database for this day</div>
    </div>
</div>
<div style="width:0.3%;float: left">&nbsp;</div>
<div style="width: 45.7%;float: left;">
    <div class="innercontentright">
        <div class="innercontentrightheader">In the news</div>
        <div class="innercontentrightbody">
        <rssNewsFeedItems:newsItem newsReader="${newsReader}">
        <div style="margin-top: 0.5em;border: 0.1em #CEDFF2 solid;">
          <div style="padding-left: 0.5em; padding-top: 0.5em;font-size: 0.9em">${newsItem.title}</div>
          <div style="padding-left: 1em; padding-top: 0.2em; font-size:0.7em;color:dimgray">${newsItem.date}</div>
          <div style="padding-left: 0.5em; padding-top: 0.5em;">${newsItem.description}</div>
        </div>
        </rssNewsFeedItems:newsItem>        
        </div>
    </div>
</div>
<div style="clear:both;"></div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
