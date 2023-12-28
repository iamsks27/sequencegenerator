package com.shivam.sequencegenerator.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sksingh created on 27/12/23
 */
@Getter
@Setter
@Document(collection = "users")
public class User {

    @Transient // To prevent this field from being persisted alongside other properties of the model
    public static final String SEQ_NAME = "users_sequence";

    @Id
    private Long userId;
    private String email;
}
