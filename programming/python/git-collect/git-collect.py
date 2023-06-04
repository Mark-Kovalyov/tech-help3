import os
from subprocess import Popen, PIPE

def go(name):
    lst : list = os.listdir(name)
    for item in lst:
        if os.path.isdir(name + "/" + item):
            if os.path.exists(name + "/" + item + "/.git"):
                os.chdir(name + "/" + item)
                process = Popen(["git", "config", "-l"], stdout=PIPE)
                (output, err) = process.communicate()
                exit_code = process.wait()
                if exit_code == 0:
                    output_str = str(output, 'UTF-8')
                    split = output_str.split('\n')
                    for spl in split:
                        PREFIX = 'remote.origin.url='
                        if spl.startswith(PREFIX):
                            print(spl[len(PREFIX):])

if __name__ == '__main__':
    go("~/git")
