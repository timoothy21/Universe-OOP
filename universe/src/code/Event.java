package code;

public class Event {
    private String organizerName, eventTitle, eventDesc, eventCategory, fee, steps, quota;
    private Integer capacity;
    
    public Event(String organizerName, String eventCategory, String quota, Integer capacity, String fee, String steps, String eventTitle, String eventDesc) {
        this.organizerName = organizerName;
        this.eventCategory = eventCategory;
        this.quota = quota;
        this.capacity = capacity;
        this.fee = fee;
        this.steps = steps;
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    
}