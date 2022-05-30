import Cell.Cell;
import character.heroes.Hero;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import equipement.defence.Defence;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

/**
 * this class contains all the functions and attributes we need to connect to a database
 */
public class DataBase {
    private Connection connection;

    public void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DnD", "MikaCocchi", "Gnocchiofromage987111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hero> getHeroInfos() {
        List<Hero> heroes = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;

        connectDatabase();
        Hero hero;
        try {
            statement = connection.createStatement();


            result = statement.executeQuery("SELECT * FROM Characters;");

            while (result.next()) {
                String name = result.getString("name");
                String type = result.getString("type");
                String defenceItem = result.getString("leftHand");
                try {
                    Class<?> classType = Class.forName("character.heroes." + type);
                    hero = (Hero) classType.getDeclaredConstructor().newInstance();
                    hero.setName(name);
                    hero.setStrength((result.getInt("strength")));
                    hero.setHeal(result.getInt("heal"));
                    Class<?> classDefenceItem = Class.forName("equipement.defence." + defenceItem);
                    hero.setLeftHand((Defence) classDefenceItem.getDeclaredConstructor().newInstance());
                    heroes.add(hero);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
            }
        }
        return heroes;
    }

    public void saveCreatedHero(Hero player) {
        connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Characters(name, type , heal , strength, leftHand, board) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getClass().getSimpleName());
            preparedStatement.setInt(3, player.getHeal());
            preparedStatement.setInt(4, player.getStrength());
            preparedStatement.setString(5, player.getLeftHand().getClass().getSimpleName());
            preparedStatement.setString(6, "default board value =)");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveHeroCurrentStats(Hero player) {
        connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Characters SET heal = ? , strength = ? , leftHand = ? WHERE name = ?");
            preparedStatement.setInt(1, player.getHeal());
            preparedStatement.setInt(2, player.getStrength());
            preparedStatement.setString(3, player.getLeftHand().getClass().getSimpleName());
            preparedStatement.setString(4, player.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveBoard(Hero player, Cell[] board) {
        connectDatabase();
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            String boardToJson = objectMapper.writeValueAsString(board);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Characters SET board = ? WHERE name = ?");
            preparedStatement.setString(1, boardToJson);
            preparedStatement.setString(2, player.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Cell[] getSavedBoard(Hero player) {
        Statement statement = null;
        ResultSet result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        connectDatabase();
        try {
            statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT board FROM Characters WHERE name = ?;");
            preparedStatement.setString(1, player.getName());

            result = preparedStatement.executeQuery();

            while (result.next()) {
                try {
                    Cell[] jsonToArray = objectMapper.readValue(result.getString("board"), Cell[].class);
                    return jsonToArray;
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
            }
        }
        return null;
    }

    public void deleteHero(String playerName) {
        connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Characters WHERE name = ?");
            preparedStatement.setString(1, playerName);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Hero loadSavedCharacter() {
        Scanner keyboard = new Scanner(System.in);

        List<Hero> allSavedCharacters = getHeroInfos();
        for (int i = 0; i < allSavedCharacters.size(); i++) {
            System.out.println(i + "\n" + allSavedCharacters.get(i));
        }
        int choice = -1;
        boolean correctChoice = false;
        while (!correctChoice) {
            System.out.println("please Choose a correct number from 0 to " + (allSavedCharacters.size()-1));
            try{
                choice = Integer.parseInt(keyboard.next());
                if (choice < allSavedCharacters.size()) {
                    correctChoice = true;
                }
            }catch (NumberFormatException ex) {
            }
        }
        return allSavedCharacters.get(choice);
    }

    public List<String> getAllNames() {
        List<String> names = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        connectDatabase();
        String oneName;
        try {
            statement = connection.createStatement();


            result = statement.executeQuery("SELECT name FROM Characters;");

            while (result.next()) {
                oneName = result.getString("name");
                try {
                    names.add(oneName);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (SQLException e) {
        } finally {
            // Close the connection
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
            }
        }
        return names;
    }
}
