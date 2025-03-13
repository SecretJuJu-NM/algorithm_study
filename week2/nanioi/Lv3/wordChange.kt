class Solution {
    
    var needVisit : ArrayDeque<Pair<String,Int>> = ArrayDeque<Pair<String,Int>>()
    var visit = mutableSetOf<String>()
    
    fun solution(begin: String, target: String, words: Array<String>): Int {   
        if(target !in words){
            return 0
        }
        
        needVisit.addLast(Pair(begin,0))
        return bfs(begin, target, words)
    }
    
    fun bfs(begin: String, target: String, words: Array<String>) : Int {
        while (needVisit.isNotEmpty()){
            val (currentWord,steps) = needVisit.removeFirst()
            if (currentWord == target) return steps
        
            for (word in words){
                // currentWord와 한글자만 차이나는 단어인지 체크 
                // 위에 해당되면 needVisit push
                if(word !in visit && currentWord.isOneCharDifferent(word)){
                    needVisit.addLast(Pair(word,steps+1))
                    visit.add(word)
                }
            }   
        }
        return 0
    }
    
    // 한글자만 차이나는 단어인지 체크 
    fun String.isOneCharDifferent(other: String): Boolean {
        var diffCount = 0
        for (i in this.indices) {
            if (this[i] != other[i]) {
                diffCount++
                if (diffCount > 1) return false
            }
        }

        return diffCount == 1
    }
}