% Когда Платон изрёк, что человек — это «двуногое животное без перьев», 
% то Диоген ощипал петуха и назвал его платоновским человеком.

biped(cock_without_feathers).

without_feathers(cock_without_feathers).

human(X) :- biped(X), without_feathers(X).
