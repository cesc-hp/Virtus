package com.virtus.elplatform.configuration

import graphql.kickstart.servlet.apollo.ApolloScalars
import graphql.schema.GraphQLScalarType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLConfiguration {

    @Bean
    fun uploadScalar(): GraphQLScalarType {
        return ApolloScalars.Upload
    }
}
