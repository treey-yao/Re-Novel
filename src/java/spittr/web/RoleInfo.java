package spittr.web;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;


/**
 * Created by Administrator on 2017/7/16.
 */
public class RoleInfo {
    @NotNull
    @Size(min=5,max=10)
    public String firstName;
    @NotNull
    @Size(min=5,max=10)
    public String lastName;
    @NotNull
    @Size(min=5,max=10)
    public String userName;
    @NotNull
    @Size(min=5,max=10)
    public String password;


    public RoleInfo(){
        this.firstName="22";
        this.lastName="lastName";
        this.userName="33";
        this.password="password";
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
