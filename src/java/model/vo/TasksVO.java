package model.vo;


import java.time.LocalDate;


public class TasksVO {


    private Long id;
    private Integer number;
    private String title;
    private String description;
    private String responsible;
    private String priority;
    private String situation;
    private LocalDate deadline;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id > 0) {
            this.id = id;
        }
    }
    
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null) {    
            this.description = description;
        }
    }


    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        if (responsible != null) {
            this.responsible = responsible;
        }
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        if (priority != null) {
            this.priority = priority;   
        }
    }


    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
            this.deadline = deadline;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        if (situation != null) {
            this.situation = situation;   
        }
    }
    
    
    
}
