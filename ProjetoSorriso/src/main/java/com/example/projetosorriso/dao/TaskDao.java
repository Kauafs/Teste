package com.example.projetosorriso.dao;

import com.example.projetosorriso.db.DB;
import com.example.projetosorriso.models.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDao implements ITaskDao {
    private Connection conn;

    public TaskDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Task task) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(
                    "INSERT INTO  tasks(title,description) values (?,?)"
            );
            stat.setString(1, task.getTitle());
            stat.setString(2, task.getDescription());
            int rowsInsert = stat.executeUpdate();
            if (rowsInsert > 0){
                ResultSet resultSet = stat.getGeneratedKeys();
                task.setId(resultSet.getLong(1));
            }else {
                throw new RuntimeException("Erro ao salvar");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Task task) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("UPDATE tasks SET title=?, description=? WHERE id = ?");
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setLong(3, task.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void deleteById(Integer id) {

    }



    @Override
    public List<Task> findAll() {
        List<Task> listTasks = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tasks");
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Task task = new Task(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"));
                listTasks.add(task);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listTasks;
    }
    }

