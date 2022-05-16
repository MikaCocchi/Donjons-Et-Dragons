import character.heroes.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DnD", "MikaCocchi", "nope you won't see my password");
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
                try{
                    Class<?> classType = Class.forName("character.heroes."+type);
                    hero = (Hero) classType.getDeclaredConstructor().newInstance();
                    hero.setName(name);
                    hero.setStrength((result.getInt("strength")));
                    hero.setHeal(result.getInt("heal"));
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Characters(name, type , heal , strength ) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getClass().getSimpleName());
            preparedStatement.setInt(3, player.getHeal());
            preparedStatement.setInt(4, player.getStrength());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveHeroCurrentStats(Hero player) {
        connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Characters SET heal = ? , strength = ? WHERE name = ?");
            preparedStatement.setInt(1, player.getHeal());
            preparedStatement.setInt(2, player.getStrength());
            preparedStatement.setString(3, player.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        int choice;
        System.out.println("which character do you want ? (write a number) ");
        choice = keyboard.nextInt();

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
                try{
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
