# **Ultimate DSA Pattern Recognition Cheat Sheet**

## **ðŸŽ¯ Pattern Recognition Framework**

### **Step 1: Problem Type Recognition**
*Ask: "What category of problem is this?"*

### **Step 2: Algorithmic Pattern Matching**  
*Ask: "What pattern does this match?"*

### **Step 3: Data Structure Selection**
*Ask: "What data structure supports this pattern?"*

### **Step 4: Implementation Strategy**
*Ask: "How do I implement this efficiently?"*

---

## **ðŸ“‹ Complete Problem Categories & Patterns**

### **ðŸ” SEARCH/FIND PROBLEMS**
**Keywords:** find, locate, search, exists, contains, position

| **Sub-Pattern** | **Data Structure** | **When to Use** | **Time Complexity** |
|---|---|---|---|
| **Binary Search** | Sorted Array | Sorted input, find target | O(log n) |
| **Linear Search** | Array/List | Unsorted data, small datasets | O(n) |
| **Hash Lookup** | Hash Map/Set | Fast existence check | O(1) average |
| **Tree Search** | BST, Trie | Hierarchical data, prefix search | O(log n) / O(m) |

**Implementation Templates:**
```python
# Binary Search Template
def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target: return mid
        elif arr[mid] < target: left = mid + 1
        else: right = mid - 1
    return -1

# Hash Lookup Template  
def exists_in_set(nums, target):
    num_set = set(nums)
    return target in num_set
```

---

### **ðŸ“Š COUNT/FREQUENCY PROBLEMS**
**Keywords:** count, frequency, occurrences, histogram, distribution

| **Sub-Pattern** | **Data Structure** | **When to Use** | **Time Complexity** |
|---|---|---|---|
| **Character Counting** | Hash Map | Anagrams, character freq | O(n) |
| **Element Frequency** | Hash Map/Array | Count occurrences | O(n) |
| **Prefix Counting** | Prefix Sum Array | Range sum queries | O(1) query |
| **Sliding Window Count** | Hash Map + Window | Substring problems | O(n) |

**Implementation Templates:**
```python
# Frequency Counter Template
def count_frequency(s):
    freq = {}
    for char in s:
        freq[char] = freq.get(char, 0) + 1
    return freq

# Sliding Window Count Template
def sliding_window_count(s, k):
    window_count = {}
    for i in range(len(s)):
        # Add current character
        window_count[s[i]] = window_count.get(s[i], 0) + 1
        
        # Remove if window too large
        if i >= k:
            left_char = s[i - k]
            window_count[left_char] -= 1
            if window_count[left_char] == 0:
                del window_count[left_char]
```

---

### **ðŸ”„ TRANSFORM/CONVERT PROBLEMS**
**Keywords:** convert, transform, format, encode, decode

| **Sub-Pattern** | **Data Structure** | **When to Use** | **Time Complexity** |
|---|---|---|---|
| **Value Mapping** | Hash Map/Array | Direct conversions | O(n) |
| **Greedy Conversion** | Sorted Array + Greedy | Roman numerals, coin change | O(n log n) |
| **String Manipulation** | String Builder/Array | Format transformations | O(n) |
| **Base Conversion** | Stack/Recursion | Number system conversion | O(log n) |

**Implementation Templates:**
```python
# Value Mapping Template
def transform_with_mapping(data, mapping):
    result = []
    for item in data:
        result.append(mapping.get(item, item))
    return result

# Greedy Conversion Template (Roman Numerals)
def int_to_roman(num):
    values = [(1000,'M'), (900,'CM'), (500,'D'), (400,'CD'), 
              (100,'C'), (90,'XC'), (50,'L'), (40,'XL'), 
              (10,'X'), (9,'IX'), (5,'V'), (4,'IV'), (1,'I')]
    result = ""
    for value, symbol in values:
        while num >= value:
            result += symbol
            num -= value
    return result
```

---

### **âœ… VALIDATE/CHECK PROBLEMS**
**Keywords:** valid, check, verify, balanced, correct

