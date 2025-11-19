import Foundation

var arr = [Int]()
var minNum = 1000000000
func solution(_ picks:[Int], _ minerals:[String]) -> Int {
    for item in minerals {
        if item == "diamond" {
            arr.append(3)
        } else if item == "iron" {
            arr.append(2)
        } else {
            arr.append(1)
        }
    }
    dfs(picks, 0, 0)
    return minNum
}
func dfs(_ items: [Int],_ number: Int,_ turn: Int) {
    if checkFinish(items, turn) {
        minNum = min(minNum, number)
        return
    }
    
    for i in 0..<items.count {
        if items[i] > 0 {
            var copy = items
            copy[i] -= 1
            let m: Int
            switch i {
                case 0: m = 3
                case 1: m = 2
                case 2: m = 1
                default: m = 1
            }
            dfs(copy, number + countSum(m, turn), turn + 1)
        }
    }
    
}

func countSum(_ item: Int,_ turn: Int) -> Int {
    var start = turn * 5
    var end = start + 5
    if end > arr.count {
        end = arr.count
    }
    var sum = 0
    for i in start..<end {
        let k = item - arr[i]
        if k == -2 {
            sum += 25
        } else if k == -1 {
            sum += 5
        } else {
            sum += 1
        }
    }
    return sum
}
func checkFinish(_ items: [Int],_ turn: Int) -> Bool {
    if arr.count % 5 == 0, arr.count / 5 == turn {
        return true
    }
    else if arr.count % 5 != 0, arr.count / 5 + 1 == turn {
        return true
    }
    var allEmpty = true
    for i in 0..<items.count {
        if items[i] != 0 {
            allEmpty = false
        }
    }
    return allEmpty
}

