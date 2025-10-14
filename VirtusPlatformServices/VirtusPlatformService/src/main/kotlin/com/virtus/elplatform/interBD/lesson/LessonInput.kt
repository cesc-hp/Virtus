package com.virtus.elplatform.interBD.lesson

class LessonInput {
    private var title: String? = null
    private var courseId: Long? = null

    constructor() {}
    constructor(title: String?, courseId: Long?) {
        this.title = title
        this.courseId = courseId
    }
}
