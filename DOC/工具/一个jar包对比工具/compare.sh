#!/bin/sh

BASE_PATH=/Users/sunyawei3/Desktop/临时文件/比对
NEW=new
OLD=old

compare(){
 echo "=================================开始以 ${COMPARE_BASE} 目录为基准检测==========================="
 for file in `ls ${BASE_PATH}/${COMPARE_BASE}/lib`;do
  if [ ! -e ${BASE_PATH}/${COMPARE_TO}/lib/${file} ]; then
   echo ">>>>>>> fileName:${file} 仅在 ${COMPARE_BASE} 包存在"
  fi
  #if [ -e ${BASE_PATH}/${COMPARE_TO}/lib/${file} ]; then
  # echo "fileName:${file} 在 ${COMPARE_BASE} 包和 ${COMPARE_TO} 包都存在"
  #else
  # echo ">>>>>>> fileName:${file} 仅在 ${COMPARE_BASE} 包存在"
  #fi
 done
}


COMPARE_BASE=${NEW}
COMPARE_TO=${OLD}

compare

COMPARE_BASE=${OLD}
COMPARE_TO=${NEW}

compare