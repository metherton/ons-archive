package com.ethertons.common;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.junit.Test;

import com.ethertons.domain.ImmediateFamily;
import com.ethertons.domain.Person;
import com.google.common.collect.Lists;

public class RssFeedTagTest {

    @Test
    public void rssFeedShouldHaveContent() throws JspException, IOException {
        
        RssFeedTag rssFeedTag = new RssFeedTag();

        NewsReader newsReader = createMock(NewsReader.class);
        rssFeedTag.setNewsReader(newsReader);
        
        NewsItem newsItem1 = new NewsItem("title1", "description1", "date1");
        NewsItem newsItem2 = new NewsItem("title2", "description2", "date2");

        List<NewsItem> newsItems = Lists.newArrayList();
        newsItems.add(newsItem1);
        newsItems.add(newsItem2);

        expect(newsReader.getItems()).andReturn(newsItems);        
        
        JspContext jspContext = createMock(JspContext.class);
        jspContext.setAttribute("newsItem", newsItem1);
        jspContext.setAttribute("newsItem",newsItem2);
        rssFeedTag.setJspContext(jspContext);
        JspFragment jspBodyFragment =  createMock(JspFragment.class);
        jspBodyFragment.invoke(null);
        expectLastCall().times(2);
        rssFeedTag.setJspBody(jspBodyFragment);

        replay(jspBodyFragment, jspContext, newsReader);
        rssFeedTag.doTag();
        verify(jspBodyFragment, jspContext, newsReader);        
        
        
    }
    
}
