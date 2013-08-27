package com.ethertons.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RssFeedTag  extends SimpleTagSupport {
    
    private NewsReader newsReader;
    
    public void doTag() throws IOException, JspException {
        if (newsReader != null) {
            List<NewsItem> items = newsReader.getItems();
            for (NewsItem newsItem : items) {
                getJspContext().setAttribute("newsItem", newsItem);
                getJspBody().invoke(null);        
            }            
        }
    }

    public NewsReader getNewsReader() {
        return newsReader;
    }

    public void setNewsReader(NewsReader newsReader) {
        this.newsReader = newsReader;
    }    

}
