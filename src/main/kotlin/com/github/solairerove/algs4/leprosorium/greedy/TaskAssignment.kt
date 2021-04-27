package com.github.solairerove.algs4.leprosorium.greedy

/**
 * k is a number of workers
 * tasks is an array of task duration
 *
 * find the fastest time to complete all tasks, if worker can proceed only 2 tasks
 */
fun main() {
    val tasks = mutableListOf(2, 4, 6, 1, 5, 3) // [[3, 2], [0, 4], [5, 1]]

    print(taskAssignment(tasks, tasks.size / 2))
}

// O(nlog(n)) time | O(n) space
private fun taskAssignment(tasks: MutableList<Int>, k: Int): List<List<Int>> {
    val paired = mutableListOf<List<Int>>()
    val taskDurationToIndices = taskDurationToIndices(tasks)

    tasks.sort()
    for (i in 0 until k) {
        val loTaskDuration = tasks[i]
        val loTaskIndices = taskDurationToIndices[loTaskDuration]!!
        val loIdx = loTaskIndices.removeAt(loTaskIndices.size - 1)

        val hiTaskDuration = tasks[tasks.size - 1 - i]
        val hiTaskIndices = taskDurationToIndices[hiTaskDuration]!!
        val hiIdx = hiTaskIndices.removeAt(hiTaskIndices.size - 1)

        paired.add(listOf(loIdx, hiIdx))
    }

    return paired
}

private fun taskDurationToIndices(tasks: MutableList<Int>): MutableMap<Int, MutableList<Int>> {
    val taskDurationToIndices = mutableMapOf<Int, MutableList<Int>>()

    for (i in 0 until tasks.size) {
        val taskDuration = tasks[i]
        if (taskDuration in taskDurationToIndices) {
            taskDurationToIndices[taskDuration]!!.add(i)
        } else {
            taskDurationToIndices[taskDuration] = mutableListOf(i)
        }
    }

    return taskDurationToIndices
}
