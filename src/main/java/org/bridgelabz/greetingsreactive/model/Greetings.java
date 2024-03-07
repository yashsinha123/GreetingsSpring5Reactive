package org.bridgelabz.greetingsreactive.model;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Table(name="greetings")
@Data
public class Greetings {
    @Id
    private int id;
    private String name;
    private String message;

    @Override
    public String toString() {
        return "Greetings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
