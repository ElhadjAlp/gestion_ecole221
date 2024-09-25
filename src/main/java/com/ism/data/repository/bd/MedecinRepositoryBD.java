package com.ism.data.repository.bd;

import java.util.List;
import java.util.ArrayList;

import com.ism.core.Repository.impl.RepositoryBDImpl;
import com.ism.data.entites.Medecin;
import com.ism.data.repository.MedecinRepository;
import com.ism.data.repository.RvRepository;

import java.sql.*;


public class MedecinRepositoryBD extends RepositoryBDImpl<Medecin> implements MedecinRepository {
    RvRepository userRepository;
    private Object MedecinRepository;

    public MedecinRepositoryBD(RvRepository rvRepository) {
        this.tableName = "medecin";
        Object medecinRepository;
        this.MedecinRepository = null;
    }

    @Override
    public Medecin selectByDate(String date) {
        Medecin medecin = null;

        try {
            String sql = String.format("select * from %s where date like ?", this.tableName);
            this.getConnection();
            this.initPreparedStatement(sql);

            this.ps.setString(1, date);

            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                medecin = this.convertToObject(rs);
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
        return medecin;
    }

    @Override
    public Medecin selectByNom(String surname) {
        return null;
    }

    @Override
    public void insert(Medecin data) {

        Medecin user = data.getMedecin();
        try {
            if (user != null) {
                userRepository.insert(user);
            }

            String sql = String.format("INSERT INTO  %s (`surname`, `telephone`, `adresse`,user_id) VALUES (?,?,?,?)",
                    this.tableName);
            this.getConnection();
            this.initPreparedStatement(sql);
            this.ps.setInt(1, data.getId());
            this.ps.setString(2, data.getNom());
            this.ps.setString(3, data.getPrenom());
            if (user != null) {
                this.ps.setInt(4, user.getId());
            } else {
                this.ps.setNull(4, Types.INTEGER);
            }
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
        List<Medecin> clients = new ArrayList<>();

        try {
            String sql = String.format("select * from %s", this.tableName);
            this.getConnection();
            this.initPreparedStatement(sql);

            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                clients.add(this.convertToObject(rs));
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
        return clients;
    }

    @Override
    public Medecin convertToObject(ResultSet rs) throws SQLException {
        Medecin Medecin = new Medecin();
        Medecin.setId(rs.getInt("id"));
        Medecin.setNom(rs.getString("nom"));
        Medecin.setPrenom(rs.getString("prenom"));
      

        int userId = rs.getInt("user_id");

            Medecin rv = this.userRepository.selectByID(userId);
            Medecin.setMedecin(Medecin );

        return Medecin;

    }
}
