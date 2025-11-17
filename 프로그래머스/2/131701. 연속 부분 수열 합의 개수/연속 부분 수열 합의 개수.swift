import Foundation

func solution(_ elements:[Int]) -> Int {
    var numSet = Set<Int>()
    
    for i in 0..<elements.count {
        var standard = 0
        for j in 0..<elements.count {
            standard += elements[(i+j)%elements.count]
            numSet.insert(standard)
        }
    }
    return numSet.count
}