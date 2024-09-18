package com.ism.repository.List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ism.entites.Article;

public class ArticleRepository {

    private List<Article> articles = new ArrayList<>();

    public void insert(Article article) {
        articles.add(article);
    }
    public List<Article> selectAll() {
            return articles.stream()
                    .filter(article -> article.getQteStock() > 0)
                    .collect(Collectors.toList());
        
    }
    public boolean mettreAJourStockArticle(String nomArticle, int nouvelleQuantite) {
        for (Article article : articles) {
            if (article.getNom().equals(nomArticle)) {
                article.setQteStock(nouvelleQuantite);
                return true;
            }
        }
        return false;
    }
}