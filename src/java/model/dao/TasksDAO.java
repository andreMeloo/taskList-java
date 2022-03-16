package model.dao;

import controler.Server;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.vo.TasksVO;

public class TasksDAO implements DAOInterface<TasksVO> {

    @Override
    public void create(TasksVO taskVO) {
        try {
            Connection connection = Server.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tasks (number_task, title_task, description_task, responsible_task, priority_task, situation_task, date_task) VALUES(?,?,?,?,?,?,?)");
            ps.setInt(1, taskVO.getNumber());
            ps.setString(2, taskVO.getTitle());
            ps.setString(3, taskVO.getDescription());
            ps.setString(4, taskVO.getResponsible());
            ps.setString(5, taskVO.getPriority());
            ps.setString(6, taskVO.getSituation());
            ps.setDate(7, Date.valueOf(taskVO.getDeadline()));
            ps.execute();
            Server.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TasksDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(TasksVO taskVO) {

    }

    @Override
    public List<TasksVO> list() {
        Connection connection = Server.getConnection();
        List<TasksVO> tasksVOs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                TasksVO taskVO = new TasksVO();
                taskVO.setId(resultSet.getLong("id_task"));
                taskVO.setNumber(resultSet.getInt("number_task"));
                taskVO.setTitle(resultSet.getString("title_task"));
                taskVO.setDescription(resultSet.getString("description_task"));
                taskVO.setResponsible(resultSet.getString("responsible_task"));
                taskVO.setPriority(resultSet.getString("priority_task"));
                taskVO.setSituation(resultSet.getString("situation_task"));
                taskVO.setDeadline(resultSet.getDate("date_task").toLocalDate());
                tasksVOs.add(taskVO);
            }

            return tasksVOs;
        } catch (SQLException ex) {
            Logger.getLogger(TasksDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(TasksVO taskVO) {

    }

    public List<TasksVO> listBySituation(String situation) {
        Connection connection = Server.getConnection();
        List<TasksVO> tasksVOs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE situation_task = ?");
            ps.setString(1, situation);
            ps.execute();
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                TasksVO taskVO = new TasksVO();
                taskVO.setId(resultSet.getLong("id_task"));
                taskVO.setNumber(resultSet.getInt("number_task"));
                taskVO.setTitle(resultSet.getString("title_task"));
                taskVO.setDescription(resultSet.getString("description_task"));
                taskVO.setResponsible(resultSet.getString("responsible_task"));
                taskVO.setPriority(resultSet.getString("priority_task"));
                taskVO.setSituation(resultSet.getString("situation_task"));
                taskVO.setDeadline(resultSet.getDate("date_task").toLocalDate());
                tasksVOs.add(taskVO);
            }

            return tasksVOs;
        } catch (SQLException ex) {
            Logger.getLogger(TasksDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
