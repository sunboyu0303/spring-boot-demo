package com.bj.springboot.repository.mongo.secondary;

import com.bj.springboot.domain.mongo.SecondMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunboyu on 2017/8/17.
 */
@Repository
public interface SecondRepository extends MongoRepository<SecondMongoObject, String> {
}
