package com.hgn.hgnjavawebscraping.Repositories;

import com.hgn.hgnjavawebscraping.Entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
}
