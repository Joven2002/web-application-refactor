package com.system.demo.appl.model.section;

public class Section {
    private Long sectionId;

    private String sectionName;

    private String sectionCourse;

    private String clusterName;

    private String clusterHead;

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionCourse() {
        return sectionCourse;
    }

    public void setSectionCourse(String sectionCourse) {
        this.sectionCourse = sectionCourse;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterHead() {
        return clusterHead;
    }

    public void setClusterHead(String clusterHead) {
        this.clusterHead = clusterHead;
    }

   public Section(){

   }
}