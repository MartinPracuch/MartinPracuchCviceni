package org.agel.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    private int id;
    private String name;

    private String namespaceName;
    private String path;

    private long createdAt;

    public Project(int id, String name, String namespaceName, String path, long createdAt) {
        this.id = id;
        this.name = name;
        this.namespaceName = namespaceName;
        this.path = path;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamespaceName() {
        return namespaceName;
    }


    public void setNamespaceName(String namespaceName) {
        this.namespaceName = namespaceName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public long getCreatedAt() {
        return createdAt;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", namespaceName='" + namespaceName + '\'' +
                ", path='" + path + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
