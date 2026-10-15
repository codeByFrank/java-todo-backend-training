package de.neuefische.todospringbootjavatraining.model;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document(collection = "todos")
public record Todo(String id, String description, String status) {
}
