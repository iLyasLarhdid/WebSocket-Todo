package com.todo.websocket.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoEntity {
    @Id
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;
    private String description;
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp created;
    @UpdateTimestamp
    private Timestamp updated;
    private boolean completed;

}
