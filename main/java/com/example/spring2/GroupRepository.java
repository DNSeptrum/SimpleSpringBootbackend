package com.example.spring2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GroupRepository extends CrudRepository<ClassTeacher,Long> {

}