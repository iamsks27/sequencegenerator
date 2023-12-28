package com.shivam.sequencegenerator.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sksingh created on 27/12/23
 */
@Setter
@Getter
@Document(collection = "sequences")
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;
}
