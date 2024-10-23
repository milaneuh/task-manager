package com.dev.task_manager.tasks;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(name = "task")
public class Task {
    @Id
    private UUID id;
    private String description;
    private boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void unFinishTask() {
        this.done = false;
    }

    public void finishTask() {
        this.done = true;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return this.id;
    }
}
