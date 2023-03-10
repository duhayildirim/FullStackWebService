package com.FullStackApp.WebServices.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @NotNull(message = "must be not null")
    @Size(min = 3, max = 33, message = "size must be between 3 and 33")
    private String userName;
    @NotNull(message = "must be not null")
    @Size(min = 3, max = 33, message = "size must be between 3 and 33")
    private String displayName;
    @NotNull(message = "must be not null")
    @Pattern(regexp = "^(.+)@(\\S+)$", message = "invalid format")
    private String email;
    @NotNull(message = "must be not null")
    @Size(min = 6, max = 18, message = "size must be between 6 and 18")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", displayName=" + displayName + ", email=" + email + ", password="
                + password + "]";
    }

}
