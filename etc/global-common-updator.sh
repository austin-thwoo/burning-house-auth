#!/bin/bash
echo "======================================="
echo "        code-fist helper start..        "
echo "======================================="
cd ../src/main/java
globalcommon=(`ls -a | grep 'burning-house-global-common'`)
if [ -z ${globalcommon} ]; then
  echo "there is no global-common directory.."
  echo "make global-common.."
  mkdir burning-house-global-common
fi
cd burning-house-global-common
ls=(`ls -a | grep '.git'`)
if [ -z ${ls} ]; then
  echo "global common directory is not clone directory.."
  echo "remove global common .."
  cd ..
  rm -rf burning-house-global-common
  echo "start clone.."
  git clone https://github.com/austin-thwoo/burning-house-global-common.git
else
  echo "burnhouse directory is clone directory.."
  echo "start pull.."
  git pull https://github.com/austin-thwoo/burning-house-global-common.git
fi
echo "end.."
