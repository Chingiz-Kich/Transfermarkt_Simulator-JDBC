package com.company.repositories;

import com.company.repositories.interfaces.IPlayerRepo;
import com.company.entities.*;
import com.company.data.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/* This class contains all methods associated with the "player" table in the database */


public class PlayerRepo implements IPlayerRepo {
    private final IDB db;

    public PlayerRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTeamPlayer(Player player) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO player(name, surname, nationality, age, position, price, available, team) VALUES(?,?,?,18,?,0,false,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, player.getName());
            st.setString(2, player.getSurname());
            st.setString(3, player.getNationality());
            st.setString(4, player.getPosition());
            st.setString(5, player.getTeam());
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

    @Override
    public boolean createFreePlayer(Player player) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO player(name, surname, nationality, age, position, price, available, team) VALUES(?,?,?,18,?,0,true,'null')";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, player.getName());
            st.setString(2, player.getSurname());
            st.setString(3, player.getNationality());
            st.setString(4, player.getPosition());
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

    @Override
    public Player getInfoPlayer(String surname) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT name,surname,nationality,age,position,price,available,team FROM player WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            Player player = new Player();
            if (rs.next()) {
                player.setName(rs.getString("name"));
                player.setSurname(rs.getString("surname"));
                player.setNationality(rs.getString("nationality"));
                player.setAge(rs.getInt("age"));
                player.setPosition(rs.getString("position"));
                player.setPrice( rs.getInt("price"));
                player.setAvailable(rs.getBoolean("available"));
                player.setTeam(rs.getString("team"));
            }
            return player;

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
    public boolean updateToCoach(String surname) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql1 = "SELECT name,surname,nationality,age,team FROM player WHERE surname=?";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setString(1, surname);
            ResultSet rs = st1.executeQuery();
            Player upPlayer = new Player();
            while(rs.next()) {
                upPlayer.setName(rs.getString("name"));
                upPlayer.setSurname(rs.getString("surname"));
                upPlayer.setNationality(rs.getString("nationality"));
                upPlayer.setAge(rs.getInt("age"));
                upPlayer.setTeam(rs.getString("team"));
            }

            String sql2 = "DELETE FROM player WHERE surname=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setString(1, surname);
            st2.execute();

            String sql3 = "DELETE FROM coach WHERE team=?";
            PreparedStatement st3 = con.prepareStatement(sql3);
            st3.setString(1, upPlayer.getTeam());
            st3.execute();

            String sql4 = "INSERT INTO coach(name,surname,nationality,age,license,team) VALUES (?,?,?,?,3,null)";
            PreparedStatement st4 = con.prepareStatement(sql4);
            st4.setString(1, upPlayer.getName());
            st4.setString(2, upPlayer.getSurname());
            st4.setString(3, upPlayer.getNationality());
            st4.setInt(4, upPlayer.getAge());
            st4.execute();

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
    public boolean endCareer(String surname) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "DELETE FROM player WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
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

    @Override
    public boolean getAvailable(String surname) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT available FROM player WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            boolean available = false;
            while(rs.next()) {
                available = rs.getBoolean("available");
            }
            return available;
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
    public boolean setAvailable(String surname, boolean available) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "UPDATE player SET available=? WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setBoolean(1, available);
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
    public boolean setPrice(String surname, int price) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "UPDATE player SET price=? WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, price);
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
    public int getPrice(String surname) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT price FROM player WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            int save = 0;
            while(rs.next()) {
                save = rs.getInt("price");
            }
            return save;
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
    public List<Player> getAllPlayers(String team) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT name,surname FROM player WHERE team=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, team);
            ResultSet rs = st.executeQuery();
            List<Player> players = new LinkedList<>();
            while(rs.next()) {
                Player player = new Player(rs.getString("name"),
                                            rs.getString("surname"));
                players.add(player);
            }
            return players;

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
    public String getTeam(String surname) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT team FROM player WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            String teamName = "";
            while(rs.next()) {
                teamName = rs .getString("team");
            }
            if (teamName == "null") { return surname + " is Free Agent"; }
            return teamName;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Team does not exist!";
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
            String sql = "UPDATE player SET team=? WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,team);
            st.setString(2,surname);
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

    @Override
    public int getAge(String surname) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT age FROM player WHERE surname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, surname);
            ResultSet rs = st.executeQuery();
            int age = 0;
            while(rs.next()) {
                age = rs.getInt("age");
            }
            return age;
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
}




