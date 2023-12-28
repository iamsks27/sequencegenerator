package com.shivam.sequencegenerator.daos;

import com.shivam.sequencegenerator.bean.DatabaseSequence;
import com.shivam.sequencegenerator.service.SequenceGenerator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sksingh created on 27/12/23
 */
@Repository
public interface SequenceRepository extends MongoRepository<DatabaseSequence, Long>, SequenceGenerator {

}