| **Sub-Pattern** | **Data Structure** | **When to Use** | **Time Complexity** |
|---|---|---|---|
| **Parentheses Matching** | Stack | Nested structures | O(n) |
| **Constraint Validation** | Set/Hash Map | Rule checking | O(n) |
| **Palindrome Check** | Two Pointers | Symmetry validation | O(n) |
| **Cycle Detection** | Set/Floyd's Algorithm | Graph/Linked List | O(n) |

**Implementation Templates:**
```python
# Stack Validation Template (Parentheses)
def is_valid_parentheses(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}
    for char in s:
        if char in mapping:
            if not stack or stack.pop() != mapping[char]:
                return False
        else:
            stack.append(char)
    return len(stack) == 0

# Two Pointers Palindrome Template
def is_palindrome(s):
    left, right = 0, len(s) - 1
    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True
```

---

### **ðŸŽ¯ OPTIMIZATION PROBLEMS**
**Keywords:** maximum, minimum, optimal, best, shortest, longest

| **Sub-Pattern** | **Data Structure** | **When to Use** | **Time Complexity** |
|---|---|---|---|
| **Dynamic Programming** | 2D Array/Memoization | Overlapping subproblems | O(nÂ²) typically |
| **Greedy Algorithm** | Priority Queue/Sorted | Locally optimal choices | O(n log n) |
| **Two Pointers** | Sorted Array | Optimization in sorted data | O(n) |
| **Sliding Window** | Queue/Deque | Subarray optimization | O(n) |

**Implementation Templates:**
```python
# DP Template (Fibonacci-style)
def dp_optimization(n):
    dp = [0] * (n + 1)
    dp[0], dp[1] = base_case_0, base_case_1
    for i in range(2, n + 1):
        dp[i] = dp[i-1] + dp[i-2]  # Recurrence relation
    return dp[n]

# Sliding Window Maximum Template
def sliding_window_maximum(nums, k):
    from collections import deque
    dq = deque()
    result = []
    
    for i in range(len(nums)):
        # Remove elements outside window
        while dq and dq[0] < i - k + 1:
            dq.popleft()
        
        # Remove smaller elements
        while dq and nums[dq[-1]] < nums[i]:
            dq.pop()
        
        dq.append(i)
        
        if i >= k - 1:
            result.append(nums[dq[0]])
    
    return result
```

---

## **ðŸ—ï¸ Data Structure Usage Guide**

### **ðŸ“š ARRAY/LIST**
**Best For:** Index-based access, sorted data operations
**Patterns:** Binary Search, Two Pointers, Sliding Window
**Time:** Access O(1), Search O(n), Insert O(n)

### **ðŸ—‚ï¸ HASH MAP/SET**
**Best For:** Fast lookups, frequency counting, existence checks
**Patterns:** Character counting, Two Sum variations, Caching
**Time:** Insert/Delete/Search O(1) average

### **ðŸ“š STACK**
**Best For:** LIFO operations, nested structures, backtracking
**Patterns:** Parentheses matching, Expression evaluation, DFS
**Time:** Push/Pop O(1)

### **ðŸšŒ QUEUE**
**Best For:** FIFO operations, level-order processing
**Patterns:** BFS, Level-order traversal, Sliding window
**Time:** Enqueue/Dequeue O(1)

### **ðŸŒ³ TREE/BST**
**Best For:** Hierarchical data, sorted operations
**Patterns:** Tree traversals, Binary search, Range queries
**Time:** Search/Insert/Delete O(log n) balanced

### **ðŸ•¸ï¸ GRAPH**
**Best For:** Relationships, path finding, connectivity
**Patterns:** DFS/BFS, Shortest path, Cycle detection
**Time:** Depends on algorithm and representation

### **â›°ï¸ HEAP**
**Best For:** Priority operations, top K elements
**Patterns:** Priority queue, Merge K sorted, Top K frequent
**Time:** Insert/Delete O(log n), Peek O(1)

