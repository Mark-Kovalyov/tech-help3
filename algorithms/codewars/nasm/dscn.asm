; NASM: Does this string contain numbers?
; Write a C function has_digits in NASM that will 
; return a boolean indicating whether the input string 
; contains any digits.

; The input string may be NULL; in that case, return false.

global has_digits

section .text

has_digits:
  MOV EAX, 0
  RET



#include <criterion/criterion.h>
#include <criterion/types.h>

bool has_digits(const char *);

Test(the_has_digits_function, should_work_for_example_assertions) {
  cr_expect(!has_digits("This is sample test!"), "The input string \"This is sample test!\" does not contain any digits");
  cr_expect(!has_digits("I've just turned five!"), "The input string \"I've just turned five!\" does not contain any digits");
  cr_expect(has_digits("My favourite number is: 1337"), "The input string contains the digits: 1, 3 and 7");
  cr_expect(!has_digits("Lorem ipsum dolor sit amet. This text has no numbers!"));
  cr_expect(has_digits("0"), "'0' is a digit");
}