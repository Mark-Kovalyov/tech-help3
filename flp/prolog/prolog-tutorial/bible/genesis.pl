:- module(genesis, 
          grandparent/2,
          sister/2,
          brother/2,
          predecessor/2).

grandparent(X, Z) :-
   parent(X, Y),
   parent(Y, Z).

sister(X,Y) :- 
   parent(Z,X), 
   parent(Z,Y), 
   female(X), 
   dif(X,Y).

brother(X,Y) :-
   parent(Z,X),
   parent(Z,Y),
   not(female(X)),
   dif(X,Y).

predecessor(X,Z) :-
   parent(X,Y).

predecessor(X,Z) :-
   parent(X,Y),
   predecessor(Y,Z).
