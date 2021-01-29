package pojos;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class DemoqaPostPojo {

    @JsonProperty("userName")
    private Object userName;
    @JsonProperty("password")
    private Object password;

    public DemoqaPostPojo() {
    }

    public DemoqaPostPojo(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    @JsonProperty("userName")
    public Object getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public Object getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("userName", userName).append("password", password).toString();
    }

}
