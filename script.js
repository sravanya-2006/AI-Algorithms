let board = ["", "", "", "", "", "", "", "", ""];

let human = "X";
let ai = "O";

let humanScore = 0;
let aiScore = 0;

let firstTurn = "human";
let moveList = [];

let boardDiv = document.getElementById("board");
let statusText = document.getElementById("status");
let moveBox = document.getElementById("moveText");

function start() {
    boardDiv.innerHTML = "";
    board = ["", "", "", "", "", "", "", "", ""];
    moveList = [];
    moveBox.innerHTML = "";
    statusText.innerText = "";

    for (let i = 0; i < 9; i++) {
        let b = document.createElement("button");
        b.className = "cell";
        b.onclick = function () {
            playHuman(i);
        };
        boardDiv.appendChild(b);
    }

    if (firstTurn === "ai") {
        aiPlay();
    }
}

function playHuman(pos) {
    if (board[pos] !== "" || checkGame()) return;

    board[pos] = human;
    saveMove("Human", pos);
    updateBoard();

    if (!checkGame()) {
        aiPlay();
    }
}

function aiPlay() {
    let move = bestMove();
    board[move] = ai;
    saveMove("AI", move);
    updateBoard();
}

function saveMove(player, index) {
    let r = Math.floor(index / 3) + 1;
    let c = (index % 3) + 1;

    moveList.push(player + " -> Row " + r + ", Col " + c);
    showMoves();
}

function showMoves() {
    moveBox.innerHTML = "";
    for (let i = 0; i < moveList.length; i++) {
        moveBox.innerHTML += (i + 1) + ". " + moveList[i] + "<br>";
    }
}

function updateBoard() {
    let cells = document.querySelectorAll(".cell");
    for (let i = 0; i < 9; i++) {
        cells[i].innerText = board[i];
    }

    let res = checkGame();
    if (res) {
        if (res === human) {
            humanScore++;
            firstTurn = "human";
            statusText.innerText = "Human wins";
        } else if (res === ai) {
            aiScore++;
            firstTurn = "ai";
            statusText.innerText = "AI wins";
        } else {
            statusText.innerText = "Draw";
        }

        document.getElementById("hScore").innerText = humanScore;
        document.getElementById("aScore").innerText = aiScore;
    }
}

function checkGame() {
    let winSet = [
        [0,1,2],[3,4,5],[6,7,8],
        [0,3,6],[1,4,7],[2,5,8],
        [0,4,8],[2,4,6]
    ];

    for (let w of winSet) {
        if (board[w[0]] !== "" &&
            board[w[0]] === board[w[1]] &&
            board[w[1]] === board[w[2]]) {
            return board[w[0]];
        }
    }

    if (!board.includes("")) return "draw";
    return null;
}

function bestMove() {
    let bestVal = -999;
    let move;

    for (let i = 0; i < 9; i++) {
        if (board[i] === "") {
            board[i] = ai;
            let val = mini(false);
            board[i] = "";

            if (val > bestVal) {
                bestVal = val;
                move = i;
            }
        }
    }
    return move;
}

function mini(isAi) {
    let res = checkGame();
    if (res === ai) return 10;
    if (res === human) return -10;
    if (res === "draw") return 0;

    if (isAi) {
        let max = -999;
        for (let i = 0; i < 9; i++) {
            if (board[i] === "") {
                board[i] = ai;
                max = Math.max(max, mini(false));
                board[i] = "";
            }
        }
        return max;
    } else {
        let min = 999;
        for (let i = 0; i < 9; i++) {
            if (board[i] === "") {
                board[i] = human;
                min = Math.min(min, mini(true));
                board[i] = "";
            }
        }
        return min;
    }
}

function newRound() {
    start();
}

start();
