package com.hgn.hgnjavawebscraping.Services;

import com.hgn.hgnjavawebscraping.Entities.News;
import com.hgn.hgnjavawebscraping.Repositories.NewsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NewsService {

  @Autowired private NewsRepository newsRepository;

  public News save(News news) {
    return newsRepository.save(news);
  }

  public News convertNews(String url) throws IOException {

    String newUrl = "";
    if (url.startsWith("http://")) {
      newUrl = url;
    }

    if (url.startsWith("www")) {
      newUrl = "http://" + url;
    }

    Document doc = Jsoup.connect(url).get();
    News news = new News();
    //    news.setUrl(url);
    //    news.setTitle(doc.getElementsByClass("page-title-1").first().text());
    //    news.setSubtitle(doc.getElementsByClass("article-lead").first().text());
    //    news.setAuthor(doc.getElementsByClass("author-name").first().text());
    //    news.setContent(doc.getElementsByTag("p").first().text());

    return newsRepository.save(news);
  }
}
