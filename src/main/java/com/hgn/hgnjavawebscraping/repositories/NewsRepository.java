package com.hgn.hgnjavawebscraping.repositories;

import com.hgn.hgnjavawebscraping.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    List<News> findByContentContains(String keyword);

}
