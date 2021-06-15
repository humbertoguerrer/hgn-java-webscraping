package com.hgn.hgnjavawebscraping.controllers;

import com.hgn.hgnjavawebscraping.entities.News;
import com.hgn.hgnjavawebscraping.services.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "News")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    @ApiOperation(value = "Return all registered news.")
    public List<News> listAllNews() {
        return newsService.listAllNews();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns the registered news corresponding to the informed ID.")
    public ResponseEntity<?> listById(@PathVariable Integer id) {
        News news = newsService.listById(id);
        return ResponseEntity.ok().body(news);

    }

    @GetMapping("/filter")
    @ApiOperation(value = "Returns all registered news that contain the entered keyword.")
    public List<News> listByWords(@RequestParam("keyword") String keyword) {
        return newsService.listByWords(keyword);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Register a new news through the informed URL.")
    public News save(@RequestBody String url) throws IOException, ParseException {
        return newsService.convertNews(url);
    }
}
