# AI Algorithms

Student Name: Sravanya
Course / Semester: SEM 6 – Artificial Intelligence
Subject: AI Algorithms 

---

## 📁 Repository Overview

This repository contains the implementation and simulation of three classical Artificial Intelligence problems as part of the AI Algorithms  assignment:

1. **8-Puzzle Problem using A* Search Algorithm (Java)**
2. **8-Queens Problem using Backtracking Algorithm (C++)**
3. **Tic-Tac-Toe Game using Minimax Algorithm (HTML + JavaScript)**

Each problem includes:

* Problem representation
* Algorithm implementation
* Step-by-step simulation output
* Final solution display

---

## 🧠 Technology Stack

| Problem     | Language / Tools | Algorithm              |
| ----------- | ---------------- | ---------------------- |
| 8-Puzzle    | Java             | A* Search Algorithm    |
| 8-Queens    | C++              | Backtracking Algorithm |
| Tic-Tac-Toe | HTML, JavaScript | Minimax Algorithm      |

Development Environment:

* VS Code
* Java JDK
* GCC / G++ Compiler
* Web Browser (Chrome / Firefox)
* Operating System: Linux

---

## 📂 Project Structure

```text
AI-Algorithms/
│
├── eight-puzzle/
│   └── EightPuzzleAStarSimulation.java
│
├── eight-queens/
│   └── eightqueens.cpp
│
├── tic-tac-toe/
│   ├── index.html
│   ├── script.js
│   └── style.css
│
├── screenshots/
│   ├── eight_puzzle.png
│   ├── eight_queens.png
│   └── tic_tac_toe.png
│
└── README.md
```

---

## 🔹 Problem 1 – 8-Puzzle using A* Search Algorithm (Java)

### Problem Description

The 8-Puzzle consists of a 3×3 grid with 8 numbered tiles and one empty space (represented as 0). The objective is to transform the given initial configuration into the goal configuration using the minimum number of moves.

Initial State:

```
1 2 3
4 0 6
7 5 8
```

Goal State:

```
1 2 3
4 5 6
7 8 0
```

---

### State Space Representation

* Each state is represented as a 3×3 matrix.
* The blank tile (0) can move Up, Down, Left, or Right.
* Each move generates a new valid state in the search space.

---

### Heuristic Function (Manhattan Distance)

```text
f(n) = g(n) + h(n)
```

Where:

* `g(n)` = cost from initial state to current state
* `h(n)` = sum of Manhattan distances of all tiles from their goal positions
* `f(n)` = total estimated cost

---

### Algorithm Implementation

The A* algorithm maintains two lists:

* **Open List** – nodes to be explored (priority queue based on minimum f value)
* **Closed List** – nodes already explored

Steps:

1. Select node with minimum f(n) from Open list.
2. Move it to Closed list.
3. Generate all possible child states.
4. Compute g, h, and f for each child.
5. Repeat until the goal state is reached.

---

### Simulation Output

The simulation displays:

* Current expanded node
* Open list and Closed list
* g(n), h(n), f(n) values
* Step-by-step board configurations

---

### Final Solution

The final sequence of moves from the initial state to the goal state is printed along with the solved board configuration.

---

## 🔹 Problem 2 – 8-Queens using Backtracking Algorithm (C++)

### Problem Description

The objective is to place 8 queens on an 8×8 chessboard such that no two queens attack each other.

---

### Constraints

* Only one queen per row
* Only one queen per column
* No two queens on the same diagonal

---

### CSP Formulation

* **Variables**: Rows of the chessboard
* **Domain**: Columns from 0 to 7
* **Constraints**: Row, column, and diagonal safety

---

### Algorithm Implementation

The Backtracking algorithm places queens row by row:

* Try placing a queen in each column
* If safe, move to next row
* If no safe position exists, backtrack and try another column

---

### Simulation Output

The simulation shows:

* Queen placement row by row
* Backtracking steps
* Chessboard after each placement

---

### Final Solution

A valid chessboard configuration with all 8 queens placed safely is displayed.

---

## 🔹 Problem 3 – Tic-Tac-Toe using Minimax Algorithm (HTML + JavaScript)

### Problem Description

A human player plays Tic-Tac-Toe against an AI agent. The AI uses the Minimax algorithm to always play optimally.

---

### Game Representation

* 3×3 board represented as an array
* Human = `X`
* AI = `O`

---

### Terminal States

* Human wins
* AI wins
* Draw

---

### Algorithm Implementation

Minimax explores all possible future moves and selects the optimal one to maximize the AI’s outcome and minimize the human’s outcome.

---

### Simulation Output

* Human vs AI gameplay
* AI decision making using Minimax
* Final result displayed (Win / Lose / Draw)

---

### Final Solution

The AI always plays optimally and never loses the game.

---

## ▶️ How to Run the Programs

### 8-Puzzle (Java)

```bash
cd eight-puzzle
javac EightPuzzleAStarSimulation.java
java EightPuzzleAStarSimulation
```

---

### 8-Queens (C++)

```bash
cd eight-queens
g++ eightqueens.cpp -o eightqueens
./eightqueens
```

---

### Tic-Tac-Toe (Web)

```bash
cd tic-tac-toe
open index.html   # macOS
xdg-open index.html   # Linux
```

Or simply double-click `index.html` in any browser.

---





---

## 📸 Output and Simulation

Screenshots of:

* A* search simulation
* 8-Queens backtracking
* Tic-Tac-Toe gameplay

are available in the `screenshots/` folder.

---

## ✅ Conclusion

This repository demonstrates the implementation and simulation of important Artificial Intelligence algorithms such as A*, Backtracking, and Minimax. The programs clearly illustrate problem representation, algorithm execution, simulation steps, and final solutions.

---



