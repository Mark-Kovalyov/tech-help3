# Periodic

## Upgrade OS
```bash
apt update
apt upgrade
```

## Upgrade PIP
```bash
pip install pip -U
```

## Upgrade Haskell/Stack
```
$ stack upgrade
Current Stack version: 2.9.3, available download version: 2.9.3
Skipping binary upgrade, you are already running the most recent version
```

## Upgrade databricks
```
$ pip install databricks -U
Defaulting to user installation because normal site-packages is not writeable
Requirement already satisfied: databricks in /home/mayton/.local/lib/python3.8/site-packages (0.2)
$ databricks -v
Version 0.17.3

```

## Upgrade AZ
```
az upgrade
This command is in preview and under development. Reference and support levels: https://aka.ms/CLI_refstatus
You already have the latest azure-cli version: 2.47.0
Upgrade finished.You can enable auto-upgrade with 'az config set auto-upgrade.enable=yes'. More details in https://docs.microsoft.com/cli/azure/update-azure-cli#automatic-update
```

## Upgrade AWS
```
$ pip install aws -U
Defaulting to user installation because normal site-packages is not writeable
Requirement already satisfied: aws in /home/mayton/.local/lib/python3.8/site-packages (0.2.5)
Requirement already satisfied: boto in /home/mayton/.local/lib/python3.8/site-packages (from aws) (2.49.0)
Requirement already satisfied: fabric>=1.6 in /home/mayton/.local/lib/python3.8/site-packages (from aws) (3.0.0)
Requirement already satisfied: prettytable>=0.7 in /home/mayton/.local/lib/python3.8/site-packages (from aws) (3.7.0)
Requirement already satisfied: invoke>=2.0 in /home/mayton/.local/lib/python3.8/site-packages (from fabric>=1.6->aws) (2.0.0)
Requirement already satisfied: paramiko>=2.4 in /home/mayton/.local/lib/python3.8/site-packages (from fabric>=1.6->aws) (3.1.0)
Requirement already satisfied: wcwidth in /home/mayton/.local/lib/python3.8/site-packages (from prettytable>=0.7->aws) (0.2.6)
Requirement already satisfied: bcrypt>=3.2 in /home/mayton/.local/lib/python3.8/site-packages (from paramiko>=2.4->fabric>=1.6->aws) (4.0.1)
Requirement already satisfied: cryptography>=3.3 in /home/mayton/.local/lib/python3.8/site-packages (from paramiko>=2.4->fabric>=1.6->aws) (40.0.2)
Requirement already satisfied: pynacl>=1.5 in /home/mayton/.local/lib/python3.8/site-packages (from paramiko>=2.4->fabric>=1.6->aws) (1.5.0)
Requirement already satisfied: cffi>=1.12 in /home/mayton/.local/lib/python3.8/site-packages (from cryptography>=3.3->paramiko>=2.4->fabric>=1.6->aws) (1.15.1)
Requirement already satisfied: pycparser in /home/mayton/.local/lib/python3.8/site-packages (from cffi>=1.12->cryptography>=3.3->paramiko>=2.4->fabric>=1.6->aws) (2.21)

$ aws
Traceback (most recent call last):
  File "/home/mayton/.local/bin/aws", line 5, in <module>
    from aws.main import main
  File "/home/mayton/.local/lib/python3.8/site-packages/aws/main.py", line 23
    print '%(name)s: %(endpoint)s' % {
          ^
SyntaxError: invalid syntax

$ whereis aws
aws: /usr/local/bin/aws /home/mayton/.local/bin/aws

$ /usr/local/aws-cli/v2/current/dist/aws -h
usage: aws [-h] [--profile PROFILE] [--debug]

optional arguments:
  -h, --help         show this help message and exit
  --profile PROFILE
  --debug

  $ pip uninstall aws
  Found existing installation: aws 0.2.5
  Uninstalling aws-0.2.5:
    Would remove:
      /home/mayton/.local/bin/aws
      /home/mayton/.local/lib/python3.8/site-packages/aws-0.2.5.dist-info/*
      /home/mayton/.local/lib/python3.8/site-packages/aws/*
  Proceed (Y/n)? Y
    Successfully uninstalled aws-0.2.5

```
