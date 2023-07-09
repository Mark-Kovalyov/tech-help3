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
or
```
git config core.autocrlf input
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

## Ignore list for Rust
```
debug/
target/

**/*.rs.bk
*.pdb
```
## Ignore list for Scala
```
*.class
*.log
hs_err_pid*
```

## Ignore list for Python
```
*.py[cod]
*$py.class

# C extensions
*.so

# Distribution / packaging
.Python
build/
develop-eggs/
dist/
downloads/
eggs/
.eggs/
lib/
lib64/
parts/
sdist/
var/
wheels/
share/python-wheels/
*.egg-info/
.installed.cfg
*.egg
MANIFEST

# PyInstaller
into it.
*.manifest
*.spec

# Installer logs
pip-log.txt
pip-delete-this-directory.txt

# Unit test / coverage reports
htmlcov/
.tox/
.nox/
.coverage
.coverage.*
.cache
nosetests.xml
coverage.xml
*.cover
*.py,cover
.hypothesis/
.pytest_cache/
cover/

# Translations
*.mo
*.pot

# Django stuff:
*.log
local_settings.py
db.sqlite3
db.sqlite3-journal

# Flask stuff:
instance/
.webassets-cache

# Scrapy stuff:
.scrapy

# Sphinx documentation
docs/_build/

# PyBuilder
.pybuilder/
target/

# Jupyter Notebook
.ipynb_checkpoints

# IPython
profile_default/
ipython_config.py

# pdm
.pdm.toml

# PEP 582; used by e.g. github.com/David-OConnor/pyflow and github.com/pdm-project/pdm
__pypackages__/

# Celery stuff
celerybeat-schedule
celerybeat.pid

# SageMath parsed files
*.sage.py

# Environments
.env
.venv
env/
venv/
ENV/
env.bak/
venv.bak/

# Spyder project settings
.spyderproject
.spyproject

# Rope project settings
.ropeproject

# mkdocs documentation
/site

# mypy
.mypy_cache/
.dmypy.json
dmypy.json

# Pyre type checker
.pyre/

# pytype static type analyzer
.pytype/

# Cython debug symbols
cython_debug/

# PyCharm
.idea/
```
