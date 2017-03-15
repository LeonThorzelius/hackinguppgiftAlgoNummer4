package PoppyIlluminati;

/**
 *
 * @author leho9818
 */
public class Posts {
    private String object_id;
    private String name;
    private String message;
    private String type;
    private String shares;
    private String created_time;

    public Posts(String inObject_id, String inName, String inMessage, String inType, String inShares, String inCreated_time) {
      this.object_id = inObject_id;
      this.name = inName;
      this.message = inMessage;
      this.type = inType;
      this.shares = inShares;
      this.created_time = inCreated_time;
              
    }
    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }
    
    
}
