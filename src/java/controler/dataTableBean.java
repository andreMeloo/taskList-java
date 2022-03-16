package controler;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import model.bo.TasksBO;
import model.vo.TasksVO;


@ManagedBean
@ViewScoped
public class dataTableBean {

    private HtmlDataTable dataTableTasks;
    
    public void removeTask() {
        TasksBO taskBO = new TasksBO();
        TasksVO taskVO = (TasksVO) dataTableTasks.getRowData();
        
        taskBO.deleteTask(taskVO.getNumber());
    }
    
    public void concludeTask() {
        TasksBO taskBO = new TasksBO();
        TasksVO taskVO = (TasksVO) dataTableTasks.getRowData();
        taskVO.setSituation("complete");
        
        taskBO.updateTask(taskVO);
    }

    public HtmlDataTable getDataTableTasks() {
        return dataTableTasks;
    }

    public void setDataTableTasks(HtmlDataTable dataTableTasks) {
        this.dataTableTasks = dataTableTasks;
    }

}