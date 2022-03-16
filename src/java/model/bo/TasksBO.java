package model.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.dao.TasksDAO;
import model.vo.TasksVO;

public class TasksBO {

    public void createTask(TasksVO taskVO) {
        if (taskVO != null) {
            try {
                TasksDAO taskDAO = new TasksDAO();
                taskDAO.create(taskVO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteTask() {

    }

    public List<TasksVO> listAllTask(TasksVO taskVO) {
        TasksDAO taskDAO = new TasksDAO();

        try {
            List<TasksVO> tasksVO = taskDAO.listBySituation(taskVO.getSituation());

            tasksVO.removeIf(s -> {
                if (taskVO.getNumber() != null) {
                    return !Objects.equals(s.getNumber(), taskVO.getNumber());
                } else {
                    return false;
                }
            });
            tasksVO.removeIf(s -> {
                if (!taskVO.getResponsible().equals("")) {
                    return !s.getResponsible().contains(taskVO.getResponsible());
                } else {
                    return false;
                }
            });
            tasksVO.removeIf(s -> {
                if (!taskVO.getTitle().equals("")) {
                    return !s.getTitle().contains(taskVO.getTitle());
                } else {
                    return false;
                }
            });

            return tasksVO;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateTask() {

    }

    public Integer generateNumberTask() {
        TasksDAO taskDAO = new TasksDAO();
        List<TasksVO> tasksVO = new ArrayList<>();
        Integer generateNumber;

        tasksVO = taskDAO.list();

        if (tasksVO.size() == 0) {
            generateNumber = 1;
        } else {
            generateNumber = tasksVO.get(tasksVO.size() - 1).getNumber();
            generateNumber++;
        }

        return generateNumber;
    }
}
