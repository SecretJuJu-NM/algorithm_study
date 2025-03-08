import java.util.PriorityQueue

class Solution {
    val minHeap = PriorityQueue<Int>() // 최소 힙
    val maxHeap = PriorityQueue<Int>(compareByDescending { it }) // 최대 힙
    val valid = mutableMapOf<Int, Int>() // 값의 개수를 저장할 맵

    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
    

        for (op in operations) {
            val (cmd, numStr) = op.split(" ")
            val num = numStr.toInt()
    
            if (cmd == "I") {
                // 삽입
                insert(num)
            } else if (cmd == "D" && valid.isNotEmpty()) {
                // 삭제
                if (num == 1) removeFromHeap(maxHeap, valid) // 최댓값 삭제
                else removeFromHeap(minHeap, valid) // 최솟값 삭제
            }
        }

         // 최종 최소값과 최대값 찾기
        val max = getValidValue(maxHeap, valid)
        val min = getValidValue(minHeap, valid)

        return intArrayOf(max, min)
    }


    fun insert(num: Int) {
        minHeap.add(num)
        maxHeap.add(num)
        valid[num] = valid.getOrDefault(num, 0) + 1
    }

    // 값 삭제
    fun removeFromHeap(heap: PriorityQueue<Int>, valid: MutableMap<Int, Int>) {
        while (heap.isNotEmpty()) {
            val value = heap.poll()
            if (valid.containsKey(value) && (valid[value]?:-1) > 0) {
                valid[value] = valid[value]!! - 1
                if (valid[value] == 0) valid.remove(value)
                break
            }
        }
    }

    // 최댓값/최솟값 반환
    fun getValidValue(heap: PriorityQueue<Int>, valid: MutableMap<Int, Int>): Int {
        while (heap.isNotEmpty()) {
            val value = heap.peek()
            if (valid.containsKey(value) && (valid[value]?:-1) > 0) {
                return value
            }
            heap.poll()
        }
        return 0
    }
}