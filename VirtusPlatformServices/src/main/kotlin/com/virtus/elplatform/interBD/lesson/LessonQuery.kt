package com.virtus.elplatform.interBD.lesson

/*import com.virtus.elplatform.interBD.content.Content*/
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Component
class LessonQuery internal constructor(private val repository: LessonRepository) : GraphQLQueryResolver {

    fun getAllLesson(): Iterable<Lesson?> {
        return repository.findAll()
    }

    fun lessonById(id: Long): Lesson {
        return repository.findById(id).get()
    }

    /*fun getAllLesson(environment: DataFetchingEnvironment): Iterable<Lesson?> {
        val s = environment.selectionSet
        val specifications: List<Specification<Lesson>> = ArrayList()
        return if (s.contains("contents")) repository.findAll(fetchContent()) else repository.findAll()
    }

    fun lessonById(id: Int, environment: DataFetchingEnvironment): Lesson {
        var spec: Specification<Lesson?>? = byId(id)
        val selectionSet = environment.selectionSet
        if (selectionSet.contains("contents")) spec = spec?.and(fetchContent())
        return repository.findOne(spec).orElseThrow { NoSuchElementException("Contenido no encontrado")}!!
    }

    private fun fetchContent(): Specification<Lesson?> {
        return Specification { root: Root<Lesson?>, query: CriteriaQuery<*>?, builder: CriteriaBuilder? ->
            val f = root.fetch<Lesson, Content>("contents", JoinType.LEFT)
            val join = f as Join<Lesson, Content>
            join.on
        }
    }*/

    private fun byId(id: Int): Specification<Lesson?> {
        return Specification { root: Root<Lesson?>, query: CriteriaQuery<*>?, builder: CriteriaBuilder -> builder.equal(root.get<Any>("id"), id) }
    }
}
