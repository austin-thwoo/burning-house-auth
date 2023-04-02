#!/bin/bash
echo "======================================="
echo "        code-fist helper start..        "
echo "======================================="
cd ../src/main/java/*/*/*
globalcommon=(`ls -a | grep 'globalCommon'`)
if [ -z ${globalcommon} ]; then
  echo "there is no global-common directory.."
  echo "make global-common.."
  mkdir globalCommon
fi
cd globalCommon
ls=(`ls -a | grep '.git'`)
if [ -z ${ls} ]; then
  echo "global common directory is not clone directory.."
  echo "remove global common .."
  cd ..
  rm -rf globalCommon
  echo "start clone.."
  git clone https://github.com/austin-thwoo/globalCommon.git
else
  echo "burnhouse directory is clone directory.."
  echo "start pull.."
  git pull https://github.com/austin-thwoo/globalCommon.git
fi
echo "end.."
