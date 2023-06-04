% The Sacred Bible:  
%      The Book of Genesis
%      The Book of Exodus
%      The Book of Leviticus
% Iudas, Simeone

style_check(+discontiguous).

parts( [ 'Genesis' | [ 'Exodus', 'Deuteronomium' ] ] ).

angels( ['Gabriel','Michael'] ).

seraphim([]).
cherubim([]).
prestol([]).

imps( conc('Baal', 'Mephisto', 'Diablo') ).

% Member
% ?- is_genesis(member('Genesis',parts)).

% Conc
%

% Eden chronicles.

parent(god, lucifer).
parent(god, adam).
parent(god, eve).
wife(eve,adam).

parent(adam, kain).
parent(eve, kain).
parent(adam, abel).
parent(adam, sif).

% Sif genealogy

parent(sif, enos).
parent(enos, kainan).
parent(kainan,maleleil).
parent(maleleil,iared).
parent(iared,enoh2).     % TODO: Duplicate enoh?
parent(enoh2, mafusail).
parent(mafusail, lameh).
parent(lameh, noah).

% Kain genealogy

parent(kain,enoh).
parent(enoh,irad).
parent(irad,mehiael).
parent(mehiael,mafusal).
parent(mafusal,lameh).
wife(ada,mafusal).
wife(tsilla,mafusal).

% Noah chronicles.

parent(noah, sim).
parent(noah, ham).
parent(noah, iafet).

parent(iafet,'Гомер').
parent(iafet,'Магог').
parent(iafet,'Мадай').
parent(iafet,'Иаван').
parent(iafet,'Фувал').
parent(iafet,'Мешех').
parent(iafet,'Фирас').

parent('Гомер', 'Аскеназ').
parent('Гомер', 'Рифат').
parent('Гомер', 'Фогарма').

parent('Иаван', 'Елиса').
parent('Иаван', 'Фарсис').
parent('Иаван', 'Киттим').
parent('Иаван', 'Доданим').

parent(ham,hanaan).

female(daughter1).
female(daughter2).

wife(ahari, abraham).

% Abraham chronicles.

parent(sim, farra). % TODO: Check

parent(farra, abraham).
parent(farra, aran).
parent(farra, nahor).
parent(farra, sarra).

parent(abraham, isaac).
parent(abraham, ismail).
wife(sarra, abraham).
wife(hettura, abraham).

parent(sarra, isaac).
wife(rebecca, isaac).
parent(isaac, iakov).
parent(isaac, isaav).
wife(iegudif, isaav).
parent(iakov, judah).
parent(judah, fares).
parent(fares, esrom).
parent(esrom, aram).
parent(aram, aminadav).
parent(aminadav, nasson).
parent(nasson, salmon).
parent(salmon, vooz).
parent(rahava, vooz).
wife(rahava, salmon).
parent(vooz, ovid).
parent(ruth, ovid).
female(ruth).
parent(ovid, jessy).
parent(jessy, david).
parent(david, solomon).
parent(solomon, rovoam).
caesar(solomon).
parent(rovoam, avia).
parent(avia, asa).
parent(asa, iosofat).
parent(iosofat, ioram).
parent(ioram, ozia).
parent(ozia, iofam).
parent(iofam, ahaz).
parent(ahaz, iezekia).
parent(iezekia, manassia).
parent(manassia, amon).
parent(amon, iossia).
parent(iossia, iokim).
parent(iokim, iehonia).

% Babilon epoh

parent(iehonia, salafiil).
parent(salafiil, zorovavel).
parent(zorovavel, aviud).
parent(aviud, eliakim).
parent(eliakim, azor).
parent(azor, sadok).
parent(sadok, ahim).
parent(ahim, eliud).
parent(eliud, eleazar).
parent(eleazar, matfan).
parent(matfan, jakob).
parent(jakob, joseph).
parent(joseph, jesus).
parent(maria, jesus).
wife(maria,joseph).

% Matfey

caesar(irod).

% 

parent(lot, daughter1).
parent(lot, daughter2).

parent(lot, moav).
parent(daughter1, moav).
parent(lot, 'ben-ammi').
parent(daughter2, 'ben-ammi').


brother('Simon(Peter)','Andrew').

parent(zevedey, 'Jakob').
parent(zevedey, 'Iohann').

christ_age(date(1,jan,0001)).

apostle(['Simon(Peter)',
         'Andrew',
         'Iakov(Zevdeev)',
         'Philipp',
         'Varfolomey',
         'Foma',
         'Matwey',
         'Iakov Alfeev',
         'Levey(Faddey)',
         'Simon Kananit',
         'Judah Iskariot']).

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

predecessor(X,Y) :-
   parent(X,Y).

predecessor(X,Z) :-
   parent(X,Y),
   predecessor(Y,Z).

female(X) :- wife(X,_).

offspring(X,Y) :- parent(Y,X).

relatives(X,Y) :- predecessor(X,Y).

relatives(X,Y) :- 
   predecessor(Z,X),
   predecessor(Z,Y).

relatives(X,Y) :- predecessor(Y,X).

relatives(X,Y) :- 
   predecessor(X,Z),
   predecessor(Y,Z).

