package com.alicia.bstapp.model;

import jakarta.persistence.*;

@Entity
public class TreeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inputNumbers;
    @Lob
    private String treeJson;

    public TreeRecord() {}

    public TreeRecord(String inputNumbers, String treeJson) {
        this.inputNumbers = inputNumbers;
        this.treeJson = treeJson;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }

    @Override
    public String toString() {
        return "TreeRecord{" +
                "id=" + id +
                ", inputNumbers='" + inputNumbers + '\'' +
                ", treeJson='" + treeJson + '\'' +
                '}';
    }
}
