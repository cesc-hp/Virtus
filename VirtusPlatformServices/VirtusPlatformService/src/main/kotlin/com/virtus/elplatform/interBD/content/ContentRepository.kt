package com.virtus.elplatform.interBD.content

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

interface ContentRepository : CrudRepository<Content?, Long?>, JpaSpecificationExecutor<Content?>
