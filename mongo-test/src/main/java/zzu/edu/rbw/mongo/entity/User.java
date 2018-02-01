package zzu.edu.rbw.mongo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "aiko_user")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = -6897412329370465146L;

    @Id
    private String id;

    private String name;

    private Date birthday;

    private Integer age;

    private String[] tag;

    private Type type;

    private Integer state;
}
