# Security

## Known hosts
~/.ssh/known_hosts

## Digital Signature algorithms

https://medium.com/risan/upgrade-your-ssh-key-to-ed25519-c6e8d60d3c54

* DSA: It’s unsafe and even no longer supported since OpenSSH version 7, you need to upgrade it!
* RSA: It depends on key size. If it has 3072 or 4096-bit length, then you’re good. Less than that, you probably want to upgrade it. The 1024-bit length is even considered unsafe.
* ECDSA: It depends on how well your machine can generate a random number that will be used to create a signature. There’s also a trustworthiness concern on the NIST curves that being used by ECDSA.
* Ed25519: It’s the most recommended public-key algorithm available today!

### Generate GPG keys for Gihub signing
```
gpg --list-keys
gpg --full-generate-key
....
   (1) RSA and RSA (default)
   (2) DSA and Elgamal
   (3) DSA (sign only)
   (4) RSA (sign only)
....

gpg --list-keys
gpg --list-secret-keys --keyid-format=long
gpg --armor --export <key digest here>
```
configure git
```
git config --global user.signingkey <key digest here>
```

### Utils

```
$ ssh-keygen --help
unknown option -- -
usage: ssh-keygen [-q] [-b bits] [-C comment] [-f output_keyfile] [-m format]
                  [-t dsa | ecdsa | ecdsa-sk | ed25519 | ed25519-sk | rsa]
                  [-N new_passphrase] [-O option] [-w provider]
       ssh-keygen -p [-f keyfile] [-m format] [-N new_passphrase]
                   [-P old_passphrase]
       ssh-keygen -i [-f input_keyfile] [-m key_format]
       ssh-keygen -e [-f input_keyfile] [-m key_format]
       ssh-keygen -y [-f input_keyfile]
       ssh-keygen -c [-C comment] [-f keyfile] [-P passphrase]
       ssh-keygen -l [-v] [-E fingerprint_hash] [-f input_keyfile]
       ssh-keygen -B [-f input_keyfile]
       ssh-keygen -D pkcs11
       ssh-keygen -F hostname [-lv] [-f known_hosts_file]
       ssh-keygen -H [-f known_hosts_file]
       ssh-keygen -K [-w provider]
       ssh-keygen -R hostname [-f known_hosts_file]
       ssh-keygen -r hostname [-g] [-f input_keyfile]
       ssh-keygen -M generate [-O option] output_file
       ssh-keygen -M screen [-f input_file] [-O option] output_file
       ssh-keygen -I certificate_identity -s ca_key [-hU] [-D pkcs11_provider]
                  [-n principals] [-O option] [-V validity_interval]
                  [-z serial_number] file ...
       ssh-keygen -L [-f input_keyfile]
       ssh-keygen -A [-f prefix_path]
       ssh-keygen -k -f krl_file [-u] [-s ca_public] [-z version_number]
                  file ...
       ssh-keygen -Q -f krl_file file ...
       ssh-keygen -Y find-principals -s signature_file -f allowed_signers_file
       ssh-keygen -Y check-novalidate -n namespace -s signature_file
       ssh-keygen -Y sign -f key_file -n namespace file ...
       ssh-keygen -Y verify -f allowed_signers_file -I signer_identity
    	-n namespace -s signature_file [-r revocation_file]
```
example
```
$ ssh-keygen -o -a 100 -t ed25519 -f ~/.ssh/id_ed25519 -C "user@email.com"
```

## Generate certificate request

## HMAC

