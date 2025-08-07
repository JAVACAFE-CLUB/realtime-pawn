package com.pawn.realtimesearch.domain

import com.pawn.realtimesearch.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "trends")
class Trend (
    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}