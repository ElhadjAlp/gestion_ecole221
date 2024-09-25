package com.ism.data.repository.bd;

import java.util.List;
import java.util.ArrayList;

import com.ism.core.Repository.impl.RepositoryBDImpl;
import com.ism.data.entites.Medecin;
import com.ism.data.repository.RvRepository;

import java.sql.*;


public class RvRepositoryBD extends RepositoryBDImpl<Medecin> implements RvRepository {

    public RvRepositoryBD(){
        this.tableName = "rv";
    }
    @Override
    public Medecin selectByLogin(String login) {
        Medecin result = null;

        try {
            String sql = String.format("select * from %s where login like ?",this.tableName);
            this.getConnection();
            this.initPreparedStatement(sql);

            this.ps.setString(1, login);
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                result = this.convertToObject(rs);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void insert(Medecin data) {

        try {

            String sql = "INSERT INTO `rv` ( `id`,`nom`, `prenom`) VALUES (?,?,? '1');";
            this.getConnection();
            this.initPreparedStatement(sql);
            this.ps.setInt(1, data.getId());
            this.ps.setString(2, data.getNom());
            this.ps.setString(3, data.getPrenom());
            this.executeUpdate();
            ResultSet rs = this.ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                this.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public List<Medecin> selectAll() {
        List<Medecin> medecins = new ArrayList<Medecin>();
        try {

            String sql = "select * from user";
            this.getConnection();
            this.initPreparedStatement(sql);

            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                medecins.add(this.convertToObject(rs));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return medecins;
    }

    @Override
    public Medecin convertToObject(ResultSet rs) throws SQLException {
        Medecin rv = new Medecin();
        rv.setId(rs.getInt("id"));
        rv.setDate(rs.getString("date"));
        rv.setHeure(rs.getString("heure"));
        return rv;
        

    }

    @Override
    public Medecin selectByID(int id) {
        Medecin result = null;
 
        try {
            String sql = "select * from user where id= ?";
            this.getConnection();
            this.initPreparedStatement(sql);
            this.ps.setInt(1, id);
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                result = this.convertToObject(rs);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}