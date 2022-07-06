package fr.afpa.courses.dal;

import fr.afpa.courses.bo.Article;
import fr.afpa.courses.bo.ListeCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleSQL {
    private static final String INSERT_ARTICLE = "insert into ARTICLES(nom, id_liste) values(?,?);";
    private static final String DELETE_ARTICLE = "delete from ARTICLES where id=?";
    private static final String UPDATE_COCHE_ARTICLE = "update ARTICLES set coche=1 where id=?";
    private static final String UPDATE_DECOCHE_ARTICLE = "update ARTICLES set coche=0 where id=?";
    private static final String UPDATE_DECOCHE_ARTICLES = "update ARTICLES set coche=0 where id_liste=?";

    public void insert(Article article, int id) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                pstmt = cnx.prepareStatement(INSERT_ARTICLE);
                pstmt.setString(1, article.getNom());
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                pstmt.close();
                cnx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                cnx.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteArticle(int idArticle) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE_ARTICLE);
            pstmt.setInt(1, idArticle);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void cocherArticle(int idArticle) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE_COCHE_ARTICLE);
            pstmt.setInt(1, idArticle);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void decocherArticle(int idArticle) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE_DECOCHE_ARTICLE);
            pstmt.setInt(1, idArticle);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void decocherListeCourse(int idListeCourse) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE_DECOCHE_ARTICLES);
            pstmt.setInt(1, idListeCourse);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
