package com.shivam.sequencegenerator.daos;

import com.shivam.sequencegenerator.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sksingh created on 27/12/23
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
