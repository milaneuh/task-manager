package com.dev.task_manager.tasks;

import java.util.UUID;

public record TaskDto(UUID id, String description, boolean done) {
}
