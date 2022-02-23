package com.example.behavioral.memento;

import java.util.UUID;

public class TextFileOriginator{
    private String id;
    private String name;
    private String content;

    public TextFileOriginator(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public TextFileSnapshot createSnapshot(int serialNo, String commitMessage){
        return new TextFileSnapshot(serialNo, this.id, this.name, this.content, commitMessage);
    }

    public void writeContent(String updatedContent) {
        this.content = updatedContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextFileOriginator{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}