package fr.afpa.courses.dal;

import fr.afpa.courses.bo.Article;
import fr.afpa.courses.bo.ListeCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListeSQL {
    private static final String SELECT_ALL = "SELECT id, nom FROM LISTES";
    private static final String SELECT_BY_ID = "select " +
            "	l.id as id_liste, " +
            "	l.nom as nom_liste, " +
            "	a.id as id_article, " +
            "	a.nom as nom_article, " +
            "	a.coche " +
            "from " +
            "	listes l " +
            "	left join articles a on l.id=a.id_liste " +
            "where l.id=?";
    private static final String INSERT_LISTE = "insert into LISTES(nom) values(?);";
    private static final String DELETE_LISTE = "delete from LISTES where id=?";

    public void insert(ListeCourse listeCourse) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            try {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                pstmt = cnx.prepareStatement(INSERT_LISTE, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, listeCourse.getNom());
                pstmt.executeUpdate();
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    listeCourse.setId(rs.getInt(1));
                }
                rs.close();
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

    public void delete(int id) {
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE_LISTE);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ListeCourse> selectAll() {
        List<ListeCourse> listesCourse = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listesCourse.add(new ListeCourse(rs.getInt("id"), rs.getString("nom")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listesCourse;
    }

    public ListeCourse selectById(int id) {
        ListeCourse listeCourse = new ListeCourse();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne = true;
            while (rs.next()) {
                if (premiereLigne) {
                    listeCourse.setId(rs.getInt("id_liste"));
                    listeCourse.setNom(rs.getString("nom_liste"));
                    premiereLigne = false;
                }
                if (rs.getString("nom_article") != null) {
                    listeCourse.getArticles().add(new Article(rs.getInt("id_article"), rs.getString("nom_article"), rs.getBoolean("coche")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeCourse;
    }
}
