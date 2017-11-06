# Programming-MiniProject (TIC-TAC-TOE)

This is a server & client TCP based project on the classic game, "Tic-Tac-Toe". The server hosts all neccessary information, which the client connects to. The clients can create(and close), and join the game. Once a client has created a game, and another one has joined, the server will start the game while the game is handled on the client side.

# Rules

The object of Tic Tac Toe is to get three in a row. You play on a three by three game board. The first player is known as X and the second is O. Players alternate placing Xs and Os on the game board until either oppent has three in a row or all nine squares are filled. X always goes first, and in the event that no one has three in a row, the stalemate is called a cat game. A single server supports up to 4 connections(players), and therefore, 2 games can be played at the same time on a single server.

# How to play

There are two .jar files attached to the wiki. Currently the app is programmed in a way, to make the connection through localhost, therefore the server, and the clients all need to be run on one machine. First off, you host the server(ttt-server-v1.jar), from there on you can launch up to 4 clients. Once a client has connected to a freshly launched server, he can create a game, close the game he has created, or join an existing game that another client has created. Once a client has created a game, and another one has joined him, the game will start, and proceed as the usual tic-tac-toe game would.

# Authors

Michał Grzymski, Marius Mic, Loghin Francisc, Maja Pihl, Jonas Andersen, Roberts Deksna. (MEA 3, AAU)
