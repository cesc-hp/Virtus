package com.virtus.elplatform.interBD.content

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class ContentQuery internal constructor(private val repository: ContentRepository) : GraphQLQueryResolver {
    fun getAllContent(): Iterable<Content?> {
        return repository.findAll()
    }

    fun contentById(id: Long): Content {
        return repository.findById(id).get()
    }

    /*fun contentById(id: Long): Content {
        var spec: Specification<Content?>? = byId(id)
        return repository.findOne(spec).orElseThrow { NoSuchElementException() }!!
    }

    private fun byId(id: Long): Specification<Content?> {
        return Specification { root: Root<Content?>, query: CriteriaQuery<*>?, builder: CriteriaBuilder -> builder.equal(root.get<Any>("id"), id) }
    }*/
}
