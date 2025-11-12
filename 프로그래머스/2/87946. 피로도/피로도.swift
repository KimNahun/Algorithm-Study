import Foundation


var arr = [[Int]]()
var visited = [Bool]()
var tempArr = [[Int]]()
var kk = 0
var maxx = 0
func solution(_ k:Int, _ dungeons:[[Int]]) -> Int {
    arr = dungeons
    tempArr = dungeons
    kk = k
    visited = Array(repeating: false, count: dungeons.count)
    dfs(0)
    return maxx
}
func calculate() {
    var sum = 0
    var nowK = kk
 //   print(tempArr)
    for i in 0..<tempArr.count {
        if tempArr[i][0] <= nowK {
            nowK -= tempArr[i][1]
            sum += 1
        }
    }
    maxx = max(maxx, sum)
}
func dfs(_ depth: Int) {
    if depth == arr.count {
        calculate()
        return
    }
    
    for i in 0..<visited.count {
        if !visited[i] {
            visited[i] = true
            tempArr[depth] = arr[i]
            dfs(depth+1)
            visited[i] = false
        }
    }
}
