package com.javanauts.code4me.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;
    private String gitHubLink;
    private String projectOne;
    private String projectOneDesc;
    private  String projectTwo;
    private String projectTwoDesc;

    @OneToOne(mappedBy = "profile")
    AppUser appUser;

    @OneToMany(mappedBy = "profile")
    public List<Service> services;

    @OneToMany(mappedBy = "profile")
    public List<Skill> skills;

    protected Profile() {
    }

    public Profile(String bio, String gitHubLink,
                   String projectOne, String projectOneDesc, String projectTwo,
                   String projectTwoDesc) {

        this.bio = bio;
        this.gitHubLink = gitHubLink;
        this.projectOne = projectOne;
        this.projectOneDesc = projectOneDesc;
        this.projectTwo = projectTwo;
        this.projectTwoDesc = projectTwoDesc;
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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
    public String getProjectOneDesc() {
        return projectOneDesc;
    }

    public void setProjectOneDesc(String projectOneDesc) {
        this.projectOneDesc = projectOneDesc;
    }

    public String getProjectTwoDesc() {
        return projectTwoDesc;
    }

    public void setProjectTwoDesc(String projectTwoDesc) {
        this.projectTwoDesc = projectTwoDesc;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
