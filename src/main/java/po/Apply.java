package po;

/**
 * Created by Administrator on 2015/11/30.
 */
public class Apply {
    private String id;
    private String name;
    private String procInstId;
    private String assignee;
    private String form;
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    private Integer days;

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", procInstId='" + procInstId + '\'' +
                ", assignee='" + assignee + '\'' +
                '}';
    }
}
