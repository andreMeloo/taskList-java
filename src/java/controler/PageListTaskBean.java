package controler;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.bo.TasksBO;
import model.vo.TasksVO;

@ManagedBean
public class PageListTaskBean {

    private TasksVO newTask = new TasksVO();
    private List<TasksVO> listTasks = new ArrayList<>();

    public void findTasks() {
        TasksBO taskBO = new TasksBO();

        listTasks = taskBO.listAllTask(newTask);

        newTask = new TasksVO();
    }

    public TasksVO getNewTask() {
        return newTask;
    }

    public void setNewTask(TasksVO newTask) {
        this.newTask = newTask;
    }

    public List<TasksVO> getListTasks() {
        return listTasks;
    }

    public void setListTasks(List<TasksVO> listTasks) {
        this.listTasks = listTasks;
    }

}
