package com.virtus.elplatform.interBD.module

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class ModuleQuery internal constructor(private val repository: ModuleRepository) : GraphQLQueryResolver {

    fun getAllModules(): Iterable<Module?> {
        return repository.findAll()
    }

    fun moduleById(id: Long): Module {
        return repository.findById(id).get()
    }
}
