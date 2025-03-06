//dfs 활용

class Solution {

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        var visit = Array(n){0} // 방문 여부를 체크하는 배열 선언

        for (i in 0 until n){
            if(visit[i] == 0){ // 방문하지 않은 경우 
                dfs(i,computers,visit) // 연결된 노드 탐색 
                answer+=1
            }
        }

        return answer
    }


    fun dfs(i: Int, computers: Array<IntArray>, visit: Array<Int>){
        visit[i] = 1 // 방문했으니 체크 

        for((index,node) in computers[i].withIndex()){
            // 연결된 노드가 한번도 방문하지 않은 경우 해당 노드의 연결된 노드 탐색  
            if(index != i && node == 1 && visit[index]==0){
                dfs(index, computers, visit)
            }
        }

    }

}