package com.divisapp.todolist.domain

import androidx.lifecycle.LiveData
import com.divisapp.todolist.data.model.CategoryInfo
import com.divisapp.todolist.data.model.NoOfTaskForEachCategory
import com.divisapp.todolist.data.model.TaskCategoryInfo
import com.divisapp.todolist.data.model.TaskInfo
import java.util.*

interface TaskCategoryRepository {
    suspend fun updateTaskStatus(task: TaskInfo) : Int
    suspend fun deleteTask(task: TaskInfo)
    suspend fun insertTaskAndCategory(taskInfo: TaskInfo, categoryInfo: CategoryInfo)
    suspend fun deleteTaskAndCategory(taskInfo: TaskInfo, categoryInfo: CategoryInfo)
    suspend fun updateTaskAndAddDeleteCategory(taskInfo: TaskInfo, categoryInfoAdd: CategoryInfo, categoryInfoDelete: CategoryInfo)
    suspend fun updateTaskAndAddCategory(taskInfo: TaskInfo, categoryInfo: CategoryInfo)
    fun getUncompletedTask(): LiveData<List<TaskCategoryInfo>>
    fun getCompletedTask(): LiveData<List<TaskCategoryInfo>>
    fun getUncompletedTaskOfCategory(category: String): LiveData<List<TaskCategoryInfo>>
    fun getCompletedTaskOfCategory(category: String): LiveData<List<TaskCategoryInfo>>
    fun getNoOfTaskForEachCategory(): LiveData<List<NoOfTaskForEachCategory>>
    fun getCategories(): LiveData<List<CategoryInfo>>
    suspend fun getCountOfCategory(category: String) : Int
    suspend fun getActiveAlarms(currentTime : Date) : List<TaskInfo>
}