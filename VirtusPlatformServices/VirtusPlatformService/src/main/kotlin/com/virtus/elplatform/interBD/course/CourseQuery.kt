package com.virtus.elplatform.interBD.course

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Component
class CourseQuery internal constructor(private val repository: CourseRepository) : GraphQLQueryResolver {

    fun getAllCourse(): Iterable<Course?> {
        return repository.findAll()
    }

    fun courseById(id: Long): Course {
        return repository.findById(id).get()
    }

    private fun byId(id: Int): Specification<Course?> {
        return Specification { root: Root<Course?>, query: CriteriaQuery<*>?, builder: CriteriaBuilder ->
            builder.equal(
                root.get<Any>("id"),
                id
            )
        }
    }
}
