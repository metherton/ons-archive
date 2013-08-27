package com.ethertons.common;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;


public class NewsReader {
    
    List<NewsItem> items = Lists.newArrayList();
    
    public NewsReader() throws IllegalArgumentException, IOException, FeedException {

        readItems();

    }

    private void readItems() throws IOException, IllegalArgumentException, FeedException {
        URL url  = new URL("https://news.google.com/news/feeds?hl=en&gl=us&q=etherton&um=1&ie=UTF-8&output=rss");
        XmlReader reader = null;
         
        try {
//            if (url.)
            reader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(reader);
            for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
                SyndEntry entry = (SyndEntry) i.next();
                NewsItem newsItem = new NewsItem(entry.getTitle(), entry.getDescription().getValue(), entry.getPublishedDate().toString());
                items.add(newsItem);
            }
         } finally {
                if (reader != null)
                    reader.close();
         }
        
    }

    public List<NewsItem> getItems() {
        // TODO Auto-generated method stub
        return items.subList(0, 3);
    }

}
