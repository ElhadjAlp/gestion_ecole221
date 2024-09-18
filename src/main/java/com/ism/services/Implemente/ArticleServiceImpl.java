package com.ism.services.Implemente;

import java.util.List;

import com.ism.entites.Article;
import com.ism.repository.List.ArticleRepository;

public class ArticleServiceImpl {
    private ArticleRepository articleRepository = new ArticleRepository(); 


    public List<Article> findAll() {
        return articleRepository.selectAll(); 
    }

    public void create(Article article) {
        articleRepository.insert(article);  
    }
}

