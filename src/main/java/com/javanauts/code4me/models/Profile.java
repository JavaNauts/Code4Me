package com.javanauts.code4me.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;
    private ArrayList<String> skills;
    private ArrayList<String> services;
    private String gitHubLink;
    private String projectOne;
    private  String projectTwo;

//    @OneToOne
//    AppUser appUser;
    protected Profile() {
    }

    public Profile(String bio, ArrayList<String> skills, String gitHubLink, String projectOne, String projectTwo, ArrayList<String> services) {

        this.bio = bio;
        this.skills = skills;
        this.gitHubLink = gitHubLink;
        this.projectOne = projectOne;
        this.projectTwo = projectTwo;
        this.services = services;
    }

    public Long getId() {
        return id;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        this.gitHubLink = gitHubLink;
    }

    public String getProjectOne() {
        return projectOne;
    }

    public void setProjectOne(String projectOne) {
        this.projectOne = projectOne;
    }

    public String getProjectTwo() {
        return projectTwo;
    }

    public void setProjectTwo(String projectTwo) {
        this.projectTwo = projectTwo;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }
}
