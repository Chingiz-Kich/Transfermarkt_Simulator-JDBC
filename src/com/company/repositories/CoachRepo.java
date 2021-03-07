package com.company.repositories;

import java.sql.*;
import java.util.*;

import com.company.data.IDB;
import com.company.entities.Coach;
import com.company.repositories.interfaces.ICoachRepo;


/* This class contains all methods associated with the "coach" table in the database */


public class CoachRepo implements ICoachRepo {
    private final IDB db;

    public CoachRepo(IDB db) {
        this.db = db;
    }

    @Override
    public List<Coach> getAllCoaches() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name,surname FROM coach";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Coach> coaches = new LinkedList<>();
            while(rs.next()) {
                Coach coach = new Coach(rs.getString("name"),
                        rs.getString("surname"));
                coaches.add(coach);
            }
            return coaches;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Coach getInfoCoach(String surname) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT name,surname,nationality,age,license,team FROM coach WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            Coach coach = new Coach();
            if (rs.next()) {
                coach.setName(rs.getString("name"));
                coach.setSurname(rs.getString("surname"));
                coach.setNationality(rs.getString("nationality"));
                coach.setAge(rs.getInt("age"));
                coach.setLicense(rs.getInt("license"));
                coach.setTeam(rs.getString("team"));
            }
            return coach;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getLicense(String surname) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT license FROM coach WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            int license = 0;
            while(rs.next()) {
                license = rs.getInt("license");
            }
            return license;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean setLicense(String surname, int license) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "UPDATE coach SET license=? WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, license);
            st.setString(2, surname);
            return st.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getTeam(String surname) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT team FROM coach WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            String team = rs.getString("team");
            return team;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "'CLUB DOES NOT EXIST!'";
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean setTeam(String surname, String team) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE coach SET team=? WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, team);
            st.setString(2, surname);
            st.execute();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*@Override
    public boolean teamHasCoach(String team) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT surname FROM coach WHERE team=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, team);
            ResultSet rs = st.executeQuery();
            String currentCoach = "";
            while(rs.next()) {
                currentCoach = rs.getString("surname");
            }
            sackingCoach(team);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } */

    @Override
    public int sackingCoach(String team) {
        Connection con = null;
        try {
            con = db.getConnection();
            /*String sql2 = "SELECT surname FROM coach WHERE team=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setString(1, team);
            ResultSet rs = st2.executeQuery();
            String check = "";
            while (rs.next()) {
                check = rs.getString("team");
            }
            if (check == "null") { return true; } */

            String sql = "UPDATE coach SET team='Free Agent' WHERE team=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, team);
            return st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
