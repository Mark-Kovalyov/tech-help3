# Git

## Squash commits
```

```

## Configure
```
git config core.autocrlf true
git config user.name "Rupert Murdoch"
git config user.email rupert.murdoch@gmail.com

```

## Show log

```
git log --pretty
```

### Single line
```
git show -s --format='%B' $sha1
```
### with date
```
git log --pretty=format:"%h %ad %s" --date=iso-local
```


### with ISO-local date
```
git log --date=iso-local
```

### formatted
```
git log --format=oneline|short|medium|full|fuller|reference|email|raw|format:<string>
```
### with format
```
git log --format=format: --date=format
```
### examples
```
git log --date=iso-local --pretty=format:'%h : %s'
```


## Large File Storage (LFS)

### Drop big files from history

#### BFG repo cleaner ?

https://rtyley.github.io/bfg-repo-cleaner/



## Generate new key for Github

### Checking for existing GPG keys (or generate new pair)
```
$ gpg --list-secret-keys --keyid-format=long
-------------------------------
sec   rsa4096/6F264D643644A782 2021-09-20 [SC] [expired: 2022-09-20]
      1420F477ED3335D294322............
uid                 [ expired] User Name (RSA-4096 bit for Git)
```
### Locate key id and export public key into ascii-text
```
$ gpg --armor --export 6F264D643644A782
```
## Clone with git@ protocol
```
git clone git@github.com:User-Name/Project-Name.git
```

## Configure Auro-Cr-Lf

```
git config --local core.autocrlf true
```
