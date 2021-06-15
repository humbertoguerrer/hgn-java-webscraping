package com.hgn.hgnjavawebscraping.services;

import com.hgn.hgnjavawebscraping.entities.News;
import com.hgn.hgnjavawebscraping.repositories.NewsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> listAllNews() {
        return newsRepository.findAll();
    }

    public News listById(Integer id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        News news = optionalNews.get();
        return news;
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public News convertNews(String url) throws IOException, ParseException {

        Document doc = Jsoup.connect(url).get();
        News news = new News();
        news.setUrl(url);
        news.setTitle(doc.getElementsByClass("page-title-1").first().text());
        news.setSubtitle(doc.getElementsByClass("article-lead").first().text());
        news.setAuthor(doc.getElementsByClass("author-name").first().text());

        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                .format(new SimpleDateFormat("dd MMM yyyy HH'h'mm")
                        .parse(doc.getElementsByTag("time").first().text()));

        news.setDate(date);

        Element content = doc.getElementsByClass("col-md-9 col-lg-8 col-xl-6  m-sm-auto m-lg-0 article-content")
                .first();
        String text = doc.getElementsByTag("p").text();

        news.setContent(text);

        return newsRepository.save(news);
    }

    public List<News> listByWords(String keyword) {
        return newsRepository.findByContentContains(keyword)
                .stream().collect(Collectors.toList());
    }

}