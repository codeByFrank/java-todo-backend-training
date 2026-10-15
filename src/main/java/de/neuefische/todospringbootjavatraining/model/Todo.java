package de.neuefische.todospringbootjavatraining.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public record Todo(String id, String description, String status) {
}
