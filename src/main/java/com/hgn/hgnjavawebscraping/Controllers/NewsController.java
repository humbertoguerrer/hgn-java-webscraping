package com.hgn.hgnjavawebscraping.Controllers;

import com.hgn.hgnjavawebscraping.Entities.News;
import com.hgn.hgnjavawebscraping.Services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/news")
public class NewsController {

  @Autowired private NewsService newsService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public News save(@RequestBody String url) throws IOException {
    return newsService.convertNews(url);
  }
}
