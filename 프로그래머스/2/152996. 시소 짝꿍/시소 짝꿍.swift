import Foundation

func solution(_ weights:[Int]) -> Int64 {
    var dict = [Int: Int]()
    var count = 0
    for i in 0..<weights.count {
        if let value = dict[weights[i]] {
            dict[weights[i]] = value + 1
        } else {
            dict[weights[i]] = 1
        }
    }
    var valueList: [Double] = [1, 1.5, 2, 2/3, 4/3, 1/2, 3/4]
    for i in 0..<weights.count {
        let n = weights[i]
        for j in 0..<valueList.count {
            let k: Double = Double(n) * valueList[j]
         //   print(k)
            if dict[Int(k)] == nil {
                continue
            }
            if k.truncatingRemainder(dividingBy: 1) != 0 {
                continue
            }
            if j == 0 {
             //   print(124)
                count += dict[Int(k)]! - 1
            } else {
                count += dict[Int(k)]!
            }
            
        }
        
    }
    for i in 0..<weights.count {
        
    }
    
    return Int64(count / 2)
}

// 2.2 // 1
// 2.3 // 1.5
// 2.4 // 2

// 3.2 // 2/3
// 3.4 // 4/3

// 4.2 // 1/2
// 4.3 // 3/4
