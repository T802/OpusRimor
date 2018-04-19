package com.example.user.OpusRimor;

/**
 * JobPost object
 */
public class JobPost {
    private String title, site, PostDate, JLink, Desc;

    /**
     * Default constructor
     */
    public JobPost() {
    }

    /**
     *
     * @param title
     * @param site
     * @param PostDate
     * @param JLink
     * @param Desc
     *
     * Argumentative constructor
     */
    public JobPost(String title, String site, String PostDate, String JLink, String Desc) {
        this.title = title;
        this.PostDate = PostDate;
        this.site = site;
        this.JLink = JLink;
        this.Desc = Desc;
    }

    /**
     *
     * @return Job title
     */
    public String getTitle() { return title; }

    /**
     *
     * @param name Sets title of job
     */
    public void setTitle(String name) { this.title = name; }

    /**
     *
     * @return Date of job posting
     */
    public String getPostDate() { return PostDate; }

    /**
     *
     * @param PostDate Sets post date of job
     */
    public void setPostDate(String PostDate) { this.PostDate = PostDate; }

    /**
     *
     * @return Origin of job posting
     */
    public String getSite() { return site; }

    /**
     *
     * @param site Sets origin of job posting
     */
    public void setSite(String site) { this.site = site; }

    /**
     *
     * @return Link to job posting
     */
    public String getJLink(){return JLink;}

    /**
     * Sets link to job posting
     */
    public void setJLink(){ this.JLink = JLink; }

    /**
     *
     * @return Job description
     */
    public String getDesc() { return Desc; }

    /**
     *
     * @param Desc Sets job desription
     */
    public void setDesc(String Desc) { this.Desc = Desc; }

}
