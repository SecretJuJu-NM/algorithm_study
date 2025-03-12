/**
    이진 변환 반복하기
    1. 문자열에서 0 제거
    2. 0을 제거한 문자열의 길이를 2진수로 변환 (문자열 이 1이 될때까지)

    input, ouput
    "110010101001", [3,8]
    "01110", [3,3]
    "1111111", [4,1]

    https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
class Solution {
    var binary_count = 0
    var zero_count = 0
    
    fun solution(s: String): IntArray {
        if(s != "1") {
            binary_count++
            var replaceStr = s.replace("0", "") //1. 문자열에서 0 제거
            zero_count += s.length - replaceStr.length
            var binaryString = Integer.toBinaryString(replaceStr.length) // 2. 0을 제거한 문자열의 길이를 2진수로 변환
            solution(binaryString)
        }

        return intArrayOf(binary_count, zero_count)
    }
}