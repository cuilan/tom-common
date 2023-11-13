#!/bin/bash

# Get current branch
br=$(git branch | grep "*")

echo -e "\033[0;32mAuto commit and push to branch: [${br/* /}] \033[0m"

# Add changes to git.
git add .

# Get current dir git config user name
name=$(git config user.name)

# Commit changes.
msg="auto commit and push by ${name} on $(date +'%Y-%m-%d %H:%M:%S')"

if [ $# -eq 1 ]; then
  msg="$1"
fi
git commit -m "$msg"

# Push source and build repos.
git push -u origin ${br/* /}
