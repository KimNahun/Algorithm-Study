import Foundation

struct Number: Comparable {
    let a: Int
    let b: Int
    static func < (lhs: Number, rhs: Number) -> Bool {
        return lhs.b > rhs.b
    }
}
func solution(_ k:Int, _ tangerine:[Int]) -> Int {
    var dict = [Int: Int]()
    
    for value in tangerine {
        if let num = dict[value]  {
            dict[value] = num + 1
        } else {
            dict[value] = 1
        }
    }
    var nums = [Number]()
    for value in dict {
        nums.append(Number(a: value.0, b: value.1))
    }
    nums = nums.sorted()
    var sum = 0
    var cnt = 0
    for i in 0..<nums.count {
        sum += nums[i].b
        cnt += 1
        if sum >= k {
            return cnt
        }
    }
    return -1
}