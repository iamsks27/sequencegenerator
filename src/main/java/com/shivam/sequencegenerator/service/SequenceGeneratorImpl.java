package com.shivam.sequencegenerator.service;

import com.shivam.sequencegenerator.bean.DatabaseSequence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * @author sksingh created on 27/12/23
 */
@Slf4j
@Repository
@RequiredArgsConstructor
// To use this class as repository, we need to suffix with Impl for spring to use this implementation.
// ref: https://docs.spring.io/spring-data/mongodb/reference/repositories/custom-implementations.html
public class SequenceGeneratorImpl implements SequenceGenerator {

    private final MongoOperations mongoOperations;

    public long generateSequence(String seqName) {
        log.info("Generating unique number for seqName: {}", seqName);
        DatabaseSequence counter = mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is(seqName)),
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                DatabaseSequence.class
        );

        return Objects.nonNull(counter) ? counter.getSeq() : 1;
    }
}
