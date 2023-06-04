% grasp - take a banana
% climb - get stay on the box
% push - push the box
% walk - walk from one place to another

state( _ , _ , _ , has).

move(state(middle, onbox, middle, hasnot),
   grasp,
   state(middle, onbox, middle, has) ).

move(state(P, onbox, P, H),
   climb,
   state(P, onbox, P, H) ).

