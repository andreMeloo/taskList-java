package controler;

import javax.faces.bean.ManagedBean;
import model.bo.TasksBO;
import model.vo.TasksVO;


@ManagedBean
public class RegisterTaskBean {
    
    private TasksVO taskVO = new TasksVO();
    
    public void registerTask() {
        TasksBO taskBO = new TasksBO();
        taskVO.setNumber(taskBO.generateNumberTask());
        taskVO.setSituation("incomplete");
        taskBO.createTask(taskVO);
        taskVO = new TasksVO();
    }

    public TasksVO getTaskVO() {
        return taskVO;
    }

    public void setTaskVO(TasksVO taskVO) {
        this.taskVO = taskVO;
    }
    
}
