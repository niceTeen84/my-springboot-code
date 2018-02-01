package zzu.edu.rbw.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type implements Serializable{

    private static final long serialVersionUID = 2613046860961646973L;

    private String name;
    private Integer size;
}
