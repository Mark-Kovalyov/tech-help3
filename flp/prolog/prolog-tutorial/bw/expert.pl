provider(PROVIDER) :- mapped(PROVIDER, _ , _ ).

instrument(INSTRUMENT) :- mapped( _ , INSTRUMENT , _ ).

provider_instrument(PROVIDER, INSTRUMENT) :- mapped(PROVIDER , INSTRUMENT , _ ).

/* Standard footer. Fixed rules. */
/* Field of: */
field(INSTRUMENT, FIELD) :-
    attr(INSTRUMENT, FIELD) ;
    dim(INSTRUMENT, FIELD) ;
    prop(INSTRUMENT, FIELD) ;
    trans(INSTRUMENT, FIELD).

provider_instrument_csv(PROVIDER, INSTRUMENT) :- csvmapped(PROVIDER, INSTRUMENT, _ , _ , _).

provider_csv(PROVIDER) :- provider_instrument_csv(PROVIDER, _).

provider_instrument_orc(PROVIDER, INSTRUMENT) :- orc(PROVIDER, INSTRUMENT, _, _).

provider_orc(PROVIDER) :- provider_instrument_orc(PROVIDER, _).

% Providers that do not published into ORC
providers_without_orc(PROVIDER) :- provider(PROVIDER) , not(provider_orc(PROVIDER)).

main :-
    write('This is an ontology-expert-system'), nl.

reset_answers :-
  retract(attr(_,_)),
  retract(prop(_,_)),
  retract(dim(_,_)),
  retract(trans(_,_)),
  retract(csvmapped(_, _, _, _, _)),
  retract(orc(_, _, _, _)),
  retract(mapped(_,_,_)),
  fail.
reset_answers.
