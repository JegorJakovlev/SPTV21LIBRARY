/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptv21library;

/**
 *
 * @author User
 */
public class author {
    String firstname;
    String lastname;
    int birthday;

    public author() {
    }

    public String firstname() {
        return firstname;
    }

    public author setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String lastname() {
        return lastname;
    }

    public author setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public int birthday() {
        return birthday;
    }

    public author setBirthday(int birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String toString() {
        return "Author{"
                + "firstname='" + firstname + '\''
                + ", lastname='" + lastname + '\''
                + ", birthday=" + birthday
                + '}';
    }
}