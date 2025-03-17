import java.util.*

/**
이중우선순위큐

[문제 설명]
명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.

[입출력 예]

operations	return
["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]

https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=kotlin

**/

class Solution {
	
	val queue: Queue<Int> = LinkedList()

    fun solution(operations: Array<String>): IntArray {
		
		operations.forEach{
			if(it.equals("D 1")) deleteMaxValue()
			else if(it.equals("D -1")) deleteMinValue()
			else insertQueue(it)
		}
		
    	if(queue.isEmpty()){
			return intArrayOf(0, 0)
		}else{
			return intArrayOf(
				queue.reduce{num1, num2 -> if(num1 > num2) num1 else num2}, 
                queue.reduce{num1, num2 -> if(num1 < num2) num1 else num2}
			)	
		}
    }
	
	fun insertQueue(str: String){
		queue.add((str.replace("I ", "")).toInt())
	}
	
	fun deleteMaxValue(){
		if(queue.isNotEmpty()){
			val value = queue.reduce{num1, num2 -> if(num1 > num2) num1 else num2}
			queue.remove(value)	
		}
	}
	
	fun deleteMinValue(){
		if(queue.isNotEmpty()){
			val value = queue.reduce{num1, num2 -> if(num1 < num2) num1 else num2}
			queue.remove(value)	
		}
	}
}
