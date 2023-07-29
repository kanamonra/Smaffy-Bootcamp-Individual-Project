package com.ceceg.smaffy.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// user collection
@Repository
public interface UserRepository extends MongoRepository<UsersData, ObjectId> {
}
