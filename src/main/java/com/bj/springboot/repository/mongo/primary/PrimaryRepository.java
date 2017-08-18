package com.bj.springboot.repository.mongo.primary;

import com.bj.springboot.domain.mongo.PrimaryMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunboyu on 2017/8/17.
 */
@Repository
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String> {
}
