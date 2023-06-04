# Sample

# mvnget.py [coordinates] [command] [[repo_code]] [[dest]]
# where command = { jar|pom|src|doc }

# mvnget.py commons-codec:commons-codec:1.14 jar mvn
#


import os
import requests
import shutil
import sys

from pathlib import Path
from sys import platform

repos = {
 "mvn"   : "https://repo1.maven.org/maven2",
 "ld"    : "http://logicaldoc.sourceforge.net/maven",
 "debug" : "http://localhost/maven2"
}

def user_home() -> str:
	if platform == "linux" or platform == "linux2":
		return str(Path.home())
	else:
		return str(Path.home()).replace('\\','/')

local_repo = user_home() + '/.m2/repository'

def get_dir(path : str) -> str:
	spl = path.split('/')
	return '/'.join(spl[0:-1])

scala_releases = ['2.10', '2.11', '2.12', '2.13', '3']


def download_scala(vendor : str, arti : str, scala_version : str, version : str, package : str) -> bool:
	tail = vendor.replace('.','/') + '/' + arti + '_' + scala_version + '/' + version + '/' + arti + '_' + scala_version + '-' + version
	return True


def download_raw(vendor : str, arti : str, version : str, package : str, repo_code : str, dest : str, src : str) -> bool:
	r = requests.get(src, stream=True)
	if (r.status_code == 200):
		Path(get_dir(dest)).mkdir(parents=True, exist_ok=True)
		bytes_content = r.content
		with open(dest,'wb') as f:
			f.write(bytes_content)
			print('Saved ', len(bytes_content), ' bytes into file ', dest)
		return True
	else:
		print('Something going wrong. Code = ', r.status_code, ' message = ', r.reason, '\n')
		return False
	return True

def download(vendor : str, arti : str, version : str, package : str, repo_code : str, dest : str) -> bool:
	mvn_repo = repos[repo_code]
	tail = vendor.replace('.','/') + '/' + arti + '/' + version + '/' + arti + '-' + version + package
	src  = mvn_repo + '/' + tail
	print('src = ', src , '\n')
	if dest is None:
		dest = local_repo + '/' + tail
	else:
		dest = '.' + '/' + arti + '-' + version + package
	return download_raw(vendor, arti, version, package, repo_code, dest, src)


def main():
	print("Arguments: ", sys.argv)
	repo_code = 'mvn'
	spl     = sys.argv[1].split(':')
	vendor  = spl[0]
	arti    = spl[1]
	version = spl[2]
	command = sys.argv[2]
	dest    = None
	if len(sys.argv) >= 4:
		repo_code = sys.argv[3].strip() # TODO: What 'strip' is for?
		selected_repo = repos[repo_code]
		print("Selected repo : ", selected_repo, " by code", repo_code, "\n")
		if len(sys.argv) >= 5:
			dest = sys.argv[4].strip()
	else:
		print("Selected repo by default : ", selected_repo['mvn'])

	if command == 'jar':
		download(vendor,arti,version,'.jar', repo_code, dest)
	elif command == 'pom':
		download(vendor,arti,version,'.pom', repo_code, dest)
	elif command == 'src':
		download(vendor,arti,version,'-sources.jar', repo_code, dest)
	elif command == 'doc':
		download(vendor,arti,version,'-javadoc.jar', repo_code, dest)
	else:
		print('Unknown command ', command)


if __name__ == "__main__":
    main()
