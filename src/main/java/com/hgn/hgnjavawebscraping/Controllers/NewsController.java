package com.hgn.hgnjavawebscraping.Controllers;

import com.hgn.hgnjavawebscraping.Entities.News;
import com.hgn.hgnjavawebscraping.Services.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> listAllNews() {
        return newsService.listAllNews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listById(@PathVariable Integer id) {
        News news = newsService.listById(id);
        return ResponseEntity.ok().body(news);

    }

    @GetMapping("/filter")
    public List<News> listByWords(@RequestParam("keyword") String keyword) {
        return newsService.listByWords(keyword);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public News save(@RequestBody String url) throws IOException, ParseException {
        return newsService.convertNews(url);
    }
}
