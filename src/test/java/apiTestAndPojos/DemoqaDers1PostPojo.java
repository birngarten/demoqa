package apiTestAndPojos;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "userName",
        "password"
})
public class DemoqaDers1PostPojo {

    @JsonProperty("userName")
    private Object userName;
    @JsonProperty("password")
    private Object password;


    @JsonProperty("userName")
    public Object getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(Object userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public Object getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "DemoqaDers1PostPojo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @JsonProperty("password")
    public void setPassword(Object password) {
        this.password = password;
    }

    public DemoqaDers1PostPojo(){
    }
    public DemoqaDers1PostPojo(Object ali,Object veli){
        this.userName=ali;
        this.password=veli;
    }

}
