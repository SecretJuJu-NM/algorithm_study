// input 형태 
// s -> "{{1,2,3},{2,1},{1,2,4,3},{2}}"

// output 형태 
// result -> [2, 1, 3, 4]


class Solution {
    fun solution(s: String): IntArray {
        var answer = arrayListOf<Int>()

        // 문자열의 양쪽 끝 {{, }} 을 제거한 후 },{을 기준으로 setList를 생성한다. 
        var list = s.substring(2, s.length -2).split("},{") 
        // list -> [1,2,3, 2,1, 1,2,4,3, 2]

        // 원소의 길이에 따라 정렬 
        list = list.sortedBy() { it.length }
        // list -> [2, 2,1, 1,2,3, 1,2,4,3]

        for (i in list) { 
            // list의 각 원소들을 순회하며 answer에 포함되지 않은 요소가 있으면 추가
            i.split(',').forEach{
                if(!answer.contains(it.toInt())){
                    answer.add(it.toInt())
                }       
            }
        }
        
        return answer.toIntArray()
    }
}