---

## **ðŸŽ¨ Pattern Combinations**

### **Common Combinations:**
1. **Hash Map + Two Pointers** â†’ Two Sum variants
2. **Stack + Hash Map** â†’ Valid parentheses with mapping
3. **Sliding Window + Hash Map** â†’ Substring problems
4. **DFS + Memoization** â†’ Tree DP problems
5. **BFS + Queue** â†’ Level-order processing
6. **Heap + Hash Map** â†’ Top K frequent elements

---

## **âš¡ Quick Pattern Recognition Triggers**

### **Immediate Red Flags:**
- **"Subarray/Substring"** â†’ Sliding Window
- **"All permutations/combinations"** â†’ Backtracking  
- **"Tree traversal"** â†’ DFS/BFS
- **"Top K"** â†’ Heap
- **"Sorted array + target"** â†’ Binary Search/Two Pointers
- **"Graph connectivity"** â†’ Union Find/DFS
- **"Shortest path"** â†’ BFS/Dijkstra
- **"Nested structures"** â†’ Stack
- **"Fast lookup"** â†’ Hash Map
- **"Overlapping subproblems"** â†’ Dynamic Programming

### **Time Complexity Targets:**
- **O(1)** â†’ Hash Map lookup
- **O(log n)** â†’ Binary Search, Heap operations
- **O(n)** â†’ Single pass, Linear scan
- **O(n log n)** â†’ Sorting, Divide & Conquer
- **O(nÂ²)** â†’ Nested loops, Basic DP
- **O(2^n)** â†’ Backtracking, Subsets

---

## **ðŸ’¡ Pro Tips**

1. **Always ask:** "What's the constraint?" â†’ Determines feasible complexity
2. **Sorted input** â†’ Think Binary Search or Two Pointers first
3. **Duplicates allowed?** â†’ Changes algorithm choice
4. **In-place requirement?** â†’ Limits data structure options  
5. **Follow-up optimizations** â†’ Usually asking for better time/space complexity

**Remember:** Pattern recognition beats memorization. Master these frameworks, and 90% of coding problems become obvious!


# Problem Solving Decision Guide 🚀

Use this flow to quickly identify the **right approach or algorithm** when solving coding problems.

---

## START: Read the Problem Statement

---

## ❓ Question 1: What is the **CORE OPERATION**?

---

### 🔹 1. Checking Validity? (True / False result)

- Can I use constraints to validate?
  - ✅ **YES** → **Greedy** or **Simulation**
  - ❌ **NO** → **Brute Force** or **Math**

---

### 🔹 2. Finding Something? (Single element, pair, index, etc.)

- Is the data **sorted**?
  - ✅ **YES** → **Binary Search**
  - ❌ **NO** → **Hash Map** or **Linear Scan**

---

### 🔹 3. Counting Something? (Frequency, combinations, etc.)

- What do I need?
  - 🔢 **Exact frequency** → **Hash Map**
  - ✔ **Just presence** → **Set** or **Hash Map**

---

### 🔹 4. Optimizing? (Maximum, minimum, best result, best path)

- Can I reuse results of previous subproblems?
  - ✅ **YES** → **Dynamic Programming**
  - ❌ **NO** → **Greedy** or **Two Pointers**

---

### 🔹 5. Traversing a Structure?

- What kind of structure?
  - 📏 **Linear (Array / String / List)** → **Two Pointers** or **Sliding Window**
  - 🌳 **Tree** → **DFS / BFS** or **Recursion**
  - 🕸 **Graph** → **DFS / BFS** or **Graph Algorithms**

---

### 🔹 6. Mathematical Formula Based?

- Do I need to explore values?
  - ❌ **NO** → **Direct Formula / Math**
  - ✅ **YES** → **Binary Search** or **Iteration**

---

## ✅ Final Tip

> Always identify **what the problem is asking first** —  
> then choose the **simplest valid approach** before optimizing.

Happy Coding 💻🔥
