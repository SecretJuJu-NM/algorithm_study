//bfs 활용

fun solution(n: Int, computers: Array<IntArray>): Int {
    val visited = BooleanArray(n)
    var networkCount = 0

    fun bfs(start: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            for (next in computers[node].indices) {
                if (computers[node][next] == 1 && !visited[next]) {
                    visited[next] = true
                    queue.add(next)
                }
            }
        }
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            networkCount++
            bfs(i)
        }
    }

    return networkCount
}
