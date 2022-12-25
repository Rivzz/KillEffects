package com.mtjanney.killeffects.database;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.sql.*;
import java.util.UUID;
import java.util.logging.Level;

public class SQLite {
    private final Plugin plugin;
    private final String databaseName;
    private File database;
    private Connection connection;
    private boolean connected = false;

    public SQLite(String databaseName, Plugin plugin) {
        this.databaseName = databaseName;
        this.plugin = plugin;
    }

    public void create() {
        database = new File(plugin.getDataFolder(), databaseName + ".db");

        if (!database.exists()) {
            database.getParentFile().mkdirs();
            plugin.saveResource(databaseName + ".db", false);
            plugin.getLogger().log(Level.INFO, "Created " + databaseName + ".db");
        } else {
            plugin.getLogger().log(Level.INFO, databaseName + ".db exists, so nothing to do.");
        }

        if (database.exists()) {
            connection = getConnection();

            try {
                assert connection != null; // Done because this only pings if the database.db exists
                Statement statement = connection.createStatement();

                statement.executeUpdate(createPlayerTable);
                statement.close();

                plugin.getLogger().log(Level.INFO, "Database tables now exist.");
                connected = true;
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void addPlayer(UUID uuid) {
        if (connected) {
            try {
                assert connection != null; // Done because this only pings if the database.db exists
                Statement statement = connection.createStatement();

                statement.executeUpdate(addPlayerStatement(uuid));
                statement.close();

                plugin.getLogger().log(Level.INFO, "Added a new player to the players table.");
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void changePlayerEffect(UUID uuid, int effectID) {
        if (connected) {
            try {
                assert connection != null;
                Statement statement = connection.createStatement();

                statement.executeUpdate(changePlayerEffectStatement(uuid, effectID));
                statement.close();

                plugin.getLogger().log(Level.INFO, "Updated " + uuid + " with effectID=" + effectID + ".");
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public int getPlayerEffect(UUID uuid) {
        int effectID = 0;

        if (connected) {
            try {
                assert connection != null;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(getPlayerEffectStatement(uuid));

                while (resultSet.next()) {
                   effectID = resultSet.getInt(1);
                }

            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        return effectID;
    }

    public boolean playerExists(UUID uuid) {
        boolean found = false;

        if (connected) {
            try {
                assert connection != null;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(playerExistsStatement(uuid));

                while(resultSet.next()) {
                    if (resultSet.getString(1).equals(uuid.toString())) {
                        found = true;
                    }
                }

            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }

        if (found) plugin.getLogger().log(Level.INFO, "Player table with player has been found.");
        else plugin.getLogger().log(Level.SEVERE, "Player table with player has not been found.");

        return found;
    }

    private Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:" + database);
        } catch(SQLException exception) {
            plugin.getLogger().log(Level.SEVERE, "Cannot initialize SQLite", exception);
        } catch(ClassNotFoundException exception) {
            plugin.getLogger().log(Level.SEVERE, "Cannot locate SQLite JDBC library", exception);
        }

        return null;
    }

    private String createPlayerTable = "CREATE TABLE IF NOT EXISTS players (" +
            "`uuid` TEXT NOT NULL," +
            "`effect` INT(4) NOT NULL," +
            "PRIMARY KEY (`uuid`));";

    private String addPlayerStatement(UUID uuid) {
        return "INSERT INTO players VALUES('" + uuid.toString() + "', 0000);";
    }

    private String playerExistsStatement(UUID uuid) {
        return "SELECT * FROM players WHERE uuid='" + uuid.toString() + "';";
    }

    private String getPlayerEffectStatement(UUID uuid) {
        return "SELECT effect FROM players WHERE uuid='" + uuid.toString() + "';";
    }

    private String changePlayerEffectStatement(UUID uuid, int effectID) {
        return "UPDATE players SET effect=" + effectID + " WHERE uuid='" + uuid.toString() + "';" ;
    }
}
