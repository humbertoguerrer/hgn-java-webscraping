package com.hgn.hgnjavawebscraping.Controllers;

import com.hgn.hgnjavawebscraping.Entities.News;
import com.hgn.hgnjavawebscraping.Services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<News> listAllNews() {
        return newsService.listAllNews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listById(@PathVariable Integer id) {
        News news = newsService.listById(id);
        return ResponseEntity.ok().body(news);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public News save(@RequestBody String url) throws IOException, ParseException {
        return newsService.convertNews(url);
    }
}
