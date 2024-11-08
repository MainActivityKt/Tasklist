package tasklist.memorableTaskList

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import tasklist.colorfultasks.ColorfulTaskManager
import tasklist.colorfultasks.Task
import utils.JSON_FILE_PATH
import java.io.File

class MemorableTaskList : ColorfulTaskManager() {

    private val moshiAdapter = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val type = Types.newParameterizedType(List::class.java, Task::class.java)
    private val taskAdapter: JsonAdapter<List<Task>> = moshiAdapter.adapter(type)

    override fun start() {
        val file = File(JSON_FILE_PATH).apply {
            if (!exists()) {
                createNewFile()
            }
        }

        if (file.readLines().isNotEmpty()) {
            val savedTasks = taskAdapter.fromJson(file.readLines().joinToString(""))
            tasksList.addAll(savedTasks!!)
        }
        super.start()
        file.appendText(taskAdapter.toJson(tasksList))

    }
}

fun main() {
    val taskManager = MemorableTaskList()
    taskManager.start()
}