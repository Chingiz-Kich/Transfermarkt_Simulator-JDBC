package com.company.repositories;

import com.company.repositories.interfaces.IClubRepo;
import com.company.data.*;
import com.company.entities.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/* This class contains all methods associated with the "club" table in the database */


public class ClubRepo implements IClubRepo {
    private final IDB db;

    public ClubRepo(IDB db) {
        this.db = db;
    }

    @Override
    public Club infoAboutClub(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM club WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            Club club = new Club();
            while(rs.next()) {
                club.setName(rs.getString("name"));
                club.setCountry(rs.getString("country"));
                club.setLeague(rs.getString("league"));
                club.setBudget(rs.getInt("budget"));
            }
            return club;

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
    public boolean updateBudget(String name, int budget) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE club SET budget=? WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, budget);
            st.setString(2, name);
            st.executeUpdate();
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

    @Override
    public int getBudget(String name) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT budget FROM club WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            int budget = -1;
            while (rs.next()) {
                budget = rs.getInt("budget");
            }
            return budget;
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
    public int getClubByPlayersPrice(String name) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT SUM(price) AS x FROM player WHERE team=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            int sum = 0;
            if (rs.next()) {
                sum = rs.getInt("x");
            }
            return sum;
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
    public int getLevel(String name) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT level FROM club WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            int level = 0;
            while (rs.next()) {
                level = rs.getInt("level");
            }
            return level;
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
    public List<Club> getAllClubs() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT name FROM club";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Club> clubs = new LinkedList<>();
            while (rs.next()) {
                Club club = new Club(rs.getString("name"));
                clubs.add(club);
            }
            return clubs;
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
}
