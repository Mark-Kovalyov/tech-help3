; 8 80bit registers ST(0) - ST(7)
; FLD - load real number
; FST - store
; FCOM        COMpare ST(0) to a floating point value
; FCOMI       COMpare ST(0) to ST(i) and set CPU flags
; FSQRT (Square root of ST(0))
; FADD (Add two floating point values)
; FDIV (Divide two floating point values)
; FMUL (Multiply two floating point values)

; ---- Input (a,b,c  (Double64 bit or Extended 80bit)

; Syscalls (RAX)
SYS_READ        equ 0
SYS_WRITE	equ 1
SYS_EXIT	equ 60

; Standard file descriptirs
STDIN		equ 0
STDOUT		equ 1
STDERR          equ 2

message:	db	"Please enter a,b,c : "
message_len:	equ   	$ - message

c_message:	db	"No solutions! Complex roots."
c_message_len:	equ	$ - c_message

r_message:	db	"Result : "
r_message_len:	equ	$ - r_message

buffer:         db	times 50 db 0

two:            dq 2.0
four:		dq 4.0
zero:		dq 0.0

a: 		dq 4.0   ; define quadword (double precision)
b: 		dq 5.0
c: 		dq -6.0
d:              dq ?


_start:
; sys_write (rax = 1, rdi = (unsigned int fd), rsi = (const char *buf), rdx = (size_t count))
	mov rax, SYS_WRITE
	mov rdi, STDOUT
	mov rsi, message
	mov rdx, message_len
	syscall

	; Input ksys_read(unsigned int fd, char __user *buf, size_t count)
	
	; Calculation d = b^2 - 4ac
	fld dword [b]			; STACK: b
	fld dword [b]			; STACK: b b
	fmul				; STACK: b*b
	fld dword [four]		; STACK: b*b 4.0
	fld dword [a]			; STACK: b*b 4.0 a
	fld dword [c]			; STACK: b*b 4.0 a c
	fmul				; STACK: b*b 4.0 a*c
	fmul				; STACK: b*b 4.0*a*c
	fxch                            ; STACK: 4.0*a*c b*b 
	fsub				; STACK: (b*b - 4.0*a*c) == d
	
	
	; Calculation of x1,x2   x1 = (-b - sqr(d)) / 2*a
	; if d < 0 
	fldz
	fcomi
	jl exit
	; Calculate square root of d
        fsqrt          ; (Square root of ST(0))  :: sqr(d)
	fld dword [b]  ; :: sqr(d), b
	fchs           ; :: sqr(d), -b
	fsub           ; :: -b-sqr(d)
	fld dword [a]  ; :: -b-sqr(d), a
	fld dword [two]	; :: -b-sqr(d), a, 2.0
	fmul		; :: -b-sqr(d), 2a
	fxch            ; exchange contents of ST0 and ST1 :: 2a, -b-sqr(d)
	fdiv		; :: -b-sqr(d) / 2a
	fst rax		; rax := st0
	
	; Convert x1 to string buffer
	; ....
	; print
	
	mov rax, SYS_WRITE
	mov rdi, STDOUT
	mov rsi, r_message
	mov rdx, r_message_len
	syscall

	mov rax, SYS_EXIT
	syscall

exit:
	mov rax, SYS_WRITE
	mov rdi, STDOUT
	mov rsi, c_message
	mov rdx, c_message_len
	syscall

	mov rax, SYS_EXIT
	syscall
	

section .data

global _start

section .text
