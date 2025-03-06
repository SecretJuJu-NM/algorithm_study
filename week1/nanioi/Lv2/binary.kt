// input 형태 
// s -> "110010101001"

// output 형태 
// result -> [3,8]

class Solution {
    fun solution(s: String): IntArray {
        var cnt = 0 // 총 실행 갯수 
        var removeZeroCnt = 0 // 제거되는 0의 갯수
        var str = s 
        
        while (str.length > 1){ 
            cnt +=1
            removeZeroCnt += checkZeroCount(str)
            str = str.replace("0","")
            str = changeBinary(str.length) // 이진변환 후 문자열의 길이 -> 이진변환 결과 
        }

        return intArrayOf(cnt,removeZeroCnt)
    }
    
    fun checkZeroCount(s: String) : Int{ // 0의 갯수 반환 
        return s.count{ it == '0'}
    }
    
    fun changeBinary(len:Int): String{ // 숫자 -> 이진변환 결과 반환 
        return len.toString(2)
    }
}