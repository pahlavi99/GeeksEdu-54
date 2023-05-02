package com.example.geektechtaskmanager.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null
) : java.io.Serializable
