import Foundation

func solution(_ topping:[Int]) -> Int {
    var set1 = Set<Int>()
    var set2 = Set<Int>()
    var arr1 = Array(repeating: 0, count: topping.count)
    var arr2 = Array(repeating: 0, count: topping.count)
    for i in 0..<topping.count {
        set1.insert(topping[i])
        arr1[i] = set1.count
    }
    var index = topping.count - 1
    while index >= 0 {
        set2.insert(topping[index])
        arr2[index] = set2.count
        index -= 1
    }
    var sum = 0
    for i in 1..<topping.count {
        if arr1[i-1] == arr2[i] {
            sum += 1
        }
    }
    return sum
